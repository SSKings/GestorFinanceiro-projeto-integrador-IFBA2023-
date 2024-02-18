/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.model.dto.FonteDto;
import br.com.sskings.app.gestor.financeiro.model.dto.LancamentoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.TipoLancamentoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sskings
 */
public class LancamentoDao {

    private final GerenciadorBD gerenciadorBd;

    public LancamentoDao() {
        this.gerenciadorBd = new GerenciadorBD();
    }

    public void cadastrar(LancamentoDto lancamento) throws Exception {
        try (Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO lancamento (valor, tipo_id, usuario_id, fonte_id, cartao_conta_id, data_lancamento) VALUES (?,?,?,?,?,?)"
        )) {
            ps.setDouble(1, lancamento.getValor());
            ps.setInt(2, lancamento.getTipo().getId());
            ps.setInt(3, lancamento.getUsuario().getId());
            ps.setInt(4, lancamento.getFonte().getId());
            ps.setInt(5, lancamento.getCartaoOuContaId());
            Date sqlDate = Date.valueOf(LocalDate.now(ZoneId.systemDefault()));
            ps.setDate(6, sqlDate);
            ps.executeUpdate();
        }
    }

    public List<LancamentoDto> listar(UsuarioDto usuarioLogado) throws Exception {

        List<LancamentoDto> listaLancamentos = new ArrayList<>();

        try (Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "SELECT l.id, l.valor, l.cartao_conta_id, l.data_lancamento, tl.nome, f.nome "
                + "FROM lancamento l "
                + "JOIN tipo_lancamento tl ON l.tipo_id = tl.id "
                + "JOIN fonte f ON l.fonte_id = f.id "
                + "WHERE l.usuario_id = ? "
                + "ORDER BY l.data_lancamento")) {

            ps.setInt(1, usuarioLogado.getId());
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                LancamentoDto lancamento = new LancamentoDto();
                lancamento.setId(resultado.getInt("id"));
                lancamento.setValor(resultado.getDouble("valor"));
                lancamento.setCartaoOuContaId(resultado.getInt("cartao_conta_id"));
                lancamento.setData(resultado.getDate("data_lancamento").toLocalDate());

                TipoLancamentoDto tipo = new TipoLancamentoDto();
                tipo.setNome(resultado.getString("tl.nome"));

                lancamento.setTipo(tipo);
                FonteDto fonte = new FonteDto();

                fonte.setNome(resultado.getString("f.nome"));
                lancamento.setFonte(fonte);

                listaLancamentos.add(lancamento);

            }

        }

        return listaLancamentos;

    }
    
    public void excluir(LancamentoDto lancamento) throws Exception{
        try(Connection con = gerenciadorBd.conectar(); 
                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM lancamento WHERE lancamento.usuario_id = ? AND lancamento.id = ?"))
        {
            ps.setInt(1, lancamento.getUsuario().getId());
            ps.setInt(2, lancamento.getId());
            ps.executeUpdate();
        }
    }
    
    public void excluirTudo(LancamentoDto lancamento) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); 
                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM lancamento WHERE lancamento.usuario_id = ?"))
        {
            ps.setInt(1, lancamento.getUsuario().getId());
            ps.executeUpdate();
        }
    }

    public List<LancamentoDto> pesquisarPorAtributos(LancamentoDto lancamento) throws Exception {

        List<LancamentoDto> lancamentos = new ArrayList<>();

        try (Connection con = gerenciadorBd.conectar()) {
            StringBuilder consulta = new StringBuilder(
                    "SELECT l.id, l.valor, l.tipo_id, l.usuario_id, l.fonte_id, l.cartao_conta_id, l.data_lancamento, "
                    + "t.nome, f.nome "
                    + "FROM lancamento l "
                    + "INNER JOIN tipo_lancamento t ON l.tipo_id = t.id "
                    + "INNER JOIN fonte f ON l.fonte_id = f.id "
                    + "WHERE l.usuario_id = ?"
            );

            if (lancamento.getValor() != null) {
                consulta.append(" AND l.valor = ? ");
            } else if (lancamento.getData()!= null) {
                consulta.append(" AND l.data_lancamento = ? ");
            } else if (!lancamento.getTipo().getNome().isBlank()) {
                consulta.append(" AND t.nome = ? ");
            }
            
            consulta.append("ORDER BY l.data_lancamento");

            PreparedStatement ps = con.prepareStatement(consulta.toString());
            ps.setInt(1, lancamento.getUsuario().getId());

            int indice = 2;
            
            if (lancamento.getValor() != null) {
                ps.setDouble(indice++, lancamento.getValor());
                
            } else if (lancamento.getData() != null) {
                LocalDate data = LocalDate.parse(lancamento.getData().toString(), 
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                Date sqlDate = Date.valueOf(data);
                ps.setDate(indice, sqlDate );
                
            } else if (!lancamento.getTipo().getNome().isBlank()) {
                ps.setString(indice, lancamento.getTipo().getNome());
            }

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                LancamentoDto l = new LancamentoDto();
                l.setId(resultado.getInt("l.id"));
                l.setValor(resultado.getDouble("l.valor"));
                l.setCartaoOuContaId(resultado.getInt("l.cartao_conta_id"));

                l.setData(resultado.getDate("l.data_lancamento").toLocalDate());

                l.getTipo().setId(resultado.getInt("l.tipo_id"));
                l.getTipo().setNome(resultado.getString("t.nome"));
                l.getFonte().setId(resultado.getInt("l.fonte_id"));
                l.getFonte().setNome(resultado.getString("f.nome"));

                lancamentos.add(l);

            }
        }

        return lancamentos;
    }

    public List<LancamentoDto> pesquisarPorReceita(UsuarioDto usuarioLogado) throws Exception {

        List<LancamentoDto> lancamentos = new ArrayList<>();

        try (Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "SELECT l.id, l.valor, l.tipo_id, l.usuario_id, l.fonte_id, l.cartao_conta_id, l.data_lancamento, "
                + "t.nome, f.nome "
                + "FROM lancamento l "
                + "JOIN tipo_lancamento t ON l.tipo_id = t.id "
                + "JOIN fonte f ON l.fonte_id = f.id "
                + "WHERE t.nome = 'RECEITA' AND l.usuario_id = ? "
                + "ORDER BY l.data_lancamento"
        )) {

            ps.setInt(1, usuarioLogado.getId());
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                LancamentoDto l = new LancamentoDto();
                l.setId(resultado.getInt("l.id"));
                l.setValor(resultado.getDouble("l.valor"));
                l.setCartaoOuContaId(resultado.getInt("l.cartao_conta_id"));

                l.setData(resultado.getDate("l.data_lancamento").toLocalDate());

                l.getTipo().setId(resultado.getInt("l.tipo_id"));
                l.getTipo().setNome(resultado.getString("t.nome"));
                l.getFonte().setId(resultado.getInt("l.fonte_id"));
                l.getFonte().setNome(resultado.getString("f.nome"));

                lancamentos.add(l);

            }
        }

        return lancamentos;
    }

    public List<LancamentoDto> pesquisarPorDespesa(UsuarioDto usuarioLogado) throws Exception {

        List<LancamentoDto> lancamentos = new ArrayList<>();

        try (Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "SELECT l.id, l.valor, l.tipo_id, l.usuario_id, l.fonte_id, l.cartao_conta_id, l.data_lancamento, "
                + "t.nome, f.nome "
                + "FROM lancamento l "
                + "JOIN tipo_lancamento t ON l.tipo_id = t.id "
                + "JOIN fonte f ON l.fonte_id = f.id "
                + "WHERE t.nome = 'DESPESA' AND l.usuario_id = ? "
                + "ORDER BY l.data_lancamento"
        )) {

            ps.setInt(1, usuarioLogado.getId());
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                LancamentoDto l = new LancamentoDto();
                l.setId(resultado.getInt("l.id"));
                l.setValor(resultado.getDouble("l.valor"));
                l.setCartaoOuContaId(resultado.getInt("l.cartao_conta_id"));

                l.setData(resultado.getDate("l.data_lancamento").toLocalDate());

                l.getTipo().setId(resultado.getInt("l.tipo_id"));
                l.getTipo().setNome(resultado.getString("t.nome"));
                l.getFonte().setId(resultado.getInt("l.fonte_id"));
                l.getFonte().setNome(resultado.getString("f.nome"));

                lancamentos.add(l);

            }
        }

        return lancamentos;
    }

    public List<LancamentoDto> pesquisarPorCartao(UsuarioDto usuarioLogado) throws Exception {

        List<LancamentoDto> lancamentos = new ArrayList<>();

        try (Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "SELECT l.id, l.valor, l.tipo_id, l.usuario_id, l.fonte_id, l.cartao_conta_id, l.data_lancamento, "
                + "t.nome, f.nome "
                + "FROM lancamento l "
                + "JOIN tipo_lancamento t ON l.tipo_id = t.id "
                + "JOIN fonte f ON l.fonte_id = f.id "
                + "WHERE f.nome = 'CARTAO_DE_CREDITO' AND l.usuario_id = ? "
                + "ORDER BY l.data_lancamento"
        )) {

            ps.setInt(1, usuarioLogado.getId());
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                LancamentoDto l = new LancamentoDto();
                l.setId(resultado.getInt("l.id"));
                l.setValor(resultado.getDouble("l.valor"));
                l.setCartaoOuContaId(resultado.getInt("l.cartao_conta_id"));

                l.setData(resultado.getDate("l.data_lancamento").toLocalDate());

                l.getTipo().setId(resultado.getInt("l.tipo_id"));
                l.getTipo().setNome(resultado.getString("t.nome"));
                l.getFonte().setId(resultado.getInt("l.fonte_id"));
                l.getFonte().setNome(resultado.getString("f.nome"));

                lancamentos.add(l);

            }
        }

        return lancamentos;
    }

    public List<LancamentoDto> pesquisarPorConta(UsuarioDto usuarioLogado) throws Exception {

        List<LancamentoDto> lancamentos = new ArrayList<>();

        try (Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "SELECT l.id, l.valor, l.tipo_id, l.usuario_id, l.fonte_id, l.cartao_conta_id, l.data_lancamento, "
                + "t.nome, f.nome "
                + "FROM lancamento l "
                + "JOIN tipo_lancamento t ON l.tipo_id = t.id "
                + "JOIN fonte f ON l.fonte_id = f.id "
                + "WHERE f.nome = 'CONTA_BANCARIA' AND l.usuario_id = ? "
                + "ORDER BY l.data_lancamento"
        )) {

            ps.setInt(1, usuarioLogado.getId());
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                LancamentoDto l = new LancamentoDto();
                l.setId(resultado.getInt("l.id"));
                l.setValor(resultado.getDouble("l.valor"));
                l.setCartaoOuContaId(resultado.getInt("l.cartao_conta_id"));

                l.setData(resultado.getDate("l.data_lancamento").toLocalDate());

                l.getTipo().setId(resultado.getInt("l.tipo_id"));
                l.getTipo().setNome(resultado.getString("t.nome"));
                l.getFonte().setId(resultado.getInt("l.fonte_id"));
                l.getFonte().setNome(resultado.getString("f.nome"));

                lancamentos.add(l);

            }
        }

        return lancamentos;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.model.dto.BancoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.CartaoCreditoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s
 */
public class CartaoCreditoDao {

    private final GerenciadorBD gerenciadorBd;

    public CartaoCreditoDao() {
        this.gerenciadorBd = new GerenciadorBD();
    }

    public void cadastrar(CartaoCreditoDto cartao) throws Exception {

        try (Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO cartao_credito(numero, usuario_id, banco_id, "
                        + "vencimento, limite, limite_disponivel) VALUES (?,?,?,?,?,?)")) {
            ps.setLong(1, cartao.getNumero());
            ps.setInt(2, cartao.getUsuario().getId());
            ps.setInt(3, cartao.getBanco().getId());
            LocalDate data = cartao.getVencimento();
            Date sqlDate = Date.valueOf(data);
            ps.setDate(4, sqlDate);
            ps.setDouble(5, cartao.getLimite());
            ps.setDouble(6, cartao.getLimite_disponivel());
            ps.executeUpdate();
        }
    }

    public List<CartaoCreditoDto> listar(UsuarioDto usuarioLogado) throws Exception {

        List<CartaoCreditoDto> listaDeCartoes = new ArrayList<>();

        try (Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "SELECT c.id, c.numero, c.vencimento, c.limite, c.limite_disponivel, banco.id, banco.nome, banco.codigo "
                        + "FROM cartao_credito c "
                        + "JOIN banco ON c.banco_id = banco.id "
                        + "WHERE c.usuario_id = ?;")) {

           

            ps.setInt(1, usuarioLogado.getId());
            ResultSet tabela = ps.executeQuery();

            
                while (tabela.next()) {

                    CartaoCreditoDto cartao = new CartaoCreditoDto();
                    cartao.setId(tabela.getInt("id"));
                    cartao.setNumero(tabela.getLong("numero"));
                    Date sqlDate = tabela.getDate("vencimento");
                    cartao.setVencimento(sqlDate.toLocalDate());
                    cartao.setLimite(tabela.getDouble("limite"));
                    cartao.setLimite_disponivel(tabela.getDouble("limite_disponivel"));

                    cartao.setUsuario(usuarioLogado);
                    BancoDto banco = new BancoDto();
                    banco.setId(tabela.getInt("banco.id"));
                    banco.setNome(tabela.getString("banco.nome"));
                    banco.setCodigo(tabela.getInt("banco.codigo"));
                    cartao.setBanco(banco);

                    listaDeCartoes.add(cartao);

                }       

        }

        return listaDeCartoes;
        
    }
    
    public void atualizar(CartaoCreditoDto cartao) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "UPDATE cartao_credito SET numero = ?, usuario_id = ?, vencimento = ?, limite = ? WHERE id = ?"
        ))
        {
            ps.setLong(1, cartao.getNumero());
            ps.setInt(2, cartao.getUsuario().getId());
            LocalDate data = cartao.getVencimento();
            Date sqlDate = Date.valueOf(data);
            ps.setDate(3, sqlDate);
            ps.setDouble(4, cartao.getLimite());
            ps.setInt(5, cartao.getId());
            ps.executeUpdate();
            
        }
        
    }
     
    public void excluir(CartaoCreditoDto cartao) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); 
                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM cartao_credito WHERE cartao_credito.usuario_id = ? AND cartao_credito.id = ?"))
        {
            ps.setInt(1, cartao.getUsuario().getId());
            ps.setInt(2, cartao.getId());
            ps.executeUpdate();
        }
    }

    public CartaoCreditoDto pesquisarPorId(CartaoCreditoDto cartao) throws Exception  {
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "SELECT cc.numero, cc.usuario_id, cc.banco_id, cc.vencimento, cc.limite, cc.limite_disponivel, b.nome, b.codigo "
                                + "FROM cartao_credito cc "
                                + "INNER JOIN banco b ON cc.banco_id = b.id "
                                + "WHERE cc.id = ? AND cc.usuario_id = ?"
                ))
        {
            ps.setInt(1, cartao.getId());
            ps.setInt(2, cartao.getUsuario().getId());
            ResultSet resultado = ps.executeQuery();
            
            while(resultado.next()){
                
                cartao.setNumero(resultado.getLong("cc.numero"));
                cartao.getUsuario().setId(resultado.getInt("cc.usuario_id"));
                cartao.getBanco().setId(resultado.getInt("cc.banco_id"));
                cartao.getBanco().setNome(resultado.getString("b.nome"));
                cartao.setVencimento(resultado.getDate("cc.vencimento").toLocalDate());
                cartao.setLimite(resultado.getDouble("cc.limite"));
                cartao.setLimite_disponivel(resultado.getDouble("cc.limite_disponivel"));
                
            }
        }
        return cartao;
    }
    
    public void atualizarLimiteDisponivel(CartaoCreditoDto cartao) throws Exception {
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE cartao_credito SET limite_disponivel = ? "
                                + "WHERE id = ?"
                ))
        {
            ps.setDouble(1, cartao.getLimite_disponivel());
            ps.setInt(2, cartao.getId());
            ps.executeUpdate();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.model.dto.AgenciaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.BancoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.ContaBancariaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s
 */
public class ContaBancariaDao {
    
    private final GerenciadorBD gerenciadorBd;
    
    public ContaBancariaDao(){
        this.gerenciadorBd = new GerenciadorBD();
    }
    
    public void cadastrar(ContaBancariaDto conta ) throws Exception {
        
        try(Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO conta (numero, saldo, usuario_id, agencia_id) VALUES (?,?,?,?)"
        ))
        {
            ps.setLong(1, conta.getNumero());
            ps.setDouble(2, conta.getSaldo());
            ps.setInt(3, conta.getUsuario().getId());
            ps.setInt(4, conta.getAgencia().getId());
            
            ps.executeUpdate();
        }
    }

    public List<ContaBancariaDto> listar(UsuarioDto usuarioLogado) throws Exception {
        
        List<ContaBancariaDto> listaDeContas = new ArrayList<>();
        
        try(Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
               "SELECT cb.id , cb.numero, cb.saldo, ag.id, ag.codigo, " +
                         "b.id, b.nome, u.email " +
                         "FROM conta cb " +
                         "JOIN agencia ag ON cb.agencia_id = ag.id " +
                         "JOIN banco b ON ag.banco_id = b.id " +
                         "JOIN usuario u ON cb.usuario_id = u.id " +
                         "WHERE cb.usuario_id = ?" ))
        {
            ps.setInt(1, usuarioLogado.getId());
            ResultSet resultSet = ps.executeQuery();
            
            while(resultSet.next()){
                BancoDto banco = new BancoDto(resultSet.getInt("b.id"), resultSet.getString("b.nome"), null);
                AgenciaDto agencia = new AgenciaDto(resultSet.getInt("ag.id") , resultSet.getInt("ag.codigo"), banco);
                Integer id = resultSet.getInt("cb.id");
                Long numero = resultSet.getLong("cb.numero");
                Double saldo = resultSet.getDouble("cb.saldo");
                ContaBancariaDto conta = new ContaBancariaDto(id, numero, usuarioLogado, agencia, saldo);
                
                listaDeContas.add(conta);
            }
        }
        
        return listaDeContas;
    }
    
    public void atualizar(ContaBancariaDto conta) throws Exception {
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE conta SET numero = ?, usuario_id = ?, agencia_id = ?, saldo = ?"
                                + "WHERE id = ?")
            )
        {
            ps.setLong(1, conta.getNumero());
            ps.setInt(2, conta.getUsuario().getId());
            ps.setInt(3, conta.getAgencia().getId());
            ps.setDouble(4, conta.getSaldo());
            ps.setInt(5, conta.getId());
            ps.executeUpdate();
        }
    }
    
    public void excluir(ContaBancariaDto conta) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); 
                PreparedStatement ps = con.prepareStatement(
                "DELETE FROM conta WHERE conta.usuario_id = ? "
                        + "AND conta.id = ?"
        ))
        {
            ps.setInt(1, conta.getUsuario().getId());
            ps.setInt(2, conta.getId());
            ps.executeUpdate();
        }
    }

    public ContaBancariaDto pesquisarPorId(ContaBancariaDto conta) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); 
                PreparedStatement ps = con.prepareStatement(
                "SELECT c.numero, c.usuario_id, c.agencia_id, c.saldo, b.id, b.nome "
                        + "FROM conta c "
                        + "INNER JOIN agencia a ON c.agencia_id = a .id "
                        + "INNER JOIN banco b ON a.banco_id = b.id "
                        + "WHERE c.id = ?"
        ))
        {
            ps.setInt(1, conta.getId());
            ResultSet resultado = ps.executeQuery();
            
            while(resultado.next()){
                conta.setNumero(resultado.getLong("c.numero"));
                conta.getUsuario().setId(resultado.getInt("c.usuario_id"));
                conta.getAgencia().setId(resultado.getInt("c.agencia_id"));
                conta.setSaldo(resultado.getDouble("c.saldo"));
                conta.getAgencia().getBanco().setId(resultado.getInt("b.id"));
                conta.getAgencia().getBanco().setNome(resultado.getString("b.nome"));
            }
        }
        return conta;
    }
    

    public void atualizarSaldoDisponivel(ContaBancariaDto conta) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); 
                PreparedStatement ps = con.prepareStatement(
                "UPDATE conta SET saldo = ? "
                        + "WHERE id = ?"
        ))
        {
            ps.setDouble(1, conta.getSaldo());
            ps.setInt(2, conta.getId());
            ps.executeUpdate();
        }
    }
}

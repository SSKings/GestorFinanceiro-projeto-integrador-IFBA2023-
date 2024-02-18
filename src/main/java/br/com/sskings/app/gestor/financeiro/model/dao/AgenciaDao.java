/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.model.dto.AgenciaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.BancoDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s
 */
public class AgenciaDao {
    
    private final GerenciadorBD gerenciadorBd;
    
    public AgenciaDao(){
        this.gerenciadorBd = new GerenciadorBD();
    }
    
    public int cadastrar(AgenciaDto agencia) throws Exception {
        
        try(Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO agencia (codigo, banco_id) VALUES (?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
        ))
        {
            ps.setInt(1, agencia.getCodigo());
            ps.setInt(2, agencia.getBanco().getId());
            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if(resultSet.next()){
                int agencia_id = resultSet.getInt(1);
                return agencia_id;
            } else {
                return 0;
            }
        }
        
    }
    
    public List<AgenciaDto> listar() throws Exception{
        
        List<AgenciaDto> agencias = new ArrayList<>();
        
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "SELECT ag.id, ag.codigo, ag.banco_id , b.nome, b.codigo FROM agencia ag "
                                + "INNER JOIN banco b ON ag.banco_id = b.id"
                ))
        {
            
            ResultSet resultado = ps.executeQuery();
            
            while(resultado.next()){
                
                AgenciaDto ag = new AgenciaDto();
                ag.setId(resultado.getInt("id"));
                ag.setCodigo(resultado.getInt("codigo"));
                ag.getBanco().setId(resultado.getInt("banco_id"));
                ag.getBanco().setNome(resultado.getString("b.nome"));
                ag.getBanco().setCodigo(resultado.getInt("b.codigo"));
                
                agencias.add(ag);
                               
            }
        }
        
        return agencias;
    }
    
    public List<AgenciaDto> listarPorBancos(AgenciaDto agencia) throws Exception {
        List<AgenciaDto> agencias = new ArrayList<>();
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "SELECT agencia.id, agencia.codigo FROM agencia "
                                + "WHERE agencia.banco_id = ?"
                ))
        {   
            ps.setInt(1, agencia.getBanco().getId());
            ResultSet resultado =  ps.executeQuery();
            while(resultado.next()){
                AgenciaDto a = new AgenciaDto();
                a.setId(agencia.getId());
                a.setId(resultado.getInt("id"));
                a.setCodigo(resultado.getInt("codigo"));
               
                agencias.add(a);
            }
        }
        
        
        return agencias;
    }
    
    public void atualizar(AgenciaDto agencia) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "UPDATE agencia SET codigo = ?, banco_id = ? WHERE id = ?;"
            )
        )
        {
            ps.setInt(1, agencia.getCodigo());
            ps.setInt(2, agencia.getBanco().getId());
            ps.setInt(3, agencia.getId());
            ps.executeUpdate();
            
        }
        
    }
    
    public void excluir(AgenciaDto agencia) throws Exception {
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM agencia WHERE id = ?"
                ))
        {
            ps.setInt(1, agencia.getId());
            ps.executeUpdate();
        }
    }
    
    public void excluirTudo() throws Exception {
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM agencia"
                ))
        {
            ps.executeUpdate();
        }
    }
    
    public AgenciaDto pesquisarPorId(AgenciaDto agencia) throws Exception {
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "SELECT a.codigo, b.id, b.nome, b.codigo FROM agencia a "
                                + "JOIN banco b ON a.banco_id = a.id "
                                + "WHERE a.id = ?"
                ))
        {
            ps.setInt(1, agencia.getId());
            ResultSet resultado = ps.executeQuery();
            
            while(resultado.next()){
                agencia.getBanco().setId(resultado.getInt("b.id"));
                agencia.getBanco().setNome(resultado.getString("b.nome"));
                agencia.getBanco().setCodigo(resultado.getInt("b.codigo"));
                agencia.setCodigo(resultado.getInt("a.codigo"));
            }
            
        }
        return agencia;
    }
}   

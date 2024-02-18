/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.model.dto.BancoDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sskings
 */
public class BancoDao {
    
    private final GerenciadorBD gerenciadorBd;

    public BancoDao() {
        this.gerenciadorBd = new GerenciadorBD();
    }
    
    public void cadastrar(BancoDto banco) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO banco (nome, codigo) VALUES (?,?)"
        ))
        {
            ps.setString(1, banco.getNome());
            ps.setInt(2, banco.getCodigo());
            ps.executeUpdate();
        }
    }
    
    public List<BancoDto> listar() throws Exception {
        List<BancoDto> bancos = new ArrayList<>();
        try(Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "SELECT id, nome, codigo FROM banco"
        ))
        {
            ResultSet dados = ps.executeQuery();
            while(dados.next()){
                BancoDto banco = new BancoDto();
                banco.setId(dados.getInt("id"));
                banco.setNome(dados.getString("nome"));
                banco.setCodigo(dados.getInt("codigo"));
                
                bancos.add(banco);
            }
            
        }
        return bancos;
    }
    
    public void atualizar(BancoDto banco) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); PreparedStatement ps = con.prepareStatement(
                "UPDATE banco SET nome = ?, codigo = ? WHERE id = ?"
        ))
        {
            ps.setString(1, banco.getNome());
            ps.setInt(2, banco.getCodigo());
            ps.setInt(3, banco.getId());
            ps.executeUpdate();
        }
    }
    
    public void excluir(BancoDto banco) throws Exception {
        try(Connection con = gerenciadorBd.conectar(); 
                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM banco WHERE id = ?"))
        {
            ps.setInt(1, banco.getId());
            ps.executeUpdate();
        }
    }
    
    public BancoDto pesquisarPorId(BancoDto banco) throws Exception {
        try(Connection con = gerenciadorBd.conectar();
                PreparedStatement ps = con.prepareStatement(
                        "SELECT nome, codigo FROM banco WHERE id = ?"
                ))
        {
            ps.setInt(1, banco.getId());
            ResultSet resultado = ps.executeQuery();
            
            while(resultado.next()){
                banco.setNome(resultado.getString("nome"));
                banco.setCodigo(resultado.getInt("codigo"));
                
            }
            
            return banco;
        }
    }
    
}

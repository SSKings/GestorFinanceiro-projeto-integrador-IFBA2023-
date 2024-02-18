/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s
 */
public class UsuarioDao {
    
    private final GerenciadorBD gerenciadorBd;
    
    public UsuarioDao(){
        
        this.gerenciadorBd = new GerenciadorBD();
    }
    
    public void cadastrar(UsuarioDto usuario) throws Exception {
        
        try(Connection conn = gerenciadorBd.conectar();
                PreparedStatement comando = conn.prepareStatement(
                "INSERT INTO usuario (email, login, senha, data_criacao) VALUES (?,?,?,?)"))
        {
            comando.setString(1, usuario.getEmail());
            comando.setString(2, usuario.getLogin());
            comando.setString(3, usuario.getSenha());
            LocalDate novaData =  LocalDate.now();
            Date sqlDate = Date.valueOf(novaData);
            comando.setDate(4, sqlDate);
            comando.executeUpdate();
        }
    }
    
    public List<UsuarioDto> listar() throws Exception  {

        List<UsuarioDto> listaDeClientes = new ArrayList<>();

        try (Connection conexao = gerenciadorBd.conectar(); 
             PreparedStatement comando = conexao.prepareStatement(
             "SELECT id, email, login, senha, data_criacao FROM usuario");
             ResultSet tabela = comando.executeQuery()
            ) 
        {
            while (tabela.next()) {
                UsuarioDto usuario = new UsuarioDto();

                usuario.setId(tabela.getInt("id"));
                usuario.setEmail(tabela.getString("email"));
                usuario.setLogin(tabela.getString("login"));
                usuario.setSenha(tabela.getString("senha"));
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yyyy");
                usuario.setData(tabela.getDate("data_criacao").toLocalDate());

                listaDeClientes.add(usuario);
            }
        }

        return listaDeClientes;
    }

    public UsuarioDto pesquisar(UsuarioDto usuario) throws Exception {

        try (Connection conexao = gerenciadorBd.conectar(); 
             PreparedStatement comando = conexao.prepareStatement(
             "SELECT id, email, login, senha, data_criacao FROM usuario WHERE email = ? OR login = ?")
            ) 
        {
           
            comando.setString(1, usuario.getEmail());
            comando.setString(2, usuario.getLogin());
  
            ResultSet tabela = comando.executeQuery();

            boolean existeUsuario = false;
            
            if (tabela.next()) {
                
                usuario.setId(tabela.getInt("id"));
                usuario.setEmail(tabela.getString("email"));
                usuario.setLogin(tabela.getString("login"));
                usuario.setSenha(tabela.getString("senha"));
                usuario.setData(tabela.getDate("data_criacao").toLocalDate());
                
                existeUsuario = true;
            }
            
            if(!existeUsuario)
            {
                usuario.setId(0);
            }
        }
       
        return usuario;
    }

    public void alterar(UsuarioDto usuario) throws Exception {
        try (Connection conexao = gerenciadorBd.conectar(); 
             PreparedStatement comando = conexao.prepareStatement(
             "UPDATE usuario SET email = ?, login = ? WHERE id = ?")
            ) 
        {
            comando.setString(1, usuario.getEmail());
            comando.setString(2, usuario.getLogin());
            comando.setLong(3, usuario.getId());

            comando.executeUpdate();
        }
    }

    public void excluir(UsuarioDto usuario) throws Exception {
        try (Connection conexao = gerenciadorBd.conectar(); 
             PreparedStatement comando = conexao.prepareStatement(
             "DELETE FROM usuario WHERE id = ?")
            ) 
        {
            comando.setLong(1, usuario.getId());

            comando.executeUpdate();
        }
    }

}

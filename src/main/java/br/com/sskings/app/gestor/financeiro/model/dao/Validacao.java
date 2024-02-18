/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.criptografia.Criptografia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author s
 */
public class Validacao {

    private final GerenciadorBD gerenciadorBd;

    public Validacao() {

        this.gerenciadorBd = new GerenciadorBD();
    }

    public boolean validarUsuario(String login, char[] senha) throws Exception {

        boolean resultado = false;

        try (Connection conn = gerenciadorBd.conectar(); PreparedStatement statement = conn.prepareStatement(
                "SELECT id, email, login, senha FROM usuario WHERE login = ?")) {

            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String senhaCript = resultSet.getString("senha");
                resultado = Criptografia.validarSenha(senhaCript, senha);

            }

        }

        return resultado;
    }

    public boolean validarUsuarioPorEmail(String email, char[] senha) throws Exception {
       
        boolean resultado = false;

        try (Connection conn = gerenciadorBd.conectar(); PreparedStatement statement = conn.prepareStatement(
                "SELECT id, email, login, senha FROM usuario WHERE email = ?")) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String senhaCript = resultSet.getString("senha");
                resultado = Criptografia.validarSenha(senhaCript, senha);
                
            }

        }
        
        return resultado;
    }

}

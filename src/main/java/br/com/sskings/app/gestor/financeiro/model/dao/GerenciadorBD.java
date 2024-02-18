    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author s
 */
public class GerenciadorBD {
    
    private String DRIVER = "com.mysql.cj.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/";
    private String BD = "db";
    private String USUARIO = "root";
    private String SENHA = "12345";
    
    public Connection conectar() throws Exception {
        
        Class.forName(DRIVER);
        String txtConexao = URL + BD;
        
        return DriverManager.getConnection(txtConexao, USUARIO, SENHA);
        
    }
    
}

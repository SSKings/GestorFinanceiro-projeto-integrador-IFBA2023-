/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dto;


import java.time.LocalDate;


/**
 *
 * @author s
 */

public class UsuarioDto {
    

    private Integer id;
    
    private String email;
    
    private String login;
    
    private String senha;
    
    private LocalDate data;
    
    
    public UsuarioDto() {
    }

    public UsuarioDto(Integer id, String email, String login, String senha, LocalDate data) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    
  
    
}

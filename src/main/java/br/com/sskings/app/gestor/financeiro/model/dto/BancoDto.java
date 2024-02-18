/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dto;

/**
 *
 * @author s
 */
public class BancoDto {
    
    private Integer id;
    
    private String nome;
    
    private Integer codigo;

    public BancoDto() {
    }
    
    public BancoDto(Integer id, String nome, Integer codigo) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dto;

/**
 *
 * @author s
 */
public class AgenciaDto {
    
    private Integer id;
    
    private Integer codigo;
    
    private BancoDto banco;

    public AgenciaDto() {
        this.banco = new BancoDto();
    }
    
    public AgenciaDto(Integer id, Integer codigo, BancoDto banco) {
        this.id = id;
        this.codigo = codigo;
        this.banco = banco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BancoDto getBanco() {
        return banco;
    }

    public void setBanco(BancoDto banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return codigo.toString();
    }
    
    
    
    
    
}

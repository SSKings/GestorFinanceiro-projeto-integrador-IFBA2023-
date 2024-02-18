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
public class CartaoCreditoDto {
    
    private Integer id;
    
    private Long numero;
    
    private UsuarioDto usuario;
    
    private BancoDto banco;
    
    private LocalDate vencimento;
    
    private Double limite;
    
    private Double limite_disponivel;

    public CartaoCreditoDto() {
        this.banco = new BancoDto();
    }

    public CartaoCreditoDto(Integer id, Long numero, UsuarioDto usuario, BancoDto banco, LocalDate vencimento, Double limite, Double limite_disponivel) {
        this.id = id;
        this.numero = numero;
        this.usuario = usuario;
        this.banco = banco;
        this.vencimento = vencimento;
        this.limite = limite;
        this.limite_disponivel = limite_disponivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public BancoDto getBanco() {
        return banco;
    }

    public void setBanco(BancoDto banco) {
        this.banco = banco;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getLimite_disponivel() {
        return limite_disponivel;
    }

    public void setLimite_disponivel(Double limite_disponivel) {
        this.limite_disponivel = limite_disponivel;
    }
    
    
    
}

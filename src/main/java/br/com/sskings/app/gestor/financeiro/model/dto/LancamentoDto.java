/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dto;

import java.time.LocalDate;

/**
 *
 * @author sskings
 */
public class LancamentoDto {
    
    private Integer id;
    
    private Double valor;
    
    private UsuarioDto usuario;
    
    private TipoLancamentoDto tipo;
    
    private FonteDto fonte;
    
    private Integer cartaoOuContaId;
    
    private LocalDate data;

    public LancamentoDto() {
        this.tipo = new TipoLancamentoDto();
        this.fonte = new FonteDto();        
    }

    public LancamentoDto(Integer id, Double valor, UsuarioDto usuario, TipoLancamentoDto tipo, FonteDto fonte, Integer cartaoOuContaId, LocalDate data) {
        this.id = id;
        this.valor = valor;
        this.usuario = usuario;
        this.tipo = tipo;
        this.fonte = fonte;
        this.cartaoOuContaId = cartaoOuContaId;
        this.data = data;
    }

       
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public TipoLancamentoDto getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamentoDto tipo) {
        this.tipo = tipo;
    }

    public FonteDto getFonte() {
        return fonte;
    }

    public void setFonte(FonteDto fonte) {
        this.fonte = fonte;
    }

    public Integer getCartaoOuContaId() {
        return cartaoOuContaId;
    }

    public void setCartaoOuContaId(Integer cartaoOuContaId) {
        this.cartaoOuContaId = cartaoOuContaId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    
    
    
    
    

}
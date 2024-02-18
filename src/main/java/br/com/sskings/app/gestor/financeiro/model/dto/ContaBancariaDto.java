/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dto;

/**
 *
 * @author s
 */
public class ContaBancariaDto {
    
    private Integer id;
    
    private Long numero;
            
    private UsuarioDto usuario;
    
    private AgenciaDto agencia;
    
    private Double saldo;

    public ContaBancariaDto() {
        this.agencia = new AgenciaDto();
    }

    public ContaBancariaDto(Integer id, Long numero, UsuarioDto usuario, AgenciaDto agencia, Double saldo) {
        this.id = id;
        this.numero = numero;
        this.usuario = usuario;
        this.agencia = agencia;
        this.saldo = saldo;
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

    public AgenciaDto getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaDto agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    
    
}

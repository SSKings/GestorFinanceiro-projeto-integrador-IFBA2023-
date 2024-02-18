/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.model.dto.TipoLancamentoDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author sskings
 */
public class TipoLancamentoDao {
    
    private final GerenciadorBD gerenciadorBd;

    public TipoLancamentoDao() {
        this.gerenciadorBd = new GerenciadorBD();
    }
    
    public List<TipoLancamentoDto> listar() throws Exception {
        
        List<TipoLancamentoDto> tipos = new ArrayList<>();
        
        try(Connection con = gerenciadorBd.conectar(); 
                PreparedStatement ps = con.prepareStatement(
                "SELECT id, nome FROM tipo_lancamento;"); 
                ResultSet resultado = ps.executeQuery())
        {
             while(resultado.next()){
                TipoLancamentoDto tipo = new TipoLancamentoDto();
                tipo.setId(resultado.getInt("id"));
                tipo.setNome(resultado.getString("nome"));
                
                tipos.add(tipo);
             }
        }
        return tipos; 
    }
    
}

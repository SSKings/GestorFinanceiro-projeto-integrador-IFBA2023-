/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.model.dao;

import br.com.sskings.app.gestor.financeiro.model.dto.FonteDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sskings
 */
public class FonteDao {
    
    private final GerenciadorBD gerenciadorBr;

    public FonteDao() {
        this.gerenciadorBr = new GerenciadorBD();
    }   
    
    public List<FonteDto> listar() throws Exception {
        List<FonteDto> fontes = new ArrayList<>();
        
        try(Connection con = gerenciadorBr.conectar(); PreparedStatement ps = con.prepareStatement(
                "SELECT id, nome FROM fonte;"); 
            ResultSet resultado = ps.executeQuery())
        {
            while(resultado.next()){
                FonteDto fonte = new FonteDto();
                fonte.setId(resultado.getInt("id"));
                fonte.setNome(resultado.getString("nome"));
                
                fontes.add(fonte);
            }
            
        }
        return fontes;
    }
}


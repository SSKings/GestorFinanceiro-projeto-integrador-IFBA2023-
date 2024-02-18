/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.criptografia;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/**
 *
 * @author s
 */

public class Criptografia {
    
    public static String criptografarSenha(char[] senha){
        Argon2 argon2 = Argon2Factory.create();
         return argon2.hash(10, 16000, 1, senha);   
    }
    
    public static boolean validarSenha(String senhaCript, char[] senha){
        Argon2 argon2 = Argon2Factory.create();
        return argon2.verify(senhaCript, senha);
    }
}

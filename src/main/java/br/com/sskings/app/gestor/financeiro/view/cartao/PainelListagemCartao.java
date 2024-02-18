/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.cartao;

import br.com.sskings.app.gestor.financeiro.model.dao.CartaoCreditoDao;
import br.com.sskings.app.gestor.financeiro.model.dao.UsuarioDao;
import br.com.sskings.app.gestor.financeiro.model.dto.CartaoCreditoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import br.com.sskings.app.gestor.financeiro.view.TelaLogin;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author s
 */
public class PainelListagemCartao extends javax.swing.JPanel {


    /**
     * Creates new form PainelListagemCartao
     */
public PainelListagemCartao(){
        initComponents();
        listarCartoes();

    }

    private void listarCartoes() {

        try {
            UsuarioDto usuarioLogado = obterUsuarioLogado();            
            List<CartaoCreditoDto> listaDeCartoes = new CartaoCreditoDao().listar(usuarioLogado);
            
            if (!listaDeCartoes.isEmpty()) {
                for (CartaoCreditoDto cartaoCreditoDto : listaDeCartoes) {
                    PainelCartao painelCartao = new PainelCartao(cartaoCreditoDto);
                    painelCartao.setSize(390, 249);
                    this.painelRenderizador.add(painelCartao);
              
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem cartões cadastrados.");
            } 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os seus cartões.");
        }

    }
    
    public boolean temCartao(){
        try{
            UsuarioDto usuarioLogado = obterUsuarioLogado();            
            List<CartaoCreditoDto> listaDeCartoes = new CartaoCreditoDao().listar(usuarioLogado);
            return !listaDeCartoes.isEmpty();
        } catch(Exception ex){
          
            return false;
        }
    }
    
    private UsuarioDto obterUsuarioLogado() throws Exception {
        UsuarioDto usuarioLogado = new UsuarioDto();
        usuarioLogado.setEmail(TelaLogin.getCampoUsuario());
        usuarioLogado.setLogin(TelaLogin.getCampoUsuario());
        usuarioLogado = new UsuarioDao().pesquisar(usuarioLogado);
        return usuarioLogado;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        painelRenderizador = new javax.swing.JPanel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMinimumSize(new java.awt.Dimension(928, 520));
        setPreferredSize(new java.awt.Dimension(928, 520));

        jScrollPane1.setViewportView(painelRenderizador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelRenderizador;
    // End of variables declaration//GEN-END:variables
}

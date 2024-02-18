/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.conta;

import br.com.sskings.app.gestor.financeiro.model.dao.ContaBancariaDao;
import br.com.sskings.app.gestor.financeiro.model.dao.UsuarioDao;
import br.com.sskings.app.gestor.financeiro.model.dto.ContaBancariaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import br.com.sskings.app.gestor.financeiro.view.TelaLogin;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author s
 */
public class PainelListagemConta extends javax.swing.JPanel {

    /**
     * Creates new form PainelListagemConta
     */
    public PainelListagemConta() {
        initComponents();
        listarContas();
    }

    private void listarContas() {

        

        try {
            UsuarioDto usuarioLogado = obterUsuarioLogado();
            List<ContaBancariaDto> listaDeContas = new ContaBancariaDao().listar(usuarioLogado);

            if (!listaDeContas.isEmpty()) {
                for (ContaBancariaDto conta : listaDeContas) {
                    PainelConta painelConta = new PainelConta(conta);
                    painelConta.setSize(390, 249);
                    this.painelRenderizador.add(painelConta);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem contas cadastrados.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar as suas contas");
        }
    }

    public boolean temContas() {
        
        
        
        try {
            UsuarioDto usuarioLogado = obterUsuarioLogado();
            List<ContaBancariaDto> listaDeContas = new ContaBancariaDao().listar(usuarioLogado);
            return !listaDeContas.isEmpty();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível verificar se há contas cadastradas.");
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

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEADING);
        flowLayout1.setAlignOnBaseline(true);
        painelRenderizador.setLayout(flowLayout1);
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

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelRenderizador;
    // End of variables declaration//GEN-END:variables
}
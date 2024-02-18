/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.lancamentos;

import br.com.sskings.app.gestor.financeiro.model.dao.LancamentoDao;
import br.com.sskings.app.gestor.financeiro.model.dao.UsuarioDao;
import br.com.sskings.app.gestor.financeiro.model.dto.LancamentoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import br.com.sskings.app.gestor.financeiro.view.TelaLogin;
import javax.swing.JOptionPane;

/**
 *
 * @author s
 */
public class PainelPrincipalLancamentos extends javax.swing.JPanel {

    /**
     * Creates new form PainelPrincipalTransacoes
     */
    public PainelPrincipalLancamentos() {
        initComponents();
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

        painelRenderizador = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnExcluirTodos = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(928, 520));

        painelRenderizador.setBackground(new java.awt.Color(204, 204, 255));
        painelRenderizador.setPreferredSize(new java.awt.Dimension(928, 520));

        lblTitulo.setFont(new java.awt.Font("Liberation Serif", 1, 40)); // NOI18N
        lblTitulo.setText("LANÇAMENTOS");

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transacoes.png"))); // NOI18N

        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnExcluirTodos.setText("EXCLUIR TODOS ");
        btnExcluirTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelRenderizadorLayout = new javax.swing.GroupLayout(painelRenderizador);
        painelRenderizador.setLayout(painelRenderizadorLayout);
        painelRenderizadorLayout.setHorizontalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(btnExcluirTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(lblImagem)))
                .addContainerGap(140, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRenderizadorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(287, 287, 287))
        );
        painelRenderizadorLayout.setVerticalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblTitulo)
                .addGap(32, 32, 32)
                .addComponent(lblImagem)
                .addGap(38, 38, 38)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelRenderizador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelRenderizador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        PainelNovosLancamentos painel = new PainelNovosLancamentos();
        painel.setSize(920, 530);
        painel.setLocation(0, 0);

        painelRenderizador.removeAll();
        painelRenderizador.add(painel);
        painelRenderizador.validate();
        painelRenderizador.repaint();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        PainelListagemLancamentos painel = new PainelListagemLancamentos();
        painel.setSize(920, 530);
        painel.setLocation(0, 0);

        painelRenderizador.removeAll();
        painelRenderizador.add(painel);
        painelRenderizador.validate();
        painelRenderizador.repaint();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnExcluirTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirTodosActionPerformed
        int resp = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir todos os lançamentos?!",
                "Confirmar exclusão", JOptionPane.YES_NO_OPTION
        );

        if (resp == JOptionPane.YES_NO_OPTION) {
            try {
                LancamentoDto l = new LancamentoDto();
                l.setUsuario(obterUsuarioLogado());
                new LancamentoDao().excluirTudo(l);
                JOptionPane.showMessageDialog(this, "Todos os lançamentos foram excluídos.");
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnExcluirTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluirTodos;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelRenderizador;
    // End of variables declaration//GEN-END:variables
}

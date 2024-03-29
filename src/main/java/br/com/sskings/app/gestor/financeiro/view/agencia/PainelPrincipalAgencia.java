/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.agencia;

import br.com.sskings.app.gestor.financeiro.model.dao.AgenciaDao;
import br.com.sskings.app.gestor.financeiro.model.dto.AgenciaDto;
import java.util.List;

/**
 *
 * @author sskings
 */
public class PainelPrincipalAgencia extends javax.swing.JPanel {

    /**
     * Creates new form PainelPrincipalAgencia
     */
    public PainelPrincipalAgencia() {
        initComponents();
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
        btnCadastrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(928, 520));

        painelRenderizador.setBackground(new java.awt.Color(204, 204, 255));
        painelRenderizador.setPreferredSize(new java.awt.Dimension(928, 520));
        painelRenderizador.setRequestFocusEnabled(false);

        lblTitulo.setFont(new java.awt.Font("Liberation Serif", 1, 36)); // NOI18N
        lblTitulo.setText("AGÊNCIA");

        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnListar.setText("LISTAR");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/agencia.png"))); // NOI18N

        javax.swing.GroupLayout painelRenderizadorLayout = new javax.swing.GroupLayout(painelRenderizador);
        painelRenderizador.setLayout(painelRenderizadorLayout);
        painelRenderizadorLayout.setHorizontalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)))
                .addGap(275, 275, 275))
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelRenderizadorLayout.setVerticalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelRenderizador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelRenderizador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        PainelCadastroAgencia painel = new PainelCadastroAgencia();
        painel.setSize(928, 520);
        painel.setLocation(0, 0);

        this.painelRenderizador.removeAll();
        this.painelRenderizador.add(painel);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        PainelListagemAgencia painel = new PainelListagemAgencia();
        if (painel.temAgencia()) {
            painel.setSize(928, 520);
            painel.setLocation(0, 0);

            this.painelRenderizador.removeAll();
            this.painelRenderizador.add(painel);
            this.revalidate();
            this.repaint();
        }
    }//GEN-LAST:event_btnListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelRenderizador;
    // End of variables declaration//GEN-END:variables
}

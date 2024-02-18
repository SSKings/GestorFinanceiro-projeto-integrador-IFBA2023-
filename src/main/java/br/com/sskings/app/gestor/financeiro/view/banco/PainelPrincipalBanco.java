/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.banco;

/**
 *
 * @author sskings
 */
public class PainelPrincipalBanco extends javax.swing.JPanel {

    /**
     * Creates new form PainelPrincipalBanco
     */
    public PainelPrincipalBanco() {
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
        lblImagem = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        painelRenderizador.setBackground(new java.awt.Color(204, 204, 255));
        painelRenderizador.setMinimumSize(new java.awt.Dimension(928, 520));
        painelRenderizador.setRequestFocusEnabled(false);

        lblTitulo.setFont(new java.awt.Font("Liberation Serif", 1, 40)); // NOI18N
        lblTitulo.setText("BANCOS");

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/banco_p.png"))); // NOI18N

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

        javax.swing.GroupLayout painelRenderizadorLayout = new javax.swing.GroupLayout(painelRenderizador);
        painelRenderizador.setLayout(painelRenderizadorLayout);
        painelRenderizadorLayout.setHorizontalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(159, 159, 159)
                .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(234, 234, 234))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRenderizadorLayout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRenderizadorLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(365, 365, 365))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRenderizadorLayout.createSequentialGroup()
                        .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(280, 280, 280))))
        );
        painelRenderizadorLayout.setVerticalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(41, 41, 41))
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

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        PainelCadastroBanco painel = new PainelCadastroBanco();
        painel.setSize(928,520);
        painel.setLocation(0, 0);
        
        this.painelRenderizador.removeAll();
        this.painelRenderizador.add(painel);
        this.painelRenderizador.revalidate();
        this.painelRenderizador.repaint();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        PainelListagemBanco painel = new PainelListagemBanco();
        painel.setSize(928, 520);
        painel.setLocation(0, 0);
        
        this.painelRenderizador.removeAll();
        this.painelRenderizador.add(painel);
        painelRenderizador.revalidate();
        painelRenderizador.repaint();
    }//GEN-LAST:event_btnListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelRenderizador;
    // End of variables declaration//GEN-END:variables
}

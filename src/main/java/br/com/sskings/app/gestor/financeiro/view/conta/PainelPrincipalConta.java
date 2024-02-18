/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.conta;

/**
 *
 * @author s
 */
public class PainelPrincipalConta extends javax.swing.JPanel {

    /**
     * Creates new form PainelCadastroConta
     */
    public PainelPrincipalConta() {
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
        lblImagem = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(928, 520));

        painelRenderizador.setBackground(new java.awt.Color(204, 204, 255));
        painelRenderizador.setPreferredSize(new java.awt.Dimension(928, 520));
        painelRenderizador.setRequestFocusEnabled(false);

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/porco.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Liberation Serif", 1, 40)); // NOI18N
        lblTitulo.setText("CONTAS BANCÁRIAS");

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
                .addGap(270, 270, 270)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(242, 242, 242))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRenderizadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImagem)
                .addGap(284, 284, 284))
            .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelRenderizadorLayout.createSequentialGroup()
                    .addGap(242, 242, 242)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addGap(177, 177, 177)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addGap(229, 229, 229)))
        );
        painelRenderizadorLayout.setVerticalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41)
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
            .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelRenderizadorLayout.createSequentialGroup()
                    .addGap(436, 436, 436)
                    .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                    .addGap(48, 48, 48)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(painelRenderizador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(painelRenderizador, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        PainelCadastroConta painel = new PainelCadastroConta();
        painel.setSize(928, 520);
        painel.setLocation(0, 0);

        painelRenderizador.removeAll();
        painelRenderizador.add(painel);
        painelRenderizador.revalidate();
        painelRenderizador.repaint();

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        PainelListagemConta painel = new PainelListagemConta();
        if (painel.temContas()) {
            painel.setSize(928, 520);
            painel.setLocation(0, 0);

            painelRenderizador.removeAll();
            painelRenderizador.add(painel);
            painelRenderizador.revalidate();
            painelRenderizador.repaint();
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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.relatorios;

import br.com.sskings.app.gestor.financeiro.relatorios.Relatorios;


/**
 *
 * @author sskings
 */
public class PainelPrincipalRelatorios extends javax.swing.JPanel {

    /**
     * Creates new form PainelPrincipalRelatorios
     */
    public PainelPrincipalRelatorios() {
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
        btnTodosLancamentos = new javax.swing.JButton();
        btnTodasAsReceitas = new javax.swing.JButton();
        btnTodasAsDespesas = new javax.swing.JButton();
        btnLancamentosDeCartao = new javax.swing.JButton();
        btnLancamentosDeConta = new javax.swing.JButton();

        painelRenderizador.setBackground(new java.awt.Color(204, 204, 255));

        lblTitulo.setFont(new java.awt.Font("Liberation Serif", 1, 36)); // NOI18N
        lblTitulo.setText("RELATÓRIOS");

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N

        btnTodosLancamentos.setText("TODOS OS LANÇAMENTOS");
        btnTodosLancamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosLancamentosActionPerformed(evt);
            }
        });

        btnTodasAsReceitas.setText("TODAS AS RECEITAS");
        btnTodasAsReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasAsReceitasActionPerformed(evt);
            }
        });

        btnTodasAsDespesas.setText("TODAS AS DESPESAS");
        btnTodasAsDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodasAsDespesasActionPerformed(evt);
            }
        });

        btnLancamentosDeCartao.setText("LANÇAMENTOS DE CARTÃO");
        btnLancamentosDeCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancamentosDeCartaoActionPerformed(evt);
            }
        });

        btnLancamentosDeConta.setText("LANÇAMENTOS DE CONTA");
        btnLancamentosDeConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancamentosDeContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelRenderizadorLayout = new javax.swing.GroupLayout(painelRenderizador);
        painelRenderizador.setLayout(painelRenderizadorLayout);
        painelRenderizadorLayout.setHorizontalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRenderizadorLayout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(324, 324, 324))
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLancamentosDeConta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTodasAsReceitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTodosLancamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTodasAsDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLancamentosDeCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addComponent(lblImagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelRenderizadorLayout.setVerticalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblTitulo)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnTodosLancamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTodasAsReceitas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTodasAsDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLancamentosDeCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnLancamentosDeConta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(lblImagem)))
                .addContainerGap(75, Short.MAX_VALUE))
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

    private void btnTodasAsReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodasAsReceitasActionPerformed
        Relatorios.gerarRelatorioDeTodasAsReceitas();
    }//GEN-LAST:event_btnTodasAsReceitasActionPerformed

    private void btnTodosLancamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosLancamentosActionPerformed
        Relatorios.gerarRelatorioDeTodosOsLancamentos();
    }//GEN-LAST:event_btnTodosLancamentosActionPerformed

    private void btnTodasAsDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodasAsDespesasActionPerformed
        Relatorios.gerarRelatorioDeTodasAsDespesas();
    }//GEN-LAST:event_btnTodasAsDespesasActionPerformed

    private void btnLancamentosDeCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancamentosDeCartaoActionPerformed
        Relatorios.gerarRelatorioDeLancamentosDeCartao();
    }//GEN-LAST:event_btnLancamentosDeCartaoActionPerformed

    private void btnLancamentosDeContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancamentosDeContaActionPerformed
        Relatorios.gerarRelatorioDeLancamentosDeConta();
    }//GEN-LAST:event_btnLancamentosDeContaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLancamentosDeCartao;
    private javax.swing.JButton btnLancamentosDeConta;
    private javax.swing.JButton btnTodasAsDespesas;
    private javax.swing.JButton btnTodasAsReceitas;
    private javax.swing.JButton btnTodosLancamentos;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelRenderizador;
    // End of variables declaration//GEN-END:variables
}

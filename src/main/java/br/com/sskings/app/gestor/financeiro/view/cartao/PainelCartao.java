/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.cartao;

import br.com.sskings.app.gestor.financeiro.model.dao.CartaoCreditoDao;
import br.com.sskings.app.gestor.financeiro.model.dto.CartaoCreditoDto;
import java.awt.Color;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author s
 */
public class PainelCartao extends javax.swing.JPanel {

    private CartaoCreditoDto c;

    /**
     * Creates new form PainelCartao
     */
    public PainelCartao(CartaoCreditoDto c) {
        initComponents();
        this.c = c;
        preencherCampos();
        btnSalvar.setVisible(false);
    }

    private void preencherCampos() {
        switch (c.getBanco().getNome()) {
            case "BB":
                lblNomeDoBanco.setText("BANCO DO BRASIL");
                ImageIcon icon = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/elo.png");
                lblLogo.setIcon(icon);
                this.setBackground(Color.YELLOW);
                break;
            case "BRADESCO":
                lblNomeDoBanco.setText("CARTÃO BRADESCO ");
                ImageIcon icon2 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/visa.png");
                lblLogo.setIcon(icon2);
                this.setBackground(Color.RED);
                break;
            case "CAIXA":
                lblNomeDoBanco.setText("CARTÃO CAIXA");
                ImageIcon icon3 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/elo.png");
                lblLogo.setIcon(icon3);
                this.setBackground(Color.BLUE);
                break;
            case "DIGIO":
                lblNomeDoBanco.setText("CARTÃO DÍGIO");
                ImageIcon icon4 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/visa.png");
                lblLogo.setIcon(icon4);
                this.setBackground(Color.BLUE);
                break;
            case "ITAU":
                lblNomeDoBanco.setText("CARTÃO ITAÚ");
                ImageIcon icon5 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/master.png");
                lblLogo.setIcon(icon5);
                this.setBackground(Color.BLUE);
                break;
            case "NUBANK":
                lblNomeDoBanco.setText("CARTÃO NUBANK");
                ImageIcon icon6 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/master.png");
                lblLogo.setIcon(icon6);
                this.setBackground(Color.MAGENTA);
                break;
            case "INTER":
                lblNomeDoBanco.setText("CARTÃO INTER");
                ImageIcon icon7 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/master.png");
                lblLogo.setIcon(icon7);
                this.setBackground(Color.ORANGE);
                break;
            case "PAN":
                lblNomeDoBanco.setText("CARTÃO PAN");
                ImageIcon icon8 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/master.png");
                lblLogo.setIcon(icon8);
                this.setBackground(Color.LIGHT_GRAY);
                break;
            case "NEXT":
                lblNomeDoBanco.setText("CARTÃO NEXT");
                ImageIcon icon9 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/master.png");
                lblLogo.setIcon(icon9);
                this.setBackground(Color.GREEN);
                break;
            case "NEON":
                lblNomeDoBanco.setText("CARTÃO NEON");
                ImageIcon icon10 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/visa.png");
                lblLogo.setIcon(icon10);
                this.setBackground(Color.BLUE);
                break;
            case "PICPAY":
                lblNomeDoBanco.setText("CARTÃO PICPAY");
                ImageIcon icon11 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/master.png");
                lblLogo.setIcon(icon11);
                this.setBackground(Color.GREEN);
                break;
            case "SANTANDER":
                lblNomeDoBanco.setText("CARTÃO SANTANDER");
                ImageIcon icon12 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/visa.png");
                lblLogo.setIcon(icon12);
                this.setBackground(Color.RED);
                break;
            case "WILL":
                lblNomeDoBanco.setText("CARTÃO WILL");
                ImageIcon icon13 = new ImageIcon("src/main/resources/images/logos/bandeiras_cartao/master.png");
                lblLogo.setIcon(icon13);
                this.setBackground(Color.ORANGE);
                break;
        }

        txtNumero.setText(String.valueOf(c.getNumero()));
        txtLimite.setText(String.valueOf(c.getLimite()));
        txtLimiteDisponivel.setText(String.valueOf(c.getLimite_disponivel()));
        txtMesV.setText(String.valueOf(c.getVencimento().getMonthValue()));
        txtAnoV.setText(String.valueOf(c.getVencimento().getYear()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        lblNomeDoBanco = new javax.swing.JLabel();
        lblImagem = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        lblLimite = new javax.swing.JLabel();
        lblVencimento = new javax.swing.JLabel();
        txtMesV = new javax.swing.JTextField();
        txtAnoV = new javax.swing.JTextField();
        txtLimite = new javax.swing.JTextField();
        lblExcluirCartao = new javax.swing.JLabel();
        lblLimiteAtual = new javax.swing.JLabel();
        txtLimiteDisponivel = new javax.swing.JTextField();
        lblEditarCartao = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 0, 255));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/master_card_icon.png"))); // NOI18N

        lblNomeDoBanco.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblNomeDoBanco.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeDoBanco.setText("NOME DO BANCO");

        lblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cards_sim_chip_icon_157314.png"))); // NOI18N

        txtNumero.setEditable(false);
        txtNumero.setBorder(null);

        lblNumero.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblNumero.setForeground(new java.awt.Color(255, 255, 255));
        lblNumero.setText("número");

        lblLimite.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblLimite.setForeground(new java.awt.Color(255, 255, 255));
        lblLimite.setText("limite");

        lblVencimento.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblVencimento.setForeground(new java.awt.Color(255, 255, 255));
        lblVencimento.setText("vencimento");

        txtMesV.setEditable(false);
        txtMesV.setBorder(null);

        txtAnoV.setEditable(false);
        txtAnoV.setBorder(null);

        txtLimite.setEditable(false);
        txtLimite.setBorder(null);

        lblExcluirCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        lblExcluirCartao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExcluirCartao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExcluirCartaoMouseClicked(evt);
            }
        });

        lblLimiteAtual.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblLimiteAtual.setForeground(new java.awt.Color(255, 255, 255));
        lblLimiteAtual.setText("limite atual");

        txtLimiteDisponivel.setEditable(false);
        txtLimiteDisponivel.setBorder(null);
        txtLimiteDisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLimiteDisponivelActionPerformed(evt);
            }
        });

        lblEditarCartao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        lblEditarCartao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblEditarCartao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditarCartaoMouseClicked(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(null);
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblExcluirCartao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblNomeDoBanco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo)
                .addGap(18, 18, 18)
                .addComponent(lblEditarCartao)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLimite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lblLimiteAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLimiteDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagem)
                        .addGap(18, 18, 18)
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblVencimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMesV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnoV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblExcluirCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNomeDoBanco))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEditarCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumero, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLimiteAtual)
                    .addComponent(txtLimiteDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMesV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblExcluirCartaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExcluirCartaoMouseClicked
        int resp = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o Cartão?");
        if (resp == 0) {
            try {
                new CartaoCreditoDao().excluir(c);
                JOptionPane.showMessageDialog(this, "Cartão excluído!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao tentar excluir um cartão");
            }
        }


    }//GEN-LAST:event_lblExcluirCartaoMouseClicked

    private void txtLimiteDisponivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimiteDisponivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLimiteDisponivelActionPerformed

    private void lblEditarCartaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditarCartaoMouseClicked
        txtNumero.setEditable(true);
        txtLimite.setEditable(true);
        txtMesV.setEditable(true);
        txtAnoV.setEditable(true);
        btnSalvar.setVisible(true);
    }//GEN-LAST:event_lblEditarCartaoMouseClicked

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        if (!txtNumero.getText().isBlank() && !txtLimite.getText().isBlank()
                && !txtLimiteDisponivel.getText().isBlank() && !txtMesV.getText().isBlank()
                && !txtAnoV.getText().isBlank()) {

            try {
                Long numero = Long.valueOf(txtNumero.getText());
                Double limite = Double.valueOf(txtLimite.getText());
                Integer mes = Integer.valueOf(txtMesV.getText());
                Integer ano = Integer.valueOf(txtAnoV.getText());

                CartaoCreditoDto cartao = new CartaoCreditoDto();
                cartao.setId(c.getId());
                cartao.setNumero(numero);
                cartao.setLimite(limite);
                LocalDate vencimento = LocalDate.of(ano, mes, 1);
                cartao.setVencimento(vencimento);
                cartao.setUsuario(c.getUsuario());
                cartao.setBanco(c.getBanco());

                new CartaoCreditoDao().atualizar(cartao);

                JOptionPane.showMessageDialog(this, "Os dados do cartão foram atualizados.");

                txtNumero.setEditable(false);
                txtLimite.setEditable(false);
                txtMesV.setEditable(false);
                txtAnoV.setEditable(false);
                btnSalvar.setVisible(false);                
                this.revalidate();
                this.repaint();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Não foi possível atualizar os dados do cartão.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos corretamente.");
        }
    }//GEN-LAST:event_btnSalvarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblEditarCartao;
    private javax.swing.JLabel lblExcluirCartao;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblLimite;
    private javax.swing.JLabel lblLimiteAtual;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNomeDoBanco;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblVencimento;
    private javax.swing.JTextField txtAnoV;
    private javax.swing.JTextField txtLimite;
    private javax.swing.JTextField txtLimiteDisponivel;
    private javax.swing.JTextField txtMesV;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables
}

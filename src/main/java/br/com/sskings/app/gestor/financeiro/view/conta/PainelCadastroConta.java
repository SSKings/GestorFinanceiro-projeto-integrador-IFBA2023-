/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.conta;

import br.com.sskings.app.gestor.financeiro.model.dao.AgenciaDao;
import br.com.sskings.app.gestor.financeiro.model.dao.BancoDao;
import br.com.sskings.app.gestor.financeiro.model.dao.ContaBancariaDao;
import br.com.sskings.app.gestor.financeiro.model.dao.UsuarioDao;
import br.com.sskings.app.gestor.financeiro.model.dto.AgenciaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.BancoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.ContaBancariaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import br.com.sskings.app.gestor.financeiro.view.TelaLogin;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author s
 */
public class PainelCadastroConta extends javax.swing.JPanel {

    private final Map<String, Integer> mapaBancoId = new HashMap<>();
    private final Map<String, Integer> mapaAgenciaId = new HashMap<>();

    /**
     * Creates new form PainelCadastroConta
     */
    public PainelCadastroConta() {
        initComponents();
        preencherComboBancos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        comboBancos = new javax.swing.JComboBox<>();
        lblInstituicao = new javax.swing.JLabel();
        lblAgencia = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        lblsaldo = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lblReais = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        comboAgencia = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 255));
        setPreferredSize(new java.awt.Dimension(928, 520));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(606, 520));

        lblTitulo.setFont(new java.awt.Font("Liberation Serif", 1, 40)); // NOI18N
        lblTitulo.setText("NOVA CONTA");

        comboBancos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----" }));
        comboBancos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBancosItemStateChanged(evt);
            }
        });

        lblInstituicao.setText("Instituição Financeira");

        lblAgencia.setText("Agência");

        lblNumero.setText("Número");

        txtNumero.setBorder(null);

        txtSaldo.setBorder(null);

        lblsaldo.setText("Saldo");

        lblReais.setText("R$ ");

        btnSalvar.setBackground(new java.awt.Color(102, 153, 255));
        btnSalvar.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        comboAgencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addGap(62, 62, 62))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblReais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSaldo)
                        .addGap(64, 64, 64))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblsaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(160, 160, 160))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblInstituicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBancos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(69, 69, 69))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(229, 229, 229))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(162, 162, 162))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInstituicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBancos)
                    .addComponent(comboAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(lblNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblsaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSaldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!txtNumero.getText().isBlank() && !txtSaldo.getText().isBlank()
                && !comboBancos.getSelectedItem().equals("----") && !comboAgencia.getSelectedItem().equals("----")) {

            Long numero = Long.valueOf(txtNumero.getText());
            Double saldo = Double.valueOf(txtSaldo.getText());

            AgenciaDto agencia = new AgenciaDto();
            Integer indexDaAgencia = getIdAgenciaSelecionado();
            agencia.setId(indexDaAgencia);

            try {
                agencia = new AgenciaDao().pesquisarPorId(agencia);
                ContaBancariaDto conta = new ContaBancariaDto();
                conta.setNumero(numero);
                conta.setUsuario(obterUsuarioLogado());
                conta.setAgencia(agencia);
                conta.setSaldo(saldo);

                new ContaBancariaDao().cadastrar(conta);
                JOptionPane.showMessageDialog(this, "Conta cadastrada com sucesso.");
                
                limparCampos();
                
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Não foi possível salvar uma nova conta.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Preencha os campos corretamente.");
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    private void comboBancosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBancosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            preencherComboAgencias();
        }
    }//GEN-LAST:event_comboBancosItemStateChanged

    private void preencherComboBancos() {
        try {
            List<BancoDto> bancos = new BancoDao().listar();
            bancos.forEach(b -> {
                comboBancos.addItem(b.getNome());
                this.mapaBancoId.put(b.getNome(), b.getId());

            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não foi possível preencher os bancos.");
        }

    }

    private int getIdBancoSelecionado() {
        String itemSelecionado = comboBancos.getSelectedItem().toString();
        return this.mapaBancoId.get(itemSelecionado);
    }

    private void preencherComboAgencias() {
        if (!comboBancos.getSelectedItem().equals("----")) {
            AgenciaDto agencia = new AgenciaDto();
            agencia.getBanco().setId(getIdBancoSelecionado());
            comboAgencia.removeAllItems();
            try {
                    
                List<AgenciaDto> agencias = new AgenciaDao().listarPorBancos(agencia);                
                agencias.forEach(a -> {
                    comboAgencia.addItem(a.getCodigo().toString());
                    this.mapaAgenciaId.put(a.getCodigo().toString(), a.getId());
                });
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Não foi possível preencher as agências.");
            }
        }
    }

    private Integer getIdAgenciaSelecionado() {
        String itemSelecionado = comboAgencia.getSelectedItem().toString();
        return this.mapaAgenciaId.get(itemSelecionado);
    }

    private UsuarioDto obterUsuarioLogado() throws Exception {
        UsuarioDto usuarioLogado = new UsuarioDto();
        usuarioLogado.setEmail(TelaLogin.getCampoUsuario());
        usuarioLogado.setLogin(TelaLogin.getCampoUsuario());
        usuarioLogado = new UsuarioDao().pesquisar(usuarioLogado);
        return usuarioLogado;

    }
    
    private void limparCampos(){
        txtNumero.setText("");
        txtSaldo.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboAgencia;
    private javax.swing.JComboBox<String> comboBancos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAgencia;
    private javax.swing.JLabel lblInstituicao;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblReais;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblsaldo;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables

}

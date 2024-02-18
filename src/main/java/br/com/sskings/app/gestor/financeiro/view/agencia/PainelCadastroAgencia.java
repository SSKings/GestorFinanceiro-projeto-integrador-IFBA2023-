/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.agencia;

import br.com.sskings.app.gestor.financeiro.model.dao.AgenciaDao;
import br.com.sskings.app.gestor.financeiro.model.dao.BancoDao;
import br.com.sskings.app.gestor.financeiro.model.dto.AgenciaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.BancoDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author sskings
 */
public class PainelCadastroAgencia extends javax.swing.JPanel {
    
    
    Map<String, Integer> mapaBancoId = new HashMap<>();
    /**
     * Creates new form PainelCadastroAgencia
     */
    public PainelCadastroAgencia() {
        initComponents();
        preencherComboBanco();
    }
    
    private void preencherComboBanco(){
        try{
            List<BancoDto> bancos = new BancoDao().listar();
            bancos.forEach(b -> {
                comboBanco.addItem(b.toString());
                this.mapaBancoId.put(b.getNome(), b.getId());
            });
        }catch(Exception ex){
            
        }
    }
    
    private int getIdBancoSelecionado(){
        String itemSelecionado = comboBanco.getSelectedItem().toString();
        return mapaBancoId.get(itemSelecionado);
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
        jLabel1 = new javax.swing.JLabel();
        comboBanco = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(204, 204, 255));
        setPreferredSize(new java.awt.Dimension(928, 520));

        painelRenderizador.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Serif", 1, 36)); // NOI18N
        jLabel1.setText("NOVA AGÊNCIA");

        comboBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----" }));

        jLabel2.setText("BANCO");

        jLabel3.setText("CÓDIGO");

        txtCodigo.setBorder(null);

        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout painelRenderizadorLayout = new javax.swing.GroupLayout(painelRenderizador);
        painelRenderizador.setLayout(painelRenderizadorLayout);
        painelRenderizadorLayout.setHorizontalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel1)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(comboBanco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painelRenderizadorLayout.setVerticalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(55, 55, 55)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(painelRenderizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelRenderizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(!txtCodigo.getText().isBlank()){
            
            Integer codigo = Integer.valueOf(txtCodigo.getText());
            Integer bancoId = getIdBancoSelecionado();
            
            try{
                AgenciaDto agencia = new AgenciaDto();
                agencia.getBanco().setId(bancoId);
                agencia.setCodigo(codigo);
                
                new AgenciaDao().cadastrar(agencia);
                JOptionPane.showMessageDialog(this, "Agência cadastrada com sucesso.");
                
                txtCodigo.setText("");
                
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Não foi possível cadastrar uma agência.");
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> comboBanco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel painelRenderizador;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}

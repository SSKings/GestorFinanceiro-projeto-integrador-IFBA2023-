/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.lancamentos;

import br.com.sskings.app.gestor.financeiro.model.dao.CartaoCreditoDao;
import br.com.sskings.app.gestor.financeiro.model.dao.ContaBancariaDao;
import br.com.sskings.app.gestor.financeiro.model.dao.FonteDao;
import br.com.sskings.app.gestor.financeiro.model.dao.LancamentoDao;
import br.com.sskings.app.gestor.financeiro.model.dao.TipoLancamentoDao;
import br.com.sskings.app.gestor.financeiro.model.dao.UsuarioDao;
import br.com.sskings.app.gestor.financeiro.model.dto.AgenciaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.BancoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.CartaoCreditoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.ContaBancariaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.FonteDto;
import br.com.sskings.app.gestor.financeiro.model.dto.LancamentoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.TipoLancamentoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import br.com.sskings.app.gestor.financeiro.view.TelaLogin;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author sskings
 */
public class PainelNovosLancamentos extends javax.swing.JPanel {

    Map<String, Integer> mapaTipoId = new HashMap<>();
    Map<String, Integer> mapaFonteId = new HashMap<>();
    Map<String, Integer> mapaCartaoOuContaId = new HashMap<>();

    /**
     * Creates new form PainelNovosLancamentos
     */
    public PainelNovosLancamentos() {
        initComponents();
        preencherComboTipo();
        preencherComboFonte();
        lblCartoesOuContas.setText("");
    }

    private void preencherComboTipo() {
        try {
            List<TipoLancamentoDto> tipos = new TipoLancamentoDao().listar();
            comboTipo.removeAllItems();
            tipos.forEach(tipo -> {
                comboTipo.addItem(tipo.getNome());
                this.mapaTipoId.put(tipo.getNome(), tipo.getId());
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível preencher o campo 'TIPO'"
                    + ex.getMessage());
        }

    }

    private int getIdTipoSelecionado() {
        String itemSelecionado = comboTipo.getSelectedItem().toString();
        return this.mapaTipoId.get(itemSelecionado);
    }

    private void preencherComboFonte() {
        try {
            List<FonteDto> fontes = new FonteDao().listar();
            fontes.forEach(fonte -> {
                comboFonte.addItem(fonte.getNome());
                mapaFonteId.put(fonte.getNome(), fonte.getId());
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não foi possível preencher o campo 'FONTE'"
                    + ex.getMessage());
        }
    }

    private int getIdFonteSelecionado() {
        String itemSelecionado = comboFonte.getSelectedItem().toString();
        return this.mapaFonteId.get(itemSelecionado);
    }

    private void preencherComboCartoesOuContas() {
        if (comboFonte.getSelectedItem().equals("CARTAO_DE_CREDITO")) {
            try {
                List<CartaoCreditoDto> cartoes = new CartaoCreditoDao().listar(obterUsuarioLogado());
                comboCartoesOuContas.removeAllItems();
                cartoes.forEach(cartao -> {                    
                    comboCartoesOuContas.addItem(cartao.getBanco().getNome());
                    this.mapaCartaoOuContaId.put(cartao.getBanco().getNome(), cartao.getId());
                    lblCartoesOuContas.setText("CARTOES");

                });
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());

            }
        } else if (comboFonte.getSelectedItem().equals("CONTA_BANCARIA")) {
            try {
                List<ContaBancariaDto> contas = new ContaBancariaDao().listar(obterUsuarioLogado());
                comboCartoesOuContas.removeAllItems();
                contas.forEach(conta -> {
                    comboCartoesOuContas.addItem(conta.getAgencia().getBanco().getNome());
                    this.mapaCartaoOuContaId.put(conta.getAgencia().getBanco().getNome(), conta.getId());
                    lblCartoesOuContas.setText("CONTAS");

                });
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }

        }

    }

    private int getIdCartaoOuContaSelecionado() {
        String itemSelecionado = comboCartoesOuContas.getSelectedItem().toString();
        return mapaCartaoOuContaId.get(itemSelecionado);
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

        painelLancamentos = new javax.swing.JPanel();
        lblLancamentos = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        comboFonte = new javax.swing.JComboBox<>();
        lblTipo = new javax.swing.JLabel();
        lblFonte = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnSalvar = new javax.swing.JButton();
        lblCartoesOuContas = new javax.swing.JLabel();
        comboCartoesOuContas = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 255));
        setMinimumSize(new java.awt.Dimension(928, 520));
        setPreferredSize(new java.awt.Dimension(928, 520));

        painelLancamentos.setBackground(new java.awt.Color(255, 255, 255));
        painelLancamentos.setPreferredSize(new java.awt.Dimension(607, 520));

        lblLancamentos.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        lblLancamentos.setText("LANÇAMENTOS");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----" }));

        comboFonte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----" }));
        comboFonte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFonteItemStateChanged(evt);
            }
        });

        lblTipo.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        lblTipo.setText("TIPO");

        lblFonte.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        lblFonte.setText("FONTE");

        lblValor.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        lblValor.setText("VALOR");

        txtValor.setBorder(null);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblCartoesOuContas.setFont(new java.awt.Font("Fira Sans", 1, 18)); // NOI18N
        lblCartoesOuContas.setText("----");

        comboCartoesOuContas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----" }));

        javax.swing.GroupLayout painelLancamentosLayout = new javax.swing.GroupLayout(painelLancamentos);
        painelLancamentos.setLayout(painelLancamentosLayout);
        painelLancamentosLayout.setHorizontalGroup(
            painelLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLancamentosLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(lblLancamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(141, 141, 141))
            .addGroup(painelLancamentosLayout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(painelLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLancamentosLayout.createSequentialGroup()
                        .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelLancamentosLayout.createSequentialGroup()
                        .addComponent(lblCartoesOuContas, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                        .addGap(404, 404, 404))
                    .addGroup(painelLancamentosLayout.createSequentialGroup()
                        .addGroup(painelLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboCartoesOuContas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLancamentosLayout.createSequentialGroup()
                                .addComponent(lblFonte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(48, 48, 48))
                            .addComponent(comboFonte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(116, 116, 116)
                        .addGroup(painelLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLancamentosLayout.createSequentialGroup()
                                .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(62, 62, 62))
                            .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(88, 88, 88))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLancamentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );
        painelLancamentosLayout.setVerticalGroup(
            painelLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLancamentosLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblLancamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(painelLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelLancamentosLayout.createSequentialGroup()
                        .addComponent(lblFonte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFonte))
                    .addGroup(painelLancamentosLayout.createSequentialGroup()
                        .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTipo)))
                .addGap(58, 58, 58)
                .addComponent(lblCartoesOuContas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCartoesOuContas)
                .addGap(75, 75, 75)
                .addGroup(painelLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLancamentosLayout.createSequentialGroup()
                        .addComponent(txtValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53))
                    .addGroup(painelLancamentosLayout.createSequentialGroup()
                        .addComponent(lblValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(142, 142, 142))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(painelLancamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelLancamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(!txtValor.getText().isBlank()) {           
            try {
                Double valor = Double.valueOf(txtValor.getText());
                Integer tipo_id = getIdTipoSelecionado();
                Integer fonte_id = getIdFonteSelecionado();
                Integer cartaoOuContaId = getIdCartaoOuContaSelecionado();

                if (comboTipo.getSelectedItem().equals("DESPESA")
                        && comboFonte.getSelectedItem().equals("CARTAO_DE_CREDITO")) {

                    LancamentoDto lancamento = new LancamentoDto();
                    lancamento.setValor(valor);

                    TipoLancamentoDto tipo = new TipoLancamentoDto();
                    tipo.setId(tipo_id);
                    lancamento.setTipo(tipo);
                    
                    UsuarioDto usuario = obterUsuarioLogado();
                    lancamento.setUsuario(usuario);

                    FonteDto fonte = new FonteDto();
                    fonte.setId(fonte_id);
                    lancamento.setFonte(fonte);

                    lancamento.setCartaoOuContaId(cartaoOuContaId);

                    new LancamentoDao().cadastrar(lancamento);

                    CartaoCreditoDto cartao = new CartaoCreditoDto();
                    cartao.setId(cartaoOuContaId);
                    cartao.setUsuario(usuario);
                    cartao.setBanco(new BancoDto());
                    cartao = new CartaoCreditoDao().pesquisarPorId(cartao);
                    if(cartao.getLimite_disponivel() > 0 && (cartao.getLimite_disponivel() - valor) >= 0){
                        cartao.setLimite_disponivel(cartao.getLimite_disponivel() - valor);
                        new CartaoCreditoDao().atualizarLimiteDisponivel(cartao);
                        JOptionPane.showMessageDialog(this, "Uma despesa foi lançada no cartão.");
                    }else{
                        JOptionPane.showMessageDialog(this, "Você não possui limite suficiente.");
                    }

                } else if (comboTipo.getSelectedItem().equals("RECEITA")
                        && comboFonte.getSelectedItem().equals("CARTAO_DE_CREDITO")) {

                    LancamentoDto lancamento = new LancamentoDto();
                    lancamento.setValor(valor);

                    TipoLancamentoDto tipo = new TipoLancamentoDto();
                    tipo.setId(tipo_id);
                    lancamento.setTipo(tipo);
                    
                    UsuarioDto usuario = obterUsuarioLogado();
                    lancamento.setUsuario(usuario);

                    FonteDto fonte = new FonteDto();
                    fonte.setId(fonte_id);
                    lancamento.setFonte(fonte);

                    lancamento.setCartaoOuContaId(cartaoOuContaId);

                    new LancamentoDao().cadastrar(lancamento);

                    CartaoCreditoDto cartao = new CartaoCreditoDto();
                    cartao.setId(cartaoOuContaId);
                    cartao.setUsuario(usuario);
                    cartao.setBanco(new BancoDto());
                    cartao = new CartaoCreditoDao().pesquisarPorId(cartao);
                    cartao.setLimite_disponivel(cartao.getLimite_disponivel() + valor);
                    new CartaoCreditoDao().atualizarLimiteDisponivel(cartao);

                    JOptionPane.showMessageDialog(this, "Uma receita foi lançada no cartão.");

                } else if (comboTipo.getSelectedItem().equals("DESPESA")
                        && comboFonte.getSelectedItem().equals("CONTA_BANCARIA")) {
                    LancamentoDto lancamento = new LancamentoDto();
                    lancamento.setValor(valor);

                    TipoLancamentoDto tipo = new TipoLancamentoDto();
                    tipo.setId(tipo_id);
                    lancamento.setTipo(tipo);
                    
                    UsuarioDto usuario = obterUsuarioLogado();
                    lancamento.setUsuario(usuario);

                    FonteDto fonte = new FonteDto();
                    fonte.setId(fonte_id);
                    lancamento.setFonte(fonte);

                    lancamento.setCartaoOuContaId(cartaoOuContaId);

                    new LancamentoDao().cadastrar(lancamento);

                    ContaBancariaDto conta = new ContaBancariaDto();
                    conta.setId(cartaoOuContaId);
                    conta.setUsuario(usuario);
                    conta.setAgencia(new AgenciaDto());
                    conta = new ContaBancariaDao().pesquisarPorId(conta);
                    if(conta.getSaldo() > 0 && (conta.getSaldo() - valor) >= 0) {
                        conta.setSaldo(conta.getSaldo() - valor);
                        new ContaBancariaDao().atualizarSaldoDisponivel(conta);
                        JOptionPane.showMessageDialog(this, "Uma despesa foi lançada na conta.");
                    }else {
                        JOptionPane.showMessageDialog(this, "Você não possui saldo suficiente.");
                    }
                    
                } else if (comboTipo.getSelectedItem().equals("RECEITA")
                        && comboFonte.getSelectedItem().equals("CONTA_BANCARIA")) {
                    LancamentoDto lancamento = new LancamentoDto();
                    lancamento.setValor(valor);

                    TipoLancamentoDto tipo = new TipoLancamentoDto();
                    tipo.setId(tipo_id);
                    lancamento.setTipo(tipo);
                    
                    UsuarioDto usuario = obterUsuarioLogado();
                    lancamento.setUsuario(usuario);

                    FonteDto fonte = new FonteDto();
                    fonte.setId(fonte_id);
                    lancamento.setFonte(fonte);

                    lancamento.setCartaoOuContaId(cartaoOuContaId);

                    new LancamentoDao().cadastrar(lancamento);

                    ContaBancariaDto conta = new ContaBancariaDto();
                    conta.setId(cartaoOuContaId);
                    conta.setUsuario(usuario);                    
                    conta = new ContaBancariaDao().pesquisarPorId(conta);
                    conta.setSaldo(conta.getSaldo() + valor);
                    new ContaBancariaDao().atualizarSaldoDisponivel(conta);

                    JOptionPane.showMessageDialog(this, "Uma receita foi lançada na conta.");

                } else {
                    JOptionPane.showMessageDialog(this, "Não consegue verificar combos.");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao tentar salvar um lançamento. ERRO: "
                        + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Preencha o campo valor corretamente...");
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void comboFonteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFonteItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            preencherComboCartoesOuContas();
        }
    }//GEN-LAST:event_comboFonteItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboCartoesOuContas;
    private javax.swing.JComboBox<String> comboFonte;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCartoesOuContas;
    private javax.swing.JLabel lblFonte;
    private javax.swing.JLabel lblLancamentos;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel painelLancamentos;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}

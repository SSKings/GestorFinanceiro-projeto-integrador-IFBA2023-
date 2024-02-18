/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.lancamentos;

import br.com.sskings.app.gestor.financeiro.model.dao.CartaoCreditoDao;
import br.com.sskings.app.gestor.financeiro.model.dao.ContaBancariaDao;
import br.com.sskings.app.gestor.financeiro.model.dao.LancamentoDao;
import br.com.sskings.app.gestor.financeiro.model.dao.UsuarioDao;
import br.com.sskings.app.gestor.financeiro.model.dto.CartaoCreditoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.ContaBancariaDto;
import br.com.sskings.app.gestor.financeiro.model.dto.LancamentoDto;
import br.com.sskings.app.gestor.financeiro.model.dto.UsuarioDto;
import br.com.sskings.app.gestor.financeiro.view.TelaLogin;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sskings
 */
public class PainelListagemLancamentos extends javax.swing.JPanel {

    /**
     * Creates new form PainelListagemLancamentos
     */
    public PainelListagemLancamentos() {
        initComponents();
        carregarTabelaLancamentos();
    }

    private void carregarTabelaLancamentos() {
        try {
            List<LancamentoDto> lancamentos = new LancamentoDao().listar(obterUsuarioLogado());

            DefaultTableModel tabela = (DefaultTableModel) tblLancamentos.getModel();

            lancamentos.forEach(l -> {

                try {
                    CartaoCreditoDto cartao = new CartaoCreditoDto();
                    cartao.setId(l.getCartaoOuContaId());
                    cartao.setUsuario(obterUsuarioLogado());
                    cartao = new CartaoCreditoDao().pesquisarPorId(cartao);
                    String bancoCartao = cartao.getBanco().getNome();

                    ContaBancariaDto conta = new ContaBancariaDto();
                    conta.setId(l.getCartaoOuContaId());
                    conta.setUsuario(obterUsuarioLogado());
                    conta = new ContaBancariaDao().pesquisarPorId(conta);
                    String bancoConta = conta.getAgencia().getBanco().getNome();

                    Object[] linha = new Object[]{
                        l.getId(),
                        l.getValor(),
                        l.getTipo().getNome(),
                        l.getFonte().getNome(),
                        (bancoCartao == null) ? bancoConta : bancoCartao,
                        l.getData().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"))
                    };

                    tabela.addRow(linha);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "erro ao tentar carregar a tabela. ERRO: "
                    + ex.getMessage());
        }

    }

    private void carregarTabelaPorFiltro() {
        if(comboFiltros.getSelectedItem().toString().equals("RECEITA")) {
            try {
                List<LancamentoDto> lancamentos = new LancamentoDao().pesquisarPorReceita(obterUsuarioLogado());

                DefaultTableModel tabela = (DefaultTableModel) tblLancamentos.getModel();
                tabela.setRowCount(0);
                lancamentos.forEach(l -> {

                    try {
                        CartaoCreditoDto cartao = new CartaoCreditoDto();
                        cartao.setId(l.getCartaoOuContaId());
                        cartao.setUsuario(obterUsuarioLogado());
                        cartao = new CartaoCreditoDao().pesquisarPorId(cartao);
                        String bancoCartao = cartao.getBanco().getNome();

                        ContaBancariaDto conta = new ContaBancariaDto();
                        conta.setId(l.getCartaoOuContaId());
                        conta.setUsuario(obterUsuarioLogado());
                        conta = new ContaBancariaDao().pesquisarPorId(conta);
                        String bancoConta = conta.getAgencia().getBanco().getNome();

                        Object[] linha = new Object[]{
                            l.getId(),
                            l.getValor(),
                            l.getTipo().getNome(),
                            l.getFonte().getNome(),
                            (bancoCartao == null) ? bancoConta : bancoCartao,
                            l.getData().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"))
                        };

                        tabela.addRow(linha);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "erro ao tentar carregar a tabela. ERRO: "
                        + ex.getMessage());
            }
        } else if (comboFiltros.getSelectedItem().toString().equals("DESPESA")) {
            try {
                List<LancamentoDto> lancamentos = new LancamentoDao().pesquisarPorDespesa(obterUsuarioLogado());

                DefaultTableModel tabela = (DefaultTableModel) tblLancamentos.getModel();
                tabela.setRowCount(0);
                lancamentos.forEach(l -> {

                    try {
                        CartaoCreditoDto cartao = new CartaoCreditoDto();
                        cartao.setId(l.getCartaoOuContaId());
                        cartao.setUsuario(obterUsuarioLogado());
                        cartao = new CartaoCreditoDao().pesquisarPorId(cartao);
                        String bancoCartao = cartao.getBanco().getNome();

                        ContaBancariaDto conta = new ContaBancariaDto();
                        conta.setId(l.getCartaoOuContaId());
                        conta.setUsuario(obterUsuarioLogado());
                        conta = new ContaBancariaDao().pesquisarPorId(conta);
                        String bancoConta = conta.getAgencia().getBanco().getNome();

                        Object[] linha = new Object[]{
                            l.getId(),
                            l.getValor(),
                            l.getTipo().getNome(),
                            l.getFonte().getNome(),
                            (bancoCartao == null) ? bancoConta : bancoCartao,
                            l.getData().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"))
                        };

                        tabela.addRow(linha);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "erro ao tentar carregar a tabela. ERRO: "
                        + ex.getMessage());
            }

        } else if (comboFiltros.getSelectedItem().toString().equals("CARTAO")) {
            try {
                List<LancamentoDto> lancamentos = new LancamentoDao().pesquisarPorCartao(obterUsuarioLogado());

                DefaultTableModel tabela = (DefaultTableModel) tblLancamentos.getModel();
                tabela.setRowCount(0);
                lancamentos.forEach(l -> {

                    try {
                        CartaoCreditoDto cartao = new CartaoCreditoDto();
                        cartao.setId(l.getCartaoOuContaId());
                        cartao.setUsuario(obterUsuarioLogado());
                        cartao = new CartaoCreditoDao().pesquisarPorId(cartao);
                        String bancoCartao = cartao.getBanco().getNome();

                        ContaBancariaDto conta = new ContaBancariaDto();
                        conta.setId(l.getCartaoOuContaId());
                        conta.setUsuario(obterUsuarioLogado());
                        conta = new ContaBancariaDao().pesquisarPorId(conta);
                        String bancoConta = conta.getAgencia().getBanco().getNome();

                        Object[] linha = new Object[]{
                            l.getId(),
                            l.getValor(),
                            l.getTipo().getNome(),
                            l.getFonte().getNome(),
                            (bancoCartao == null) ? bancoConta : bancoCartao,
                            l.getData().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"))
                        };

                        tabela.addRow(linha);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "erro ao tentar carregar a tabela. ERRO: "
                        + ex.getMessage());
            }

        } else if (comboFiltros.getSelectedItem().toString().equals("CONTA")) {
            try {
                List<LancamentoDto> lancamentos = new LancamentoDao().pesquisarPorConta(obterUsuarioLogado());

                DefaultTableModel tabela = (DefaultTableModel) tblLancamentos.getModel();
                tabela.setRowCount(0);
                lancamentos.forEach(l -> {

                    try {
                        CartaoCreditoDto cartao = new CartaoCreditoDto();
                        cartao.setId(l.getCartaoOuContaId());
                        cartao.setUsuario(obterUsuarioLogado());
                        cartao = new CartaoCreditoDao().pesquisarPorId(cartao);
                        String bancoCartao = cartao.getBanco().getNome();

                        ContaBancariaDto conta = new ContaBancariaDto();
                        conta.setId(l.getCartaoOuContaId());
                        conta.setUsuario(obterUsuarioLogado());
                        conta = new ContaBancariaDao().pesquisarPorId(conta);
                        String bancoConta = conta.getAgencia().getBanco().getNome();

                        Object[] linha = new Object[]{
                            l.getId(),
                            l.getValor(),
                            l.getTipo().getNome(),
                            l.getFonte().getNome(),
                            (bancoCartao == null) ? bancoConta : bancoCartao,
                            l.getData().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"))
                        };

                        tabela.addRow(linha);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "erro ao tentar carregar a tabela. ERRO: "
                        + ex.getMessage());
            }

        } else {
            carregarTabelaLancamentos();
        }
    }

    private UsuarioDto obterUsuarioLogado() throws Exception {
        UsuarioDto usuarioLogado = new UsuarioDto();
        usuarioLogado.setEmail(TelaLogin.getCampoUsuario());
        usuarioLogado.setLogin(TelaLogin.getCampoUsuario());
        usuarioLogado = new UsuarioDao().pesquisar(usuarioLogado);
        return usuarioLogado;
    }

    private boolean isNumero(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean isDate(String str) {
        try{
           LocalDate.parse(str, 
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (Exception e) {
            return false;
        }
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
        scrollPaneLancamentos = new javax.swing.JScrollPane();
        tblLancamentos = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        comboFiltros = new javax.swing.JComboBox<>();
        lblFiltros = new javax.swing.JLabel();

        painelRenderizador.setBackground(new java.awt.Color(204, 204, 255));
        painelRenderizador.setMaximumSize(new java.awt.Dimension(928, 520));

        lblTitulo.setFont(new java.awt.Font("Fira Sans", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("LISTAGEM DE LANÇAMENTOS");

        tblLancamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "VALOR", "TIPO", "FONTE", "CARTÂO/CONTA", "DATA"
            }
        ));
        tblLancamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLancamentosMouseClicked(evt);
            }
        });
        scrollPaneLancamentos.setViewportView(tblLancamentos);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa (1).png"))); // NOI18N
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseClicked(evt);
            }
        });

        txtPesquisar.setForeground(new java.awt.Color(153, 153, 153));
        txtPesquisar.setBorder(null);
        txtPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisarMouseClicked(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyPressed(evt);
            }
        });

        comboFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "RECEITA", "DESPESA", "CARTAO", "CONTA" }));
        comboFiltros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFiltrosItemStateChanged(evt);
            }
        });

        lblFiltros.setText("FILTROS");

        javax.swing.GroupLayout painelRenderizadorLayout = new javax.swing.GroupLayout(painelRenderizador);
        painelRenderizador.setLayout(painelRenderizadorLayout);
        painelRenderizadorLayout.setHorizontalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRenderizadorLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(scrollPaneLancamentos)
                .addGap(58, 58, 58))
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(225, 225, 225))
                    .addGroup(painelRenderizadorLayout.createSequentialGroup()
                        .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(txtPesquisar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFiltros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))))
        );
        painelRenderizadorLayout.setVerticalGroup(
            painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRenderizadorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRenderizadorLayout.createSequentialGroup()
                        .addGroup(painelRenderizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPesquisar)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(scrollPaneLancamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addGap(31, 31, 31))
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

    private void txtPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisarMouseClicked
        txtPesquisar.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtPesquisarMouseClicked

    private void comboFiltrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFiltrosItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            carregarTabelaPorFiltro();
        }
    }//GEN-LAST:event_comboFiltrosItemStateChanged

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
        if (!txtPesquisar.getText().isBlank()) {
            try {
                LancamentoDto lancamento = new LancamentoDto();

                if (isNumero(txtPesquisar.getText())) {              
                    lancamento.setValor(Double.valueOf(txtPesquisar.getText()));
                    
                } else if(isDate(txtPesquisar.getText())){
                    LocalDate data = LocalDate.parse(txtPesquisar.getText(), 
                            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    lancamento.setData(data);
                        
                } else {                       
                    lancamento.getTipo().setNome(txtPesquisar.getText());
                    lancamento.getFonte().setNome(txtPesquisar.getText());
                }

                lancamento.setUsuario(obterUsuarioLogado());
                List<LancamentoDto> lancamentos = new LancamentoDao().pesquisarPorAtributos(lancamento);

                DefaultTableModel tabela = (DefaultTableModel) tblLancamentos.getModel();
                tabela.setRowCount(0);

                lancamentos.forEach(l -> {

                    try {
                        CartaoCreditoDto cartao = new CartaoCreditoDto();
                        cartao.setId(l.getCartaoOuContaId());
                        cartao.setUsuario(obterUsuarioLogado());
                        cartao = new CartaoCreditoDao().pesquisarPorId(cartao);
                        String bancoCartao = cartao.getBanco().getNome();

                        ContaBancariaDto conta = new ContaBancariaDto();
                        conta.setId(l.getCartaoOuContaId());
                        conta.setUsuario(obterUsuarioLogado());
                        conta = new ContaBancariaDao().pesquisarPorId(conta);
                        String bancoConta = conta.getAgencia().getBanco().getNome();

                        Object[] linha = new Object[]{
                            l.getId(),
                            l.getValor(),
                            l.getTipo().getNome(),
                            l.getFonte().getNome(),
                            (bancoCartao == null) ? bancoConta : bancoCartao,
                            l.getData().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy"))
                        };

                        tabela.addRow(linha);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Preencha o campo de pesquisa.");
        }


    }//GEN-LAST:event_btnPesquisarMouseClicked

    private void txtPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnPesquisarMouseClicked(null);
        }
    }//GEN-LAST:event_txtPesquisarKeyPressed

    private void tblLancamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLancamentosMouseClicked
            DefaultTableModel tabela = (DefaultTableModel) tblLancamentos.getModel();
            
            Object idLancamentoSelecionado;
            idLancamentoSelecionado = tabela.getValueAt(tblLancamentos.getSelectedRow(), 0);
            LancamentoDto lancamento = new LancamentoDto();
            lancamento.setId((int)idLancamentoSelecionado);
            
            
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir esta linha?", 
                    "Confirmar exclusão", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {       
                try{
                    lancamento.setUsuario(obterUsuarioLogado());
                    new LancamentoDao().excluir(lancamento);
                    tabela.removeRow(tblLancamentos.getSelectedRow());
                    tabela.setRowCount(resposta);
                    carregarTabelaLancamentos();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Erro ao tentar excluir um lançamento.");
                }
                    
            }   
    }//GEN-LAST:event_tblLancamentosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnPesquisar;
    private javax.swing.JComboBox<String> comboFiltros;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFiltros;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel painelRenderizador;
    private javax.swing.JScrollPane scrollPaneLancamentos;
    private javax.swing.JTable tblLancamentos;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}

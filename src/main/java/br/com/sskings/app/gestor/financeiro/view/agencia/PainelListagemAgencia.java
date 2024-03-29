/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.sskings.app.gestor.financeiro.view.agencia;

import br.com.sskings.app.gestor.financeiro.model.dao.AgenciaDao;
import br.com.sskings.app.gestor.financeiro.model.dto.AgenciaDto;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author sskings
 */
public class PainelListagemAgencia extends javax.swing.JPanel {

    /**
     * Creates new form PainelListagemAgencia
     */
    public PainelListagemAgencia() {
        initComponents();
        listarAgencias();
        jScrollPane1.setSize(this.getSize());
    }

    private void listarAgencias() {
        try {
            List<AgenciaDto> listaDeAgencias = new AgenciaDao().listar();

            if (!listaDeAgencias.isEmpty()) {
                for (AgenciaDto agencia : listaDeAgencias) {
                    PainelAgencia painelAgencia = new PainelAgencia(agencia);
                    painelAgencia.setSize(294, 120);
                    this.painelRenderizador.add(painelAgencia);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem agências cadastradas.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível listar suas agências");
        }
    }

    public boolean temAgencia() {
        try {
            List<AgenciaDto> listaDeAgencias = new AgenciaDao().listar();
            return !listaDeAgencias.isEmpty();
        } catch (Exception ex) {

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

        jScrollPane1 = new javax.swing.JScrollPane();
        painelRenderizador = new javax.swing.JPanel();

        jScrollPane1.setViewportView(painelRenderizador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelRenderizador;
    // End of variables declaration//GEN-END:variables
}

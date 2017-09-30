/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EasyCode.BlocosFuncionais;

import EasyCode.Main;
import EasyCode.Pais.Bloco;
import EasyCode.Pais.Variavel;
import java.awt.Dimension;
import javax.swing.JComboBox;

/**
 *
 * @author CCE
 */
public class BFLeia extends Bloco{
    private String tipo;
    private final Dimension dimensoes = new Dimension(205,21);
    /**
     * Creates new form BFEscreva
     */
    public BFLeia() {
        super("Leia","Funcao Variavel Leia");
        initComponents();
        setSize(dimensoes);
        JCBvariaveis.removeAllItems();
        for(Variavel var : Main.listaVar){
            JCBvariaveis.addItem(var.getVar());
        }
    }
    public BFLeia(String condicao, String tipo) {
        super("Leia","Funcao Variavel Leia");
        initComponents();
        setSize(dimensoes);
        this.tipo = tipo;
        JCBvariaveis.removeAllItems();
        System.out.println(condicao);
        JCBvariaveis.addItem(condicao);      
        for(Variavel var : Main.listaVar){
            if(var.getVar().equals(condicao)) continue;
            JCBvariaveis.addItem(var.getVar());
        }
    }
      public Dimension getDimensoes() {
        return dimensoes;
    }

    public String getTipo() {
        return tipo;
    }

    public JComboBox<String> getJCBvariaveis() {
        return JCBvariaveis;
    }
    
    public String getCondicao(){
        return JCBvariaveis.getItemAt(JCBvariaveis.getSelectedIndex());
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
        jLabel4 = new javax.swing.JLabel();
        JCBvariaveis = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel1.setLayout(null);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Leia");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 50, 20);

        JCBvariaveis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JCBvariaveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBvariaveisActionPerformed(evt);
            }
        });
        jPanel1.add(JCBvariaveis);
        JCBvariaveis.setBounds(60, 0, 140, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JCBvariaveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBvariaveisActionPerformed
        // TODO add your handling code here:
        for(Variavel aux: Main.listaVar){
            if(JCBvariaveis.getItemAt(JCBvariaveis.getSelectedIndex()) == aux.getVar()){
                tipo = aux.getTipo();
            }
        }
    }//GEN-LAST:event_JCBvariaveisActionPerformed
    public javax.swing.JPanel componentes () {
        return this.jPanel1;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCBvariaveis;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
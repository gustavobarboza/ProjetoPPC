/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.AtaParticipantesDao;
import dao.AtaReuniaoDao;
import entity.AtaParticipantes;
import entity.AtaReuniao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class CadastroAtaReuniao extends javax.swing.JDialog {

    boolean novo=true;
    String identificadorAntigo;
    
    public CadastroAtaReuniao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLocalReuniao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jParticipantes = new javax.swing.JTextField();
        jAdicionar = new javax.swing.JButton();
        jRemover = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDeliberacoes = new javax.swing.JTextArea();
        jSalvar = new javax.swing.JButton();
        jSair = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaParticipantes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jIdentificador = new javax.swing.JTextField();
        jDataReuniao = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Data da reunião");

        jLabel2.setText("Local da reunião");

        jLocalReuniao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLocalReuniaoActionPerformed(evt);
            }
        });

        jLabel3.setText("Participantes");

        jParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jParticipantesActionPerformed(evt);
            }
        });

        jAdicionar.setText("Adicionar");
        jAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarActionPerformed(evt);
            }
        });

        jRemover.setText("Remover");
        jRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverActionPerformed(evt);
            }
        });

        jLabel4.setText("Deliberações");

        jDeliberacoes.setColumns(20);
        jDeliberacoes.setLineWrap(true);
        jDeliberacoes.setRows(5);
        jDeliberacoes.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jDeliberacoes);

        jSalvar.setText("Salvar");
        jSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvarActionPerformed(evt);
            }
        });

        jSair.setText("Sair");
        jSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSairActionPerformed(evt);
            }
        });

        jTabelaParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Participantes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTabelaParticipantes);

        jLabel5.setText("Identificador");

        jIdentificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIdentificadorActionPerformed(evt);
            }
        });

        try {
            jDataReuniao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDataReuniao, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLocalReuniao))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jParticipantes))
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jAdicionar)
                                .addComponent(jRemover))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jSair))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLocalReuniao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDataReuniao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jParticipantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAdicionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSalvar)
                    .addComponent(jSair))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLocalReuniaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLocalReuniaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLocalReuniaoActionPerformed

    private void jParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jParticipantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jParticipantesActionPerformed

    private void jIdentificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIdentificadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIdentificadorActionPerformed

    private void jAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarActionPerformed
        if(!jParticipantes.getText().isEmpty()){
            AtaParticipantes ataParticipantes = new AtaParticipantes();
            ataParticipantes.setParticipante(jParticipantes.getText());
            DefaultTableModel modelo = (DefaultTableModel) jTabelaParticipantes.getModel();
            
            modelo.addRow(new Object[]{
                ataParticipantes.getParticipante()
            });
        }else{
            JOptionPane.showMessageDialog(this, "Informe o nome do participante!");
        }
    }//GEN-LAST:event_jAdicionarActionPerformed

    private void jRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverActionPerformed
        int index =-1;
        
        index=jTabelaParticipantes.getSelectedRow();
        
        if(index!=-1){
            DefaultTableModel modelo = (DefaultTableModel) jTabelaParticipantes.getModel();
            modelo.removeRow(index);
        }else{
            JOptionPane.showMessageDialog(this, "Selecione o participante!");
        }
                
    }//GEN-LAST:event_jRemoverActionPerformed

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        dispose();
    }//GEN-LAST:event_jSairActionPerformed

    private void jSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarActionPerformed
        boolean dadosValidos=true;
        
        if(jIdentificador.getText().isEmpty() || jDataReuniao.getText().isEmpty() || jLocalReuniao.getText().isEmpty() 
           || jDeliberacoes.getText().isEmpty()){
            dadosValidos=false;
        }
        
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();
        
        //Verifica se a data é valida
        try {
            data = formatador.parse(jDataReuniao.getText());
        } catch (ParseException ex) {
                dadosValidos=false;
        }
        
        if (dadosValidos){
            AtaReuniao ataReuniao = new AtaReuniao();
            
            ataReuniao.setIdentificador(jIdentificador.getText());
            ataReuniao.setData(jDataReuniao.getText());
            ataReuniao.setLocal(jLocalReuniao.getText());
            ataReuniao.setDeliberacoes(jDeliberacoes.getText());
            
            AtaReuniaoDao ataReuniaoDao = new AtaReuniaoDao();
            AtaParticipantesDao ataParticipantesDao = new AtaParticipantesDao();
            
            List<AtaParticipantes> listaParticipantes = new ArrayList<>();
            DefaultTableModel modelo = (DefaultTableModel) jTabelaParticipantes.getModel();
            
            //Cria uma lista de objetos com os participantes inseridos na tabela do formulário
            for(int i=0; i<modelo.getRowCount();i++){
                AtaParticipantes ataParticipantes = new AtaParticipantes();
                ataParticipantes.setParticipante(modelo.getValueAt(i, 0).toString());
                listaParticipantes.add(ataParticipantes);
            }
            
            if(novo){
                if(ataReuniaoDao.Insere(ataReuniao)){
                    int idAta = ataReuniaoDao.getIdAta(jIdentificador.getText());

                    //Cadastra a lista de participantes
                    for(int i=0;i< listaParticipantes.size();i++ ){
                        ataParticipantesDao.Cria(idAta, listaParticipantes.get(i));
                    }
                    JOptionPane.showMessageDialog(this, "Ata cadastrada com sucesso.");
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Erro ao salvar a ata.");
                }
            }else{
                int idAta = ataReuniaoDao.getIdAta(identificadorAntigo);

                if(ataReuniaoDao.Altera(idAta, ataReuniao)){

                    //Cadastra a lista de participantes
                    ataParticipantesDao.Remove(idAta);
                    for(int i=0;i< listaParticipantes.size();i++ ){
                        ataParticipantesDao.Cria(idAta, listaParticipantes.get(i));
                    }
                    JOptionPane.showMessageDialog(this, "Ata alterada com sucesso.");
                }else{   
                    JOptionPane.showMessageDialog(this, "Erro ao alterar a ata.");
                }
            }
        }
    }//GEN-LAST:event_jSalvarActionPerformed
    public void alteraAta(String identificador){
        AtaReuniaoDao ataReuniaoDao = new AtaReuniaoDao();
        AtaReuniao ataReuniao = new AtaReuniao();
        
        int idAta = ataReuniaoDao.getIdAta(identificador);
        ataReuniao=ataReuniaoDao.getAta(idAta);
        
        if(!ataReuniao.getIdentificador().isEmpty()){
            jIdentificador.setText(ataReuniao.getIdentificador());
            jDataReuniao.setText(ataReuniao.getData());
            jLocalReuniao.setText(ataReuniao.getLocal());
            jDeliberacoes.setText(ataReuniao.getDeliberacoes());
            
            //Preenche a tabela participantes
            AtaParticipantesDao ataParticipantesDao = new AtaParticipantesDao();
            List<AtaParticipantes> ataParticipantes = ataParticipantesDao.getLista(idAta);
            DefaultTableModel modelo = (DefaultTableModel) jTabelaParticipantes.getModel();
            
            for(int i=0;i<ataParticipantes.size(); i++){
                modelo.addRow(new Object[]{
                    ataParticipantes.get(i).getParticipante()
                });
            }
            
            novo=false;
            identificadorAntigo = ataReuniao.getIdentificador();
        }else{
            JOptionPane.showMessageDialog(this, "Não foi possível exibir a Ata");
        }
    }
    public void consultaAta(String identificador){
        AtaReuniaoDao ataReuniaoDao = new AtaReuniaoDao();
        AtaReuniao ataReuniao = new AtaReuniao();
        
        int idAta = ataReuniaoDao.getIdAta(identificador);
        ataReuniao=ataReuniaoDao.getAta(idAta);
        
        if(!ataReuniao.getIdentificador().isEmpty()){
            jIdentificador.setText(ataReuniao.getIdentificador());
            jDataReuniao.setText(ataReuniao.getData());
            jLocalReuniao.setText(ataReuniao.getLocal());
            jDeliberacoes.setText(ataReuniao.getDeliberacoes());
            
            //Preenche a tabela participantes
            AtaParticipantesDao ataParticipantesDao = new AtaParticipantesDao();
            List<AtaParticipantes> ataParticipantes = ataParticipantesDao.getLista(idAta);
            DefaultTableModel modelo = (DefaultTableModel) jTabelaParticipantes.getModel();
            
            for(int i=0;i<ataParticipantes.size(); i++){
                modelo.addRow(new Object[]{
                    ataParticipantes.get(i).getParticipante()
                });
            }
            
            jSalvar.setEnabled(false);
            jAdicionar.setEnabled(false);
            jRemover.setEnabled(false);
            
        }else{
            JOptionPane.showMessageDialog(this, "Não foi possível exibir a Ata");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroAtaReuniao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAtaReuniao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAtaReuniao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAtaReuniao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroAtaReuniao dialog = new CadastroAtaReuniao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAdicionar;
    private javax.swing.JFormattedTextField jDataReuniao;
    private javax.swing.JTextArea jDeliberacoes;
    private javax.swing.JTextField jIdentificador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jLocalReuniao;
    private javax.swing.JTextField jParticipantes;
    private javax.swing.JButton jRemover;
    private javax.swing.JButton jSair;
    private javax.swing.JButton jSalvar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTabelaParticipantes;
    // End of variables declaration//GEN-END:variables
}

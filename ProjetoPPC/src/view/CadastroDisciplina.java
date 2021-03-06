package view;

import dao.DisciplinaDao;
import entity.Disciplina;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author gbarboza
 */
public class CadastroDisciplina extends javax.swing.JDialog {

    boolean novo; //Varial utilizada para saber se está sendo cadastrado uma nova discplina ou alterado uma existente.
    String codigoDisciplina; // Variavel recebe o código da disciplina do form de gestão de disciplinas e utiliza para fazer consultas
    
    public CadastroDisciplina(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.novo = true;
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSemestre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCargaHoraria = new javax.swing.JTextField();
        jSalvar = new javax.swing.JButton();
        jSair = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome da Disciplina");

        jLabel2.setText("Descrição");

        jLabel3.setText("Código da Disciplina");

        jCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jCodigoFocusGained(evt);
            }
        });

        jLabel4.setText("Semestre");

        jLabel5.setText("Carga Horária");

        jCargaHoraria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCargaHorariaKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDescricao))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCodigo))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSalvar)
                    .addComponent(jSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarActionPerformed

        //Verifica se os campos foram preenchidos corretamente
        if(jNome.getText().isEmpty() || jDescricao.getText().isEmpty() || jCodigo.getText().isEmpty() 
        || jSemestre.getText().isEmpty() || jCargaHoraria.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro de preenchimento", JOptionPane.WARNING_MESSAGE);
        }else{
            
            //Instancia e envia os dados inseridos no formulário para o objeto disciplina
            Disciplina disciplina = new Disciplina();

            disciplina.setNome(jNome.getText());
            disciplina.setDescricao(jDescricao.getText());
            disciplina.setCodigo(jCodigo.getText());
            disciplina.setSemestre(jSemestre.getText());
            disciplina.setCargaHoraria(Integer.parseInt(jCargaHoraria.getText()));

            DisciplinaDao disciplinaDao = new DisciplinaDao();

            if (novo){
                //Verifica se a disciplina já existe
                if(disciplinaDao.getDisciplina(disciplina.getCodigo()).getCodigo()==null){
                    //Trecho executado para cadastros de novas disciplinas
                    if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cadastrar a disciplina?", "Excluir Disciplina", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                        if (disciplinaDao.Insere(disciplina)){
                           JOptionPane.showMessageDialog(this, "Disciplina cadastrada com sucesso!");
                           dispose();
                       }else{
                           JOptionPane.showMessageDialog(this, "Erro ao cadastrar a disciplina!");
                       }
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Já existe uma disciplina cadastrada com esse código!","Disciplina já cadastrada", JOptionPane.WARNING_MESSAGE);
                    jCodigo.setBackground(Color.red);
                }
            //Trecho executado para alteração de uma disciplina existente    
            }else{
                if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar a disciplina?", "Excluir Disciplina", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    if (disciplinaDao.Altera(disciplina, codigoDisciplina)){
                        JOptionPane.showMessageDialog(this, "Disciplina alterada com sucesso!");
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(this, "Erro ao alterar a disciplina!","Erro ao alterar", JOptionPane.WARNING_MESSAGE );
                    }
                }
            }
        }
    }//GEN-LAST:event_jSalvarActionPerformed

    private void jSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSairActionPerformed
        dispose();
    }//GEN-LAST:event_jSairActionPerformed

    private void jCargaHorariaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCargaHorariaKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
        evt.consume();
        }
    }//GEN-LAST:event_jCargaHorariaKeyTyped

    private void jCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCodigoFocusGained
        jCodigo.setBackground(Color.white);
    }//GEN-LAST:event_jCodigoFocusGained

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
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroDisciplina dialog = new CadastroDisciplina(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jCargaHoraria;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JTextField jDescricao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jNome;
    private javax.swing.JButton jSair;
    private javax.swing.JButton jSalvar;
    private javax.swing.JTextField jSemestre;
    // End of variables declaration//GEN-END:variables

public void consultaDisciplina(String codigo){
    DisciplinaDao disciplinaDao = new DisciplinaDao();
    Disciplina disciplina = new Disciplina();
    
    disciplina = disciplinaDao.getDisciplina(codigo);
    if (!disciplina.getNome().isEmpty()){
        jNome.setText(disciplina.getNome());
        jDescricao.setText(disciplina.getDescricao());
        jCodigo.setText(disciplina.getCodigo());
        jSemestre.setText(disciplina.getSemestre());
        jCargaHoraria.setText(String.valueOf(disciplina.getCargaHoraria()));
        
        jNome.setEnabled(false);
        jDescricao.setEnabled(false);
        jCodigo.setEnabled(false);
        jSemestre.setEnabled(false);
        jCargaHoraria.setEnabled(false);
        
        jSalvar.setVisible(false);
    }else{
        JOptionPane.showMessageDialog(this, "Não foi possível consultar a disciplina");
        dispose();
    }
    }

    public void alteraDisciplina(String codigo){
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        Disciplina disciplina = new Disciplina();

        disciplina = disciplinaDao.getDisciplina(codigo);
        if (!disciplina.getNome().isEmpty()){

            jNome.setText(disciplina.getNome());
            jDescricao.setText(disciplina.getDescricao());
            jCodigo.setText(disciplina.getCodigo());
            jSemestre.setText(disciplina.getSemestre());
            jCargaHoraria.setText(String.valueOf(disciplina.getCargaHoraria()));

            //Define que não se trata de uma item novo, mas de uma alteração, utilizado ao acionar o botão salvar
            novo = false;
            codigoDisciplina=codigo;

        }else{
            JOptionPane.showMessageDialog(this, "Não foi possível consultar a disciplina");
            dispose();
        }
    }
}

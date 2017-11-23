/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CursoDao;
import dao.SimulacaoCategoriaAdmAcademicaDao;
import dao.SimulacaoCategoriaPerfilDocentesDao;
import dao.SimulacaoCategoriaPpcDao;
import dao.SimulacaoCategoriaPpcFormacaoDao;
import dao.SimulacaoCondicoesTrabalhoDao;
import dao.SimulacaoMecDao;
import entity.Curso;
import entity.SimulacaoAvaliacaoMec;
import entity.SimulacaoCategoriaAdmAcademica;
import entity.SimulacaoCategoriaPerfilDocentes;
import entity.SimulacaoCategoriaPpc;
import entity.SimulacaoCategoriaPpcFormacao;
import entity.SimulacaoCondicoesTrabalho;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class SimuladorAvaliacaoMEC extends javax.swing.JDialog {


    boolean novo=true;
    float mediaDimensao1, mediaDimensao2;
    /**
     * Creates new form SimuladorAvaliacaoMEC
     */
    public SimuladorAvaliacaoMEC(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(666, 185);
    }

    public void iniciaSimulacao(String identificador){
        SimulacaoMecDao simulacaoMecDao = new SimulacaoMecDao();
        
        SimulacaoAvaliacaoMec simulacaoAvaliacaoMec = new SimulacaoAvaliacaoMec();
        int idSimulacao = simulacaoMecDao.getIdSimulacao(identificador);
        simulacaoAvaliacaoMec = simulacaoMecDao.getSimulacao(idSimulacao);

        if (!simulacaoAvaliacaoMec.getIdentificadorSimulacao().isEmpty()){
            
            listaCursos();
                
            CursoDao cursoDao = new CursoDao();
            Curso curso = cursoDao.getCurso(simulacaoAvaliacaoMec.getFk_id_curso());
            jListaCursos.setSelectedItem(curso.getDenominacao());
            
            
            jIdentificador.setText(simulacaoAvaliacaoMec.getIdentificadorSimulacao());
            jNotaFinal.setText(simulacaoAvaliacaoMec.getNotaFinal());
            jSugestaoMelhoria1.setText(simulacaoAvaliacaoMec.getSugestaoMelhoriaDimensao1());
            jSugestaoMelhoria2.setText(simulacaoAvaliacaoMec.getSugestaoMelhoriaDimensao2());
            
                //Preenche os dados da tabela Categoria Academica
               
                SimulacaoCategoriaAdmAcademicaDao sCAA = new SimulacaoCategoriaAdmAcademicaDao();
                SimulacaoCategoriaAdmAcademica simulacaoCategoriaAdmAcademica = sCAA.getSimulacaoCategoriaAdmAcademica(idSimulacao);
                
                jTabelaAnaliseAdm.setValueAt(simulacaoCategoriaAdmAcademica.getNotaComposicaoNde(), 0,1);
                jTabelaAnaliseAdm.setValueAt(simulacaoCategoriaAdmAcademica.getNotaTitulacaoNde(),1,1 );
                jTabelaAnaliseAdm.setValueAt(simulacaoCategoriaAdmAcademica.getNotaExperiencia(), 2, 1);
                jTabelaAnaliseAdm.setValueAt(simulacaoCategoriaAdmAcademica.getNotaRegima(), 3, 1);
                jTabelaAnaliseAdm.setValueAt(simulacaoCategoriaAdmAcademica.getNotaTitulação(), 4, 1);
                jTabelaAnaliseAdm.setValueAt(simulacaoCategoriaAdmAcademica.getNotaFormacao(), 5, 1);
                jTabelaAnaliseAdm.setValueAt(simulacaoCategoriaAdmAcademica.getNotaRegimeCoordenador(), 6, 1);
                jTabelaAnaliseAdm.setValueAt(simulacaoCategoriaAdmAcademica.getNotaComposição(), 7, 1);
                        
                SimulacaoCategoriaPerfilDocentesDao  sCPD = new SimulacaoCategoriaPerfilDocentesDao();
                SimulacaoCategoriaPerfilDocentes simulacaoCategoriaPerfilDocentes = sCPD.getSimulacaoCategoriaPerfilDocentes(idSimulacao);
                
                jTabelaPerfilDocentes.setValueAt(simulacaoCategoriaPerfilDocentes.getNotaTitulacao(),0, 1);
                jTabelaPerfilDocentes.setValueAt(simulacaoCategoriaPerfilDocentes.getNotaRegime(),1, 1);
                jTabelaPerfilDocentes.setValueAt(simulacaoCategoriaPerfilDocentes.getNotaTempoExperienciaMagisterio(),2, 1);
                jTabelaPerfilDocentes.setValueAt(simulacaoCategoriaPerfilDocentes.getNotaTempoExperienciaCorpoDocente(),3, 1);

                SimulacaoCategoriaPpcDao sCP = new SimulacaoCategoriaPpcDao();
                SimulacaoCategoriaPpc simulacaoCategoriaPpc = sCP.getSimulacaoCategoriaPpc(idSimulacao);
                
                jTabelaPPC.setValueAt(simulacaoCategoriaPpc.getNotaContextoEducacional(), 0, 1);
                jTabelaPPC.setValueAt(simulacaoCategoriaPpc.getNotaAutoAvaliacao(), 1, 1);
                jTabelaPPC.setValueAt(simulacaoCategoriaPpc.getNotaObjetivosCurso(), 2, 1);
                jTabelaPPC.setValueAt(simulacaoCategoriaPpc.getNotaPerfilProf(), 3, 1);
                jTabelaPPC.setValueAt(simulacaoCategoriaPpc.getNotaNumeroVagas(), 4, 1);
               
                SimulacaoCategoriaPpcFormacaoDao sCPF = new SimulacaoCategoriaPpcFormacaoDao();
                SimulacaoCategoriaPpcFormacao simulacaoCategoriaPpcFormacao = sCPF.getSimulacaoCategoriaPpcFormacao(idSimulacao);
                
                jTabelaPPCFormacao.setValueAt(simulacaoCategoriaPpcFormacao.getNotaEstruturaCurricular(), 0, 1);
                jTabelaPPCFormacao.setValueAt(simulacaoCategoriaPpcFormacao.getNotaConteudosCurriculares(), 1, 1);
                jTabelaPPCFormacao.setValueAt(simulacaoCategoriaPpcFormacao.getNotaMetodologia(), 2, 1);
                jTabelaPPCFormacao.setValueAt(simulacaoCategoriaPpcFormacao.getNotaAtendimentoDiscente(), 3, 1);
                
                
                
                SimulacaoCondicoesTrabalhoDao sCT = new SimulacaoCondicoesTrabalhoDao();
                SimulacaoCondicoesTrabalho simulacaoCondicoesTrabalho = new SimulacaoCondicoesTrabalho();
                jTabelaCondicoesTrabalho.setValueAt(simulacaoCondicoesTrabalho.getNotaNumeroAlunosDocente(), 0, 1);
                jTabelaCondicoesTrabalho.setValueAt(simulacaoCondicoesTrabalho.getNotaNumeroAlunosTurma(), 1, 1);
                jTabelaCondicoesTrabalho.setValueAt(simulacaoCondicoesTrabalho.getNotaNumeroDisciplinasDocente(), 2, 1);
                jTabelaCondicoesTrabalho.setValueAt(simulacaoCondicoesTrabalho.getNotaPesquisa(), 3, 1);
                jTabelaCondicoesTrabalho.setValueAt(simulacaoCondicoesTrabalho.getNotaProdução(), 4, 1);
            
            
                jIdentificador.setEnabled(false);
                jIniciarSimulacao.setEnabled(false);
                jTabbedPane1.setEnabled(true);

            //Define que não se trata de uma item novo, mas de uma alteração
            novo = false;

        }else{
            JOptionPane.showMessageDialog(this, "Não foi possível consultar o professor");
            dispose();
        }
    }
   
    public float calculaDimensao1(){
        float[] notasPPC = new float[5];
        float[] notasPPCFormacao = new float[4];
        
        float mediaPPC, mediaPPCFormacao;
        
        for(int i=0; i< jTabelaPPC.getRowCount();i++){
            
            notasPPC[i]=Integer.parseInt(jTabelaPPC.getValueAt(i, 1).toString());
            } 
        mediaPPC=(notasPPC[0]+notasPPC[1]+notasPPC[2]+notasPPC[3]+notasPPC[4])/5;
        
        for(int i=0; i< jTabelaPPCFormacao.getRowCount();i++){
            notasPPCFormacao[i]=Integer.parseInt(jTabelaPPCFormacao.getValueAt(i, 1).toString());
            } 
        mediaPPCFormacao=(notasPPCFormacao[0]+notasPPCFormacao[1]+notasPPCFormacao[2]+notasPPCFormacao[3])/4;
        mediaDimensao1= (mediaPPC+mediaPPCFormacao)/2;
        return mediaDimensao1;
    }
    public float calculaDimensao2(){
        float[] notasAdm = new float[9];
        float[] notasPerfilDocentes = new float[4];        
        float[] notasCondicoesTrabalho= new float[5];

        float mediaAdm, mediaPerfilDocentes, mediaCondicoesTrabalho;
        
        for(int i=0; i< jTabelaAnaliseAdm.getRowCount();i++){
            
            notasAdm[i]=Integer.parseInt(jTabelaAnaliseAdm.getValueAt(i, 1).toString());
            } 
        
        mediaAdm=(notasAdm[0]+notasAdm[1]+notasAdm[2]+notasAdm[3]+notasAdm[4]+notasAdm[5]+notasAdm[6]+notasAdm[7])/8;
        
        for(int i=0; i< jTabelaPerfilDocentes.getRowCount();i++){
            notasPerfilDocentes[i]=Integer.parseInt(jTabelaPerfilDocentes.getValueAt(i, 1).toString());
            } 
        mediaPerfilDocentes=(notasPerfilDocentes[0]+notasPerfilDocentes[1]+notasPerfilDocentes[2]+notasPerfilDocentes[3])/4;
      
        for(int i=0; i< jTabelaCondicoesTrabalho.getRowCount();i++){
            notasCondicoesTrabalho[i]=Integer.parseInt(jTabelaCondicoesTrabalho.getValueAt(i, 1).toString());
            } 
        mediaCondicoesTrabalho=(notasCondicoesTrabalho[0]+notasCondicoesTrabalho[1]+notasCondicoesTrabalho[2]+notasCondicoesTrabalho[3]+notasCondicoesTrabalho[4])/5;
              
        mediaDimensao2=(mediaAdm+mediaPerfilDocentes+mediaCondicoesTrabalho)/3;
        return mediaDimensao2;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jListaCursos = new javax.swing.JComboBox<>();
        jIniciarSimulacao = new javax.swing.JButton();
        jIdentificador = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabelaPPC = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTabelaPPCFormacao = new javax.swing.JTable();
        jSalvarDimensao1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTabelaAnaliseAdm = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTabelaCondicoesTrabalho = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTabelaPerfilDocentes = new javax.swing.JTable();
        jSalvarDimensao2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jSugestaoMelhoria1 = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jSugestaoMelhoria2 = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jListaDimensoes = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jNotaDimensao = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jProporMelhoria = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jNotaFinal = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jCalcularNotas = new javax.swing.JButton();
        jSalvar = new javax.swing.JButton();

        jLabel22.setText("jLabel22");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Identificação do Curso"));

        jLabel1.setText("Tipo do Curso:");

        jLabel3.setText("Identificador da Simulação");

        jIniciarSimulacao.setText("Iniciar Simulação");
        jIniciarSimulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIniciarSimulacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jListaCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jIdentificador))
                .addGap(36, 36, 36)
                .addComponent(jIniciarSimulacao)
                .addGap(243, 243, 243))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jListaCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jIniciarSimulacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria de Análise: Projeto Pedagógico do Curso"));

        jLabel4.setText("Insira uma note entre 1 e 5");

        jTabelaPPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Contexto Educacional", null},
                {"Autoavaliação", null},
                {"Objetivos do Curso", null},
                {"Perfil prof. do Egresso", null},
                {"Número de Vagas", null}
            },
            new String [] {
                "Indicador", "Nota"
            }
        ));
        jScrollPane4.setViewportView(jTabelaPPC);
        if (jTabelaPPC.getColumnModel().getColumnCount() > 0) {
            jTabelaPPC.getColumnModel().getColumn(1).setMinWidth(10);
            jTabelaPPC.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTabelaPPC.getColumnModel().getColumn(1).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria de Análise: Projeto Pedagógico do Curso: Formação"));

        jLabel7.setText("Insira uma note entre 1 e 5");

        jTabelaPPCFormacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Estrutura Curricular", null},
                {"Conteúdos Curriculares", null},
                {"Metodologia", null},
                {"Atendimento ao Discente", null}
            },
            new String [] {
                "Indicador", "Nota"
            }
        ));
        jScrollPane5.setViewportView(jTabelaPPCFormacao);
        if (jTabelaPPCFormacao.getColumnModel().getColumnCount() > 0) {
            jTabelaPPCFormacao.getColumnModel().getColumn(1).setMinWidth(10);
            jTabelaPPCFormacao.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTabelaPPCFormacao.getColumnModel().getColumn(1).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSalvarDimensao1.setText("Salvar");
        jSalvarDimensao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvarDimensao1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSalvarDimensao1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSalvarDimensao1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        jTabbedPane1.addTab("Dimensão 1", jScrollPane1);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria de Análise: Adm. Acadêmica"));

        jLabel9.setText("Insira uma note entre 1 e 5");

        jTabelaAnaliseAdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Composição do Núcleo Docente Estruturante – NDE", null},
                {"Titulação do NDE", null},
                {"Experiência profissional do NDE", null},
                {"Regime de trabalho do NDE", null},
                {"Titulação", null},
                {"Formação acadêmica e experiência do coordenador do curso", null},
                {"Regime de trabalho do coordenador do curso", null},
                {"Composição e funcionamento do colegiado de curso ou equivalente", null}
            },
            new String [] {
                "Indicador", "Nota"
            }
        ));
        jScrollPane6.setViewportView(jTabelaAnaliseAdm);
        if (jTabelaAnaliseAdm.getColumnModel().getColumnCount() > 0) {
            jTabelaAnaliseAdm.getColumnModel().getColumn(1).setMinWidth(10);
            jTabelaAnaliseAdm.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTabelaAnaliseAdm.getColumnModel().getColumn(1).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria de Análise: Condições de Trabalho"));

        jLabel11.setText("Insira uma note entre 1 e 5");

        jTabelaCondicoesTrabalho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Número de alunos por docente", null},
                {"Número de alunos por turma em disciplina teórica", null},
                {"Número médio de disciplinas por docente", null},
                {"Pesquisa", null},
                {"Produção científica e tecnológica", null}
            },
            new String [] {
                "Indicador", "Nota"
            }
        ));
        jScrollPane7.setViewportView(jTabelaCondicoesTrabalho);
        if (jTabelaCondicoesTrabalho.getColumnModel().getColumnCount() > 0) {
            jTabelaCondicoesTrabalho.getColumnModel().getColumn(1).setMinWidth(10);
            jTabelaCondicoesTrabalho.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTabelaCondicoesTrabalho.getColumnModel().getColumn(1).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria de Análise: Perfil dos Docentes"));

        jLabel13.setText("Insira uma note entre 1 e 5");

        jTabelaPerfilDocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Titulação do corpo docente", null},
                {"Regime de trabalho do corpo docente", null},
                {"Tempo de experiência de magistério superior ou experiência na educação profissional", null},
                {"Tempo de experiência profissional do corpo docente (fora do magistério)", null}
            },
            new String [] {
                "Indicador", "Nota"
            }
        ));
        jScrollPane8.setViewportView(jTabelaPerfilDocentes);
        if (jTabelaPerfilDocentes.getColumnModel().getColumnCount() > 0) {
            jTabelaPerfilDocentes.getColumnModel().getColumn(1).setMinWidth(10);
            jTabelaPerfilDocentes.getColumnModel().getColumn(1).setPreferredWidth(40);
            jTabelaPerfilDocentes.getColumnModel().getColumn(1).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSalvarDimensao2.setText("Salvar");
        jSalvarDimensao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvarDimensao2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSalvarDimensao2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSalvarDimensao2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel4);

        jTabbedPane1.addTab("Dimensão 2", jScrollPane2);

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setText("Descreva a sugestão de melhoria para a Dimensão 1");

        jSugestaoMelhoria1.setColumns(20);
        jSugestaoMelhoria1.setRows(5);
        jScrollPane9.setViewportView(jSugestaoMelhoria1);

        jLabel25.setText("Descreva a sugestão de melhoria para a Dimensão 2");

        jSugestaoMelhoria2.setColumns(20);
        jSugestaoMelhoria2.setRows(5);
        jScrollPane10.setViewportView(jSugestaoMelhoria2);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setText("Formulário de Reconhecimento de Curso");

        jListaDimensoes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dimensão 1", "Dimensão 2" }));
        jListaDimensoes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jListaDimensoesItemStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jNotaDimensao.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jNotaDimensao.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jNotaDimensao)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNotaDimensao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel16.setText("Nota atribuída");

        jProporMelhoria.setText("Propor Melhoria");
        jProporMelhoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProporMelhoriaActionPerformed(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jNotaFinal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jNotaFinal.setText("0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jNotaFinal)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jNotaFinal)
                .addContainerGap())
        );

        jLabel21.setText("Nota final");

        jCalcularNotas.setText("Calcular Notas");
        jCalcularNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCalcularNotasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jListaDimensoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15))
                            .addGap(18, 18, 18)
                            .addComponent(jProporMelhoria)
                            .addGap(18, 18, 18))
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(248, 248, 248)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCalcularNotas)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jListaDimensoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProporMelhoria)
                    .addComponent(jCalcularNotas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jSalvar.setText("Salvar");
        jSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSalvar)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSalvar)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel5);

        jTabbedPane1.addTab("Simular Notas", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(novo){
            listaCursos();
        }else{
            mediaDimensao1=calculaDimensao1();
            mediaDimensao2=calculaDimensao2();
            this.setSize(666, 630);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jIniciarSimulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIniciarSimulacaoActionPerformed
       boolean dadosValidos=true;
       
       if(jListaCursos.getSelectedItem().equals("Selecione")){
           JOptionPane.showMessageDialog(this, "Selecione o curso!");
           dadosValidos=false;
       }
       if(jIdentificador.getText().isEmpty()){
           JOptionPane.showMessageDialog(this, "Informe o identificador.");
           dadosValidos=false;
       }
       
       if(dadosValidos){
           SimulacaoMecDao simulacaoMecDao = new SimulacaoMecDao();
           SimulacaoAvaliacaoMec simulacaoAvaliacaoMec = new SimulacaoAvaliacaoMec();
           
           CursoDao cursoDao = new CursoDao();
           int idCurso = cursoDao.getIdCurso(jListaCursos.getSelectedItem().toString());
           
           simulacaoAvaliacaoMec.setIdentificadorSimulacao(jIdentificador.getText());
           
           if(novo){
               if(simulacaoMecDao.Cria(idCurso, simulacaoAvaliacaoMec)){
                   //recupera o id do curso recem criado
                   int idSimulacao = simulacaoMecDao.getIdSimulacao(simulacaoAvaliacaoMec.getIdentificadorSimulacao());
                   
                   //Cria os registros para as tabelas auxiliares
                   SimulacaoCategoriaAdmAcademicaDao sCAA = new SimulacaoCategoriaAdmAcademicaDao();
                   sCAA.Cria(idSimulacao);
                   
                   SimulacaoCategoriaPerfilDocentesDao  sCPD = new SimulacaoCategoriaPerfilDocentesDao();
                   sCPD.Cria(idSimulacao);
                   
                   SimulacaoCategoriaPpcDao sCP = new SimulacaoCategoriaPpcDao();
                   sCP.Cria(idSimulacao);
                   
                   SimulacaoCategoriaPpcFormacaoDao sCPF = new SimulacaoCategoriaPpcFormacaoDao();
                   sCPF.Cria(idSimulacao);
                   
                   SimulacaoCondicoesTrabalhoDao sCT = new SimulacaoCondicoesTrabalhoDao();
                   sCT.Cria(idSimulacao);

                    //Redimensiona a janela para exibir todo o conteudo
                    this.setSize(666, 630);
                    jTabbedPane1.setEnabledAt(1, false);
                    jTabbedPane1.setEnabledAt(2, false);
                    jTabbedPane1.setEnabledAt(0, true);
                    
                    jIdentificador.setEnabled(false);
               }else{
                   JOptionPane.showMessageDialog(this, "Erro ao iniciar a simulação.");
               }
           }
       }
    }//GEN-LAST:event_jIniciarSimulacaoActionPerformed

    private void jSalvarDimensao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarDimensao1ActionPerformed
        boolean dadosValidos=true;
        
        //Verifica se os itens da tabela PPC foram preenchidos
        for(int i=0; i< jTabelaPPC.getRowCount();i++){
            Object celula = jTabelaPPC.getValueAt(i, 1);
            if(celula==null){
              dadosValidos=false;
            } 
        }
        
        //Verifica se os itens da tabela PPC Formação foram preenchidos
        for(int i=0; i< jTabelaPPCFormacao.getRowCount();i++){
            Object celula = jTabelaPPCFormacao.getValueAt(i, 1);
            if(celula==null){
              dadosValidos=false;
            } 
        }
        
        if(dadosValidos){
            SimulacaoMecDao simulacaoMecDao = new SimulacaoMecDao();
            int idSimulacao = simulacaoMecDao.getIdSimulacao(jIdentificador.getText());
            
            //Atualiza as notas da tabela PPC
            SimulacaoCategoriaPpc simulacaoCategoriaPpc = new SimulacaoCategoriaPpc();
            
            simulacaoCategoriaPpc.setNotaContextoEducacional(Integer.parseInt(jTabelaPPC.getValueAt(0, 1).toString()));
            simulacaoCategoriaPpc.setNotaAutoAvaliacao(Integer.parseInt(jTabelaPPC.getValueAt(1, 1).toString()));
            simulacaoCategoriaPpc.setNotaObjetivosCurso(Integer.parseInt(jTabelaPPC.getValueAt(2, 1).toString()));
            simulacaoCategoriaPpc.setNotaPerfilProf(Integer.parseInt(jTabelaPPC.getValueAt(3, 1).toString()));
            simulacaoCategoriaPpc.setNotaNumeroVagas(Integer.parseInt(jTabelaPPC.getValueAt(4, 1).toString()));
            
            SimulacaoCategoriaPpcDao simulacaoCategoriaPpcDao = new SimulacaoCategoriaPpcDao();
            simulacaoCategoriaPpcDao.Altera(idSimulacao, simulacaoCategoriaPpc);
            
            //Atualiza as notas da tabela PPC Formacao
            SimulacaoCategoriaPpcFormacao simulacaoCategoriaPpcFormacao = new SimulacaoCategoriaPpcFormacao();
            
            simulacaoCategoriaPpcFormacao.setNotaEstruturaCurricular(Integer.parseInt(jTabelaPPCFormacao.getValueAt(0, 1).toString()));
            simulacaoCategoriaPpcFormacao.setNotaConteudosCurriculares(Integer.parseInt(jTabelaPPCFormacao.getValueAt(1, 1).toString()));
            simulacaoCategoriaPpcFormacao.setNotaMetodologia(Integer.parseInt(jTabelaPPCFormacao.getValueAt(2, 1).toString()));
            simulacaoCategoriaPpcFormacao.setNotaAtendimentoDiscente(Integer.parseInt(jTabelaPPCFormacao.getValueAt(3, 1).toString()));
            
            SimulacaoCategoriaPpcFormacaoDao simulacaoCategoriaPpcFormacaoDao = new SimulacaoCategoriaPpcFormacaoDao();
            simulacaoCategoriaPpcFormacaoDao.Altera(idSimulacao, simulacaoCategoriaPpcFormacao);
            
            JOptionPane.showMessageDialog(this, "Dados gravados com sucesso!");
            jTabbedPane1.setEnabledAt(1, true);
            
        }else{
            JOptionPane.showMessageDialog(this, "Informe todas as notas.");
        }
    }//GEN-LAST:event_jSalvarDimensao1ActionPerformed

    private void jSalvarDimensao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarDimensao2ActionPerformed
        boolean dadosValidos=true;
        
        //Verifica se os itens da tabela Analise Adm foram preenchidos
        for(int i=0; i< jTabelaAnaliseAdm.getRowCount();i++){
            Object celula = jTabelaAnaliseAdm.getValueAt(i, 1);
            if(celula==null){
              dadosValidos=false;
            } 
        }
        
        //Verifica se os itens da tabela Perfil docente foram preenchidos
        for(int i=0; i< jTabelaPerfilDocentes.getRowCount();i++){
            Object celula = jTabelaPerfilDocentes.getValueAt(i, 1);
            if(celula==null){
              dadosValidos=false;
            } 
        }
        //Verifica se os itens da tabela Condicoes trabalho foram preenchidos
        for(int i=0; i< jTabelaCondicoesTrabalho.getRowCount();i++){
            Object celula = jTabelaCondicoesTrabalho.getValueAt(i, 1);
            if(celula==null){
              dadosValidos=false;
            } 
        }        
        
        if(dadosValidos){
            SimulacaoMecDao simulacaoMecDao = new SimulacaoMecDao();
            int idSimulacao = simulacaoMecDao.getIdSimulacao(jIdentificador.getText());
            
            //Atualiza as notas da tabela Analise Academica
            SimulacaoCategoriaAdmAcademica simulacaoCategoriaAdmAcademica = new SimulacaoCategoriaAdmAcademica();
            
            simulacaoCategoriaAdmAcademica.setNotaComposicaoNde(Integer.parseInt(jTabelaAnaliseAdm.getValueAt(0, 1).toString()));
            simulacaoCategoriaAdmAcademica.setNotaTitulacaoNde(Integer.parseInt(jTabelaAnaliseAdm.getValueAt(1, 1).toString()));
            simulacaoCategoriaAdmAcademica.setNotaExperiencia(Integer.parseInt(jTabelaAnaliseAdm.getValueAt(2, 1).toString()));
            simulacaoCategoriaAdmAcademica.setNotaRegima(Integer.parseInt(jTabelaAnaliseAdm.getValueAt(3, 1).toString()));
            simulacaoCategoriaAdmAcademica.setNotaTitulação(Integer.parseInt(jTabelaAnaliseAdm.getValueAt(4, 1).toString()));
            simulacaoCategoriaAdmAcademica.setNotaFormacao(Integer.parseInt(jTabelaAnaliseAdm.getValueAt(5, 1).toString()));
            simulacaoCategoriaAdmAcademica.setNotaRegimeCoordenador(Integer.parseInt(jTabelaAnaliseAdm.getValueAt(6, 1).toString()));
            simulacaoCategoriaAdmAcademica.setNotaComposição(Integer.parseInt(jTabelaAnaliseAdm.getValueAt(7, 1).toString()));
            
            
            SimulacaoCategoriaAdmAcademicaDao simulacaoCategoriaAdmAcademicaDao = new SimulacaoCategoriaAdmAcademicaDao();
            simulacaoCategoriaAdmAcademicaDao.Altera(idSimulacao, simulacaoCategoriaAdmAcademica);
            
            //Atualiza as notas da tabela Perfil Docentes
            SimulacaoCategoriaPerfilDocentes simulacaoCategoriaPerfilDocentes = new SimulacaoCategoriaPerfilDocentes();
            
            simulacaoCategoriaPerfilDocentes.setNotaTitulacao(Integer.parseInt(jTabelaPerfilDocentes.getValueAt(0, 1).toString()));
            simulacaoCategoriaPerfilDocentes.setNotaRegime(Integer.parseInt(jTabelaPerfilDocentes.getValueAt(1, 1).toString()));
            simulacaoCategoriaPerfilDocentes.setNotaTempoExperienciaMagisterio(Integer.parseInt(jTabelaPerfilDocentes.getValueAt(2, 1).toString()));
            simulacaoCategoriaPerfilDocentes.setNotaTempoExperienciaCorpoDocente(Integer.parseInt(jTabelaPerfilDocentes.getValueAt(3, 1).toString()));
            
            SimulacaoCategoriaPerfilDocentesDao simulacaoCategoriaPerfilDocentesDao = new SimulacaoCategoriaPerfilDocentesDao();
            simulacaoCategoriaPerfilDocentesDao.Altera(idSimulacao, simulacaoCategoriaPerfilDocentes);
            
            //Atualiza as notas da tabela Condicoes Trabalho
            SimulacaoCondicoesTrabalho simulacaoCondicoesTrabalho = new SimulacaoCondicoesTrabalho();
            
            simulacaoCondicoesTrabalho.setNotaNumeroAlunosDocente(Integer.parseInt(jTabelaCondicoesTrabalho.getValueAt(0, 1).toString()));
            simulacaoCondicoesTrabalho.setNotaNumeroAlunosTurma(Integer.parseInt(jTabelaCondicoesTrabalho.getValueAt(1, 1).toString()));
            simulacaoCondicoesTrabalho.setNotaNumeroDisciplinasDocente(Integer.parseInt(jTabelaCondicoesTrabalho.getValueAt(2, 1).toString()));
            simulacaoCondicoesTrabalho.setNotaPesquisa(Integer.parseInt(jTabelaCondicoesTrabalho.getValueAt(3, 1).toString()));
            simulacaoCondicoesTrabalho.setNotaProdução(Integer.parseInt(jTabelaCondicoesTrabalho.getValueAt(4, 1).toString()));
            
            SimulacaoCondicoesTrabalhoDao simulacaoCondicoesTrabalhoDao = new SimulacaoCondicoesTrabalhoDao();
            simulacaoCondicoesTrabalhoDao.Altera(idSimulacao, simulacaoCondicoesTrabalho);
           
            JOptionPane.showMessageDialog(this, "Dados gravados com sucesso!");
            jTabbedPane1.setEnabledAt(2, true);
            
        }else{
            JOptionPane.showMessageDialog(this, "Informe todas as notas.");
        }
    }//GEN-LAST:event_jSalvarDimensao2ActionPerformed

    private void jListaDimensoesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jListaDimensoesItemStateChanged
        if(jListaDimensoes.getSelectedItem().equals("Dimensão 1")){
            float media=calculaDimensao1();
            DecimalFormat formatador = new DecimalFormat();
            formatador.setMaximumFractionDigits(2);
            jNotaDimensao.setText(formatador.format(media));
        }else if(jListaDimensoes.getSelectedItem().equals("Dimensão 2")){
            float media=calculaDimensao2();
            DecimalFormat formatador = new DecimalFormat();
            formatador.setMaximumFractionDigits(2);
            jNotaDimensao.setText(formatador.format(media));
        } 
    }//GEN-LAST:event_jListaDimensoesItemStateChanged

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if(jTabbedPane1.getSelectedIndex()==2){
            if(jListaDimensoes.getSelectedIndex()==0){
               float media=calculaDimensao1();
                DecimalFormat formatador = new DecimalFormat();
                formatador.setMaximumFractionDigits(2);
                jNotaDimensao.setText(formatador.format(media));
            }else{
                float media=calculaDimensao1();
                DecimalFormat formatador = new DecimalFormat();
                formatador.setMaximumFractionDigits(2);
                jNotaDimensao.setText(formatador.format(media));
            }
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jProporMelhoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProporMelhoriaActionPerformed
    if(jListaDimensoes.getSelectedItem().equals("Dimensão 1")){
            jSugestaoMelhoria1.requestFocus();
        }else if(jListaDimensoes.getSelectedItem().equals("Dimensão 2")){
             jSugestaoMelhoria2.requestFocus();
        } 
    }//GEN-LAST:event_jProporMelhoriaActionPerformed

    private void jCalcularNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCalcularNotasActionPerformed
        DecimalFormat formatador = new DecimalFormat();
        formatador.setMaximumFractionDigits(2);
        float notaFinal=(mediaDimensao1+mediaDimensao2)/2;
        jNotaFinal.setText(formatador.format(notaFinal));
    }//GEN-LAST:event_jCalcularNotasActionPerformed

    private void jSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarActionPerformed
        SimulacaoMecDao simulacaoMecDao = new SimulacaoMecDao();
        SimulacaoAvaliacaoMec simulacaoAvaliacaoMec = new SimulacaoAvaliacaoMec();

        int idSimulacao=simulacaoMecDao.getIdSimulacao(jIdentificador.getText());

        simulacaoAvaliacaoMec.setNotaFinal(jNotaFinal.getText());
        simulacaoAvaliacaoMec.setSugestaoMelhoriaDimensao1(jSugestaoMelhoria1.getText());
        simulacaoAvaliacaoMec.setSugestaoMelhoriaDimensao2(jSugestaoMelhoria2.getText());

        if(simulacaoMecDao.InsereDadosSimulacao(idSimulacao, simulacaoAvaliacaoMec)){
            JOptionPane.showMessageDialog(this, "Dados salvos com sucesso.");
        }else{
            JOptionPane.showMessageDialog(this, "Erro ao salvar os dados.");
        }    
    }//GEN-LAST:event_jSalvarActionPerformed
    public void listaCursos(){
        CursoDao cursoDao = new CursoDao();
        List<Curso> listaCurso = cursoDao.getCursos();
        
        jListaCursos.removeAllItems();
        jListaCursos.addItem("Selecione");
        for (int i = 0; i < listaCurso.size(); i++) {
            jListaCursos.addItem(listaCurso.get(i).getDenominacao());
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
            java.util.logging.Logger.getLogger(SimuladorAvaliacaoMEC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuladorAvaliacaoMEC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuladorAvaliacaoMEC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuladorAvaliacaoMEC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SimuladorAvaliacaoMEC dialog = new SimuladorAvaliacaoMEC(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jCalcularNotas;
    private javax.swing.JTextField jIdentificador;
    private javax.swing.JButton jIniciarSimulacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jListaCursos;
    private javax.swing.JComboBox<String> jListaDimensoes;
    private javax.swing.JLabel jNotaDimensao;
    private javax.swing.JLabel jNotaFinal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jProporMelhoria;
    private javax.swing.JButton jSalvar;
    private javax.swing.JButton jSalvarDimensao1;
    private javax.swing.JButton jSalvarDimensao2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jSugestaoMelhoria1;
    private javax.swing.JTextArea jSugestaoMelhoria2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTabelaAnaliseAdm;
    private javax.swing.JTable jTabelaCondicoesTrabalho;
    private javax.swing.JTable jTabelaPPC;
    private javax.swing.JTable jTabelaPPCFormacao;
    private javax.swing.JTable jTabelaPerfilDocentes;
    // End of variables declaration//GEN-END:variables
}

package dao;

import java.sql.Connection;
import entity.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProfessorDao {
     private  Connection conexaoDb;
     
    public boolean Cria(Professor professor){
        conexaoDb = new ConexaoDb().getConexao();
        String sql="INSERT INTO PROFESSOR(nome,cpf,maior_titulacao,area_formacao,curriculo_lattes, data_atualizacao,coordenador) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());
            stmt.setString(3, professor.getMaiorTitulacao());
            stmt.setString(4, professor.getAreaFormacao());
            stmt.setString(5, professor.getCurriculoLattes());
            stmt.setString(6, professor.getDataAtualizacao());
            stmt.setBoolean(7, professor.isCoordenador());

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean Altera(Professor professor, Integer id){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "UPDATE PROFESSOR SET nome=?, cpf=?, maior_titulacao=?, area_formacao=?, curriculo_lattes=?,"
                + "data_atualizacao=?, coordenador=? WHERE id_professor=? ";
        
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getCpf());
            stmt.setString(3, professor.getMaiorTitulacao());
            stmt.setString(4, professor.getAreaFormacao());
            stmt.setString(5, professor.getCurriculoLattes());
            stmt.setString(6, professor.getDataAtualizacao());
            stmt.setBoolean(7, professor.isCoordenador());

            stmt.setInt(8, id);
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public boolean Remove(Integer id){
        conexaoDb = new ConexaoDb().getConexao();
        String sql = "DELETE FROM PROFESSOR WHERE id_professor=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean InsereDadosGerais(Professor professor, Integer idProfessor){
         conexaoDb = new ConexaoDb().getConexao();
        String sql="UPDATE PROFESSOR SET matricula=?,data_admissao=?,horas_nde=?,orientacao_tcc=?,coordenacao_curso=?,"
                + "coordenacao_outros_cursos=?,pesquisa=?,atividade_extra_classe_curso=?, atividade_extra_classe_outros_cursos=?,"
                + "qtde_horas_curso=?,qtde_horas_outro_curso=? WHERE id_professor=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, professor.getMatricula());
            stmt.setString(2, professor.getDataAdmissao());
            stmt.setInt(3, professor.getHorasNde());
            stmt.setInt(4, professor.getOrientacaoTcc());
            stmt.setInt(5, professor.getCoordenacaoCurso());
            stmt.setInt(6, professor.getCoordenacaoOutrosCursos());
            stmt.setInt(7, professor.getPesquisa());
            stmt.setInt(8, professor.getAtividadeExtraClasseCurso());
            stmt.setInt(9, professor.getAtividadeExtraClasseOutrosCursos());
            stmt.setInt(10, professor.getQtdeHorasCurso());
            stmt.setInt(11, professor.getQtdeHorasOutroCurso());
            
            stmt.setInt(12, idProfessor);

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
    public boolean InsereAtuacaoProfissional(Professor professor, Integer idProfessor){
         conexaoDb = new ConexaoDb().getConexao();
        String sql="UPDATE PROFESSOR SET membro_nde=?,membro_colegiado=?, docente_capacitacao=?,tempo_vinculo_data=?,"
                + "tempo_vinculo_total=?, tempo_magisterio_data=?, tempo_magisterio_total=?, experiencia_distancia_data=?,"
                + "experiencia_distancia_total=?, tempo_experiencia_data=?, tempo_experiencia_total=?, quantidade_comprovantes=? WHERE id_professor=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setBoolean(1, professor.isMembroNde());
            stmt.setBoolean(2, professor.isMembroColegiado());
            stmt.setBoolean(3, professor.isDocenteCapacitacao());
            stmt.setString(4, professor.getTempoVinculoData());
            stmt.setString(5, professor.getTempoVinculoTotal());
            stmt.setString(6, professor.getTempoMagisterioData());
            stmt.setString(7, professor.getTempoMagisterioTotal());
            stmt.setString(8, professor.getExperienciaDistanciaData());
            stmt.setString(9, professor.getExperienciaDistanciaTotal());
            stmt.setString(10, professor.getTempoExperienciaData());
            stmt.setString(11, professor.getTempoExperienciaTotal());
            stmt.setInt(12, professor.getQuantidadeComprovantes());
            
            stmt.setInt(13, idProfessor);

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     } 
    public boolean InserePublicacoes(Professor professor, Integer idProfessor){
         conexaoDb = new ConexaoDb().getConexao();
        String sql="UPDATE PROFESSOR SET artigos_publicados_area=?, artigos_publicados_outras_areas=?, livros_capitulos_area=?,"
                + "livros_capitulos_outras_areas=?, trabalhos_publicados_completos=?, trabalhos_publicados_resumos=?,"
                + "propriedade_intelectual_depositada=?, propriedade_intelectual_registrada=?, outras_publicacoes_traducoes=?,"
                + "outras_publicacoes_projetos=?, outras_publicacoes_producao=? WHERE id_professor=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setInt(1, professor.getArtigosPublicadosArea());
            stmt.setInt(2, professor.getArtigosPublicadosOutrasAreas());
            stmt.setInt(3, professor.getLivrosCapitulosArea());
            stmt.setInt(4, professor.getLivrosCapitulosOutrasAreas());
            stmt.setInt(5, professor.getTrabalhosPublicadosCompletos());
            stmt.setInt(6, professor.getTrabalhosPublicadosResumos());
            stmt.setInt(7, professor.getPropriedadeIntelectualDepositada());
            stmt.setInt(8, professor.getPropriedadeIntelectualRegistrada());
            stmt.setInt(9, professor.getOutrasPublicacoesTraducoes());
            stmt.setInt(10, professor.getOutrasPublicacoesProjetos());
            stmt.setInt(11, professor.getOutrasPublicacoesProducao());
            
            stmt.setInt(12, idProfessor);

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
    public Integer getIdProfessor(String cpf){
        conexaoDb = new ConexaoDb().getConexao();
        
        String sql="SELECT id_professor FROM PROFESSOR WHERE cpf=?";
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement(sql);
            stmt.setString(1, cpf);

           ResultSet rs = stmt.executeQuery();
           int id = rs.getInt("id_professor");
            return id;
            

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    public List<Professor> getProfessores(){
        conexaoDb = new ConexaoDb().getConexao();
        List<Professor> listaProfessores = new ArrayList<Professor>();
            String sql ="SELECT nome,cpf,maior_titulacao FROM PROFESSOR";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            Professor professor = new Professor();
            
            professor.setNome(rs.getString("nome"));
            professor.setCpf(rs.getString("cpf"));
            professor.setMaiorTitulacao(rs.getString("maior_titulacao"));
            
            listaProfessores.add(professor);
            
            }
            return listaProfessores;
        
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
 public List<Professor> getCoordenadores(){
        conexaoDb = new ConexaoDb().getConexao();
        List<Professor> listaCoordenadores = new ArrayList<Professor>();
            String sql ="SELECT nome,cpf,area_formacao FROM PROFESSOR WHERE coordenador=1";
            
            PreparedStatement stmt;
        try {
            stmt = conexaoDb.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
            Professor professor = new Professor();
            
            professor.setNome(rs.getString("nome"));
            professor.setCpf(rs.getString("cpf"));
            professor.setAreaFormacao(rs.getString("area_formacao"));
            
            listaCoordenadores.add(professor);
            
            }
            return listaCoordenadores;
        
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }    
 public Professor getCoordenador(String nome){
        conexaoDb = new ConexaoDb().getConexao();
        Professor professor = new Professor();

        String sql= "SELECT cpf, maior_titulacao, area_formacao  FROM PROFESSOR WHERE nome=?";
            try {
                PreparedStatement stmt = conexaoDb.prepareStatement(sql);
                stmt.setString(1, nome);

                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    professor.setCpf(rs.getString("cpf"));
                    professor.setMaiorTitulacao("maior_titulacao");
                    professor.setAreaFormacao(rs.getString("area_formacao"));
                }


                rs.close();

                return professor;
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    public Professor getProfessor(String cpf){
        conexaoDb = new ConexaoDb().getConexao();
        Professor professor = new Professor();

        String sql= "SELECT * FROM PROFESSOR WHERE cpf=?";
            try {
                PreparedStatement stmt = conexaoDb.prepareStatement(sql);
                stmt.setString(1, cpf);

                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    professor.setNome(rs.getString("nome"));
                    professor.setCpf(cpf);
                    professor.setMaiorTitulacao("maior_titulacao");
                    professor.setAreaFormacao(rs.getString("area_formacao"));
                    professor.setCurriculoLattes(rs.getString("curriculo_lattes"));
                    professor.setDataAtualizacao(rs.getString("data_atualizacao"));
                    professor.setCoordenador(rs.getBoolean("coordenador"));
                    professor.setMatricula(rs.getString("matricula"));
                    professor.setDataAdmissao(rs.getString("data_admissao"));
                    professor.setHorasNde(rs.getInt("horas_nde"));
                    professor.setOrientacaoTcc(rs.getInt("orientacao_tcc"));
                    professor.setCoordenacaoCurso(rs.getInt("coordenacao_curso"));
                    professor.setCoordenacaoOutrosCursos(rs.getInt("coordenacao_outros_cursos"));
                    professor.setPesquisa(rs.getInt("pesquisa"));
                    professor.setAtividadeExtraClasseCurso(rs.getInt("atividade_extra_classe_curso"));
                    professor.setAtividadeExtraClasseOutrosCursos(rs.getInt("atividade_extra_classe_outros_cursos"));
                    professor.setQtdeHorasCurso(rs.getInt("qtde_horas_curso"));
                    professor.setQtdeHorasOutroCurso(rs.getInt("qtde_horas_outro_curso"));
                    professor.setMembroNde(rs.getBoolean("membro_nde"));
                    professor.setMembroColegiado(rs.getBoolean("membro_colegiado"));
                    professor.setDocenteCapacitacao(rs.getBoolean("docente_capacitacao"));
                    professor.setTempoVinculoData(rs.getString("tempo_vinculo_data"));
                    professor.setTempoVinculoTotal(rs.getString("tempo_vinculo_total"));
                    professor.setTempoMagisterioData(rs.getString("tempo_magisterio_data"));
                    professor.setTempoMagisterioTotal(rs.getString("tempo_magisterio_total"));
                    professor.setExperienciaDistanciaData(rs.getString("experiencia_distancia_data"));
                    professor.setExperienciaDistanciaTotal(rs.getString("experiencia_distancia_total"));
                    professor.setTempoExperienciaData(rs.getString("tempo_experiencia_data"));
                    professor.setTempoExperienciaTotal(rs.getString("tempo_experiencia_total"));
                    professor.setQuantidadeComprovantes(rs.getInt("quantidade_comprovantes"));
                    professor.setArtigosPublicadosArea(rs.getInt("artigos_publicados_area"));
                    professor.setArtigosPublicadosOutrasAreas(rs.getInt("artigos_publicados_outras_areas"));
                    professor.setLivrosCapitulosArea(rs.getInt("livros_capitulos_area"));
                    professor.setLivrosCapitulosOutrasAreas(rs.getInt("livros_capitulos_outras_areas"));
                    professor.setTrabalhosPublicadosCompletos(rs.getInt("trabalhos_publicados_completos"));
                    professor.setTrabalhosPublicadosResumos(rs.getInt("trabalhos_publicados_resumos"));
                    professor.setPropriedadeIntelectualDepositada(rs.getInt("propriedade_intelectual_depositada"));
                    professor.setPropriedadeIntelectualRegistrada(rs.getInt("propriedade_intelectual_registrada"));
                    professor.setOutrasPublicacoesTraducoes(rs.getInt("outras_publicacoes_traducoes"));
                    professor.setOutrasPublicacoesProjetos(rs.getInt("outras_publicacoes_projetos"));
                    professor.setOutrasPublicacoesProducao(rs.getInt("outras_publicacoes_producao"));
                }


                rs.close();

                return professor;
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }finally{
            try {
                conexaoDb.close();
            } catch (SQLException ex) {
                Logger.getLogger(DisciplinaDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
}



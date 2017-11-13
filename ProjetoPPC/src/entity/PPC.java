/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Gustavo
 */
public class PPC {
    private int idPpc;
    private String identificador;
    private String perfilCurso;
    private String perfilEgresso;
    private String formaAcessoCurso;
    private String representacaoPerfilFormacao;
    private String sistemaAvaliacaoProcessoEnsinoAprendizagem;
    private String sistemaAvaliacaoProjetoCurso;
    private String trabalhoConclusaoCurso;
    private String estagioCurricular;
    private String politicaAtendimentoDeficientes;
    private int fk_id_curso;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public int getIdPpc() {
        return idPpc;
    }

    public void setIdPpc(int idPpc) {
        this.idPpc = idPpc;
    }

    public String getPerfilCurso() {
        return perfilCurso;
    }

    public void setPerfilCurso(String perfilCurso) {
        this.perfilCurso = perfilCurso;
    }

    public String getPerfilEgresso() {
        return perfilEgresso;
    }

    public void setPerfilEgresso(String perfilEgresso) {
        this.perfilEgresso = perfilEgresso;
    }

    public String getFormaAcessoCurso() {
        return formaAcessoCurso;
    }

    public void setFormaAcessoCurso(String formaAcessoCurso) {
        this.formaAcessoCurso = formaAcessoCurso;
    }

    public String getRepresentacaoPerfilFormacao() {
        return representacaoPerfilFormacao;
    }

    public void setRepresentacaoPerfilFormacao(String representacaoPerfilFormacao) {
        this.representacaoPerfilFormacao = representacaoPerfilFormacao;
    }

    public String getSistemaAvaliacaoProcessoEnsinoAprendizagem() {
        return sistemaAvaliacaoProcessoEnsinoAprendizagem;
    }

    public void setSistemaAvaliacaoProcessoEnsinoAprendizagem(String sistemaAvaliacaoProcessoEnsinoAprendizagem) {
        this.sistemaAvaliacaoProcessoEnsinoAprendizagem = sistemaAvaliacaoProcessoEnsinoAprendizagem;
    }

    public String getSistemaAvaliacaoProjetoCurso() {
        return sistemaAvaliacaoProjetoCurso;
    }

    public void setSistemaAvaliacaoProjetoCurso(String sistemaAvaliacaoProjetoCurso) {
        this.sistemaAvaliacaoProjetoCurso = sistemaAvaliacaoProjetoCurso;
    }

    public String getTrabalhoConclusaoCurso() {
        return trabalhoConclusaoCurso;
    }

    public void setTrabalhoConclusaoCurso(String trabalhoConclusaoCurso) {
        this.trabalhoConclusaoCurso = trabalhoConclusaoCurso;
    }

    public String getEstagioCurricular() {
        return estagioCurricular;
    }

    public void setEstagioCurricular(String estagioCurricular) {
        this.estagioCurricular = estagioCurricular;
    }

    public String getPoliticaAtendimentoDeficientes() {
        return politicaAtendimentoDeficientes;
    }

    public void setPoliticaAtendimentoDeficientes(String politicaAtendimentoDeficientes) {
        this.politicaAtendimentoDeficientes = politicaAtendimentoDeficientes;
    }

    public int getFk_id_curso() {
        return fk_id_curso;
    }

    public void setFk_id_curso(int fk_id_curso) {
        this.fk_id_curso = fk_id_curso;
    }
    
}

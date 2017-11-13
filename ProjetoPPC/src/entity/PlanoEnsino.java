/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class PlanoEnsino {
    private int planoEnsino;
    private String ano;
    private String semestre;
    private int cargaHoraria;
    private String periodo;
    private String ementa;
    private String competencias;
    private String metodologia;
    private String avaliacao;
    private String bibliografia;
    private String identificador;
    private int fk_id_curso;
    private int fk_id_disciplina;
    private int fk_id_cronograma;

    public int getPlanoEnsino() {
        return planoEnsino;
    }

    public void setPlanoEnsino(int planoEnsino) {
        this.planoEnsino = planoEnsino;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getFk_id_curso() {
        return fk_id_curso;
    }

    public void setFk_id_curso(int fk_id_curso) {
        this.fk_id_curso = fk_id_curso;
    }

    public int getFk_id_disciplina() {
        return fk_id_disciplina;
    }

    public void setFk_id_disciplina(int fk_id_disciplina) {
        this.fk_id_disciplina = fk_id_disciplina;
    }

    public int getFk_id_cronograma() {
        return fk_id_cronograma;
    }

    public void setFk_id_cronograma(int fk_id_cronograma) {
        this.fk_id_cronograma = fk_id_cronograma;
    }
    
}

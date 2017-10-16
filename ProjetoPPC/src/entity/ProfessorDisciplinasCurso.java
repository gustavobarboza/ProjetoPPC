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
public class ProfessorDisciplinasCurso {
    private int idProfessorDisciplinasCurso;
    private String disciplina;
    private int cargaHoraria;

    public int getIdProfessorDisciplinasCurso() {
        return idProfessorDisciplinasCurso;
    }

    public void setIdProfessorDisciplinasCurso(int idProfessorDisciplinasCurso) {
        this.idProfessorDisciplinasCurso = idProfessorDisciplinasCurso;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
}

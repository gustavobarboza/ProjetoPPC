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
public class CronogramaAtividades {
    private int idCronogramaAtividades;
    private int aula;
    private String conteudo;

    public int getIdCronogramaAtividades() {
        return idCronogramaAtividades;
    }

    public void setIdCronogramaAtividades(int idCronogramaAtividades) {
        this.idCronogramaAtividades = idCronogramaAtividades;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
}

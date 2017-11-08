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
    private String aula;
    private String conteudo;
    private int fk_id_cronograma;

    public int getIdCronogramaAtividades() {
        return idCronogramaAtividades;
    }

    public void setIdCronogramaAtividades(int idCronogramaAtividades) {
        this.idCronogramaAtividades = idCronogramaAtividades;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getFk_id_cronograma() {
        return fk_id_cronograma;
    }

    public void setFk_id_cronograma(int fk_id_cronograma) {
        this.fk_id_cronograma = fk_id_cronograma;
    }
    
}

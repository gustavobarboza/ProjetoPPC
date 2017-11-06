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
public class ProfessorComprovantes {
    private int idProfessorComprovantes;
    private String comprovante;
    private String data;
    private String local;

    public int getIdProfessorComprovantes() {
        return idProfessorComprovantes;
    }

    public void setIdProfessorComprovantes(int idProfessorComprovantes) {
        this.idProfessorComprovantes = idProfessorComprovantes;
    }

    public String getComprovante() {
        return comprovante;
    }

    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
}

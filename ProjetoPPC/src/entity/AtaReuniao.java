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
public class AtaReuniao {
    private int idAtaReuniao;
    private Date data;
    private String local;
    private String deliberacoes;

    public int getIdAtaReuniao() {
        return idAtaReuniao;
    }

    public void setIdAtaReuniao(int idAtaReuniao) {
        this.idAtaReuniao = idAtaReuniao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDeliberacoes() {
        return deliberacoes;
    }

    public void setDeliberacoes(String deliberacoes) {
        this.deliberacoes = deliberacoes;
    }
    
    
}

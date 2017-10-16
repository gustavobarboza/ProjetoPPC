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
public class SimulacaoAvaliacaoMec {
    private int idSimulacaoAvaliacaoMec;
    private int notaFinal;
    private int identificadorSimulacao;
    private String sugestaoMelhoriaDimensao1;
    private String sugestaoMelhoriaDimensao2;

    public int getIdSimulacaoAvaliacaoMec() {
        return idSimulacaoAvaliacaoMec;
    }

    public void setIdSimulacaoAvaliacaoMec(int idSimulacaoAvaliacaoMec) {
        this.idSimulacaoAvaliacaoMec = idSimulacaoAvaliacaoMec;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    public int getIdentificadorSimulacao() {
        return identificadorSimulacao;
    }

    public void setIdentificadorSimulacao(int identificadorSimulacao) {
        this.identificadorSimulacao = identificadorSimulacao;
    }

    public String getSugestaoMelhoriaDimensao1() {
        return sugestaoMelhoriaDimensao1;
    }

    public void setSugestaoMelhoriaDimensao1(String sugestaoMelhoriaDimensao1) {
        this.sugestaoMelhoriaDimensao1 = sugestaoMelhoriaDimensao1;
    }

    public String getSugestaoMelhoriaDimensao2() {
        return sugestaoMelhoriaDimensao2;
    }

    public void setSugestaoMelhoriaDimensao2(String sugestaoMelhoriaDimensao2) {
        this.sugestaoMelhoriaDimensao2 = sugestaoMelhoriaDimensao2;
    }
    
}

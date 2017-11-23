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
    public int fk_id_curso;
    private int idSimulacaoAvaliacaoMec;
    private String notaFinal;
    private String identificadorSimulacao;
    private String sugestaoMelhoriaDimensao1;
    private String sugestaoMelhoriaDimensao2;

    public int getFk_id_curso() {
        return fk_id_curso;
    }

    public void setFk_id_curso(int fk_id_curso) {
        this.fk_id_curso = fk_id_curso;
    }
    
    
    public int getIdSimulacaoAvaliacaoMec() {
        return idSimulacaoAvaliacaoMec;
    }

    public void setIdSimulacaoAvaliacaoMec(int idSimulacaoAvaliacaoMec) {
        this.idSimulacaoAvaliacaoMec = idSimulacaoAvaliacaoMec;
    }

    public String getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(String notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getIdentificadorSimulacao() {
        return identificadorSimulacao;
    }

    public void setIdentificadorSimulacao(String identificadorSimulacao) {
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

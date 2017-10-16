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
public class Professor {
    private int idProfessor;
    private String nome;
    private String cpf;
    private String maiorTitulacao;
    private String areaFormacao;
    private String curriculoLattes;
    private String dataAtualizacao;
    private boolean coordenador;
    private String matricula;
    private Date dataAdmissao;
    private int horasNde;
    private int orientacaoTcc;
    private int coordenacaoCurso;
    private int coordenacaoOutrosCursos;
    private int pesquisa;
    private int atividadeExtraClasseCurso;
    private int atividadeExtraClasseOutrosCursos;
    private int qtdeHorasCurso;
    private int qtdeHorasOutroCurso;
    private int membroNde;
    private int membroColegiado;
    private int docenteCapacitacao;
    private String tempoVinculoData;
    private String tempoVinculoTotal;
    private String tempoMagisterioData;
    private String tempoMagisterioTotal;
    private String experienciaDistanciaData;
    private String experienciaDistanciaTotal;
    private String tempoExperienciaData;
    private String tempoExperienciaTotal;
    private int artigosPublicadosArea;
    private int atigosPublicadosOutrasAreas;
    private int livrosCapitulosArea;
    private int livrosCapitulosOutrasAreas;
    private int trabalhosPublicadosCompletos;
    private int trabalhosPublicadosResumos;
    private int propriedadeIntelectualDepositada;
    private int propriedadeIntelectualRegistrada;
    private int outrasPublicacoesTraducoes;
    private int outrasPublicacoesProjetos;
    private int outrasPublicacoesProducao;

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMaiorTitulacao() {
        return maiorTitulacao;
    }

    public void setMaiorTitulacao(String maiorTitulacao) {
        this.maiorTitulacao = maiorTitulacao;
    }

    public String getAreaFormacao() {
        return areaFormacao;
    }

    public void setAreaFormacao(String areaFormacao) {
        this.areaFormacao = areaFormacao;
    }

    public String getCurriculoLattes() {
        return curriculoLattes;
    }

    public void setCurriculoLattes(String curriculoLattes) {
        this.curriculoLattes = curriculoLattes;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public boolean isCoordenador() {
        return coordenador;
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public int getHorasNde() {
        return horasNde;
    }

    public void setHorasNde(int horasNde) {
        this.horasNde = horasNde;
    }

    public int getOrientacaoTcc() {
        return orientacaoTcc;
    }

    public void setOrientacaoTcc(int orientacaoTcc) {
        this.orientacaoTcc = orientacaoTcc;
    }

    public int getCoordenacaoCurso() {
        return coordenacaoCurso;
    }

    public void setCoordenacaoCurso(int coordenacaoCurso) {
        this.coordenacaoCurso = coordenacaoCurso;
    }

    public int getCoordenacaoOutrosCursos() {
        return coordenacaoOutrosCursos;
    }

    public void setCoordenacaoOutrosCursos(int coordenacaoOutrosCursos) {
        this.coordenacaoOutrosCursos = coordenacaoOutrosCursos;
    }

    public int getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(int pesquisa) {
        this.pesquisa = pesquisa;
    }

    public int getAtividadeExtraClasseCurso() {
        return atividadeExtraClasseCurso;
    }

    public void setAtividadeExtraClasseCurso(int atividadeExtraClasseCurso) {
        this.atividadeExtraClasseCurso = atividadeExtraClasseCurso;
    }

    public int getAtividadeExtraClasseOutrosCursos() {
        return atividadeExtraClasseOutrosCursos;
    }

    public void setAtividadeExtraClasseOutrosCursos(int atividadeExtraClasseOutrosCursos) {
        this.atividadeExtraClasseOutrosCursos = atividadeExtraClasseOutrosCursos;
    }

    public int getQtdeHorasCurso() {
        return qtdeHorasCurso;
    }

    public void setQtdeHorasCurso(int qtdeHorasCurso) {
        this.qtdeHorasCurso = qtdeHorasCurso;
    }

    public int getQtdeHorasOutroCurso() {
        return qtdeHorasOutroCurso;
    }

    public void setQtdeHorasOutroCurso(int qtdeHorasOutroCurso) {
        this.qtdeHorasOutroCurso = qtdeHorasOutroCurso;
    }

    public int getMembroNde() {
        return membroNde;
    }

    public void setMembroNde(int membroNde) {
        this.membroNde = membroNde;
    }

    public int getMembroColegiado() {
        return membroColegiado;
    }

    public void setMembroColegiado(int membroColegiado) {
        this.membroColegiado = membroColegiado;
    }

    public int getDocenteCapacitacao() {
        return docenteCapacitacao;
    }

    public void setDocenteCapacitacao(int docenteCapacitacao) {
        this.docenteCapacitacao = docenteCapacitacao;
    }

    public String getTempoVinculoData() {
        return tempoVinculoData;
    }

    public void setTempoVinculoData(String tempoVinculoData) {
        this.tempoVinculoData = tempoVinculoData;
    }

    public String getTempoVinculoTotal() {
        return tempoVinculoTotal;
    }

    public void setTempoVinculoTotal(String tempoVinculoTotal) {
        this.tempoVinculoTotal = tempoVinculoTotal;
    }

    public String getTempoMagisterioData() {
        return tempoMagisterioData;
    }

    public void setTempoMagisterioData(String tempoMagisterioData) {
        this.tempoMagisterioData = tempoMagisterioData;
    }

    public String getTempoMagisterioTotal() {
        return tempoMagisterioTotal;
    }

    public void setTempoMagisterioTotal(String tempoMagisterioTotal) {
        this.tempoMagisterioTotal = tempoMagisterioTotal;
    }

    public String getExperienciaDistanciaData() {
        return experienciaDistanciaData;
    }

    public void setExperienciaDistanciaData(String experienciaDistanciaData) {
        this.experienciaDistanciaData = experienciaDistanciaData;
    }

    public String getExperienciaDistanciaTotal() {
        return experienciaDistanciaTotal;
    }

    public void setExperienciaDistanciaTotal(String experienciaDistanciaTotal) {
        this.experienciaDistanciaTotal = experienciaDistanciaTotal;
    }

    public String getTempoExperienciaData() {
        return tempoExperienciaData;
    }

    public void setTempoExperienciaData(String tempoExperienciaData) {
        this.tempoExperienciaData = tempoExperienciaData;
    }

    public String getTempoExperienciaTotal() {
        return tempoExperienciaTotal;
    }

    public void setTempoExperienciaTotal(String tempoExperienciaTotal) {
        this.tempoExperienciaTotal = tempoExperienciaTotal;
    }

    public int getArtigosPublicadosArea() {
        return artigosPublicadosArea;
    }

    public void setArtigosPublicadosArea(int artigosPublicadosArea) {
        this.artigosPublicadosArea = artigosPublicadosArea;
    }

    public int getAtigosPublicadosOutrasAreas() {
        return atigosPublicadosOutrasAreas;
    }

    public void setAtigosPublicadosOutrasAreas(int atigosPublicadosOutrasAreas) {
        this.atigosPublicadosOutrasAreas = atigosPublicadosOutrasAreas;
    }

    public int getLivrosCapitulosArea() {
        return livrosCapitulosArea;
    }

    public void setLivrosCapitulosArea(int livrosCapitulosArea) {
        this.livrosCapitulosArea = livrosCapitulosArea;
    }

    public int getLivrosCapitulosOutrasAreas() {
        return livrosCapitulosOutrasAreas;
    }

    public void setLivrosCapitulosOutrasAreas(int livrosCapitulosOutrasAreas) {
        this.livrosCapitulosOutrasAreas = livrosCapitulosOutrasAreas;
    }

    public int getTrabalhosPublicadosCompletos() {
        return trabalhosPublicadosCompletos;
    }

    public void setTrabalhosPublicadosCompletos(int trabalhosPublicadosCompletos) {
        this.trabalhosPublicadosCompletos = trabalhosPublicadosCompletos;
    }

    public int getTrabalhosPublicadosResumos() {
        return trabalhosPublicadosResumos;
    }

    public void setTrabalhosPublicadosResumos(int trabalhosPublicadosResumos) {
        this.trabalhosPublicadosResumos = trabalhosPublicadosResumos;
    }

    public int getPropriedadeIntelectualDepositada() {
        return propriedadeIntelectualDepositada;
    }

    public void setPropriedadeIntelectualDepositada(int propriedadeIntelectualDepositada) {
        this.propriedadeIntelectualDepositada = propriedadeIntelectualDepositada;
    }

    public int getPropriedadeIntelectualRegistrada() {
        return propriedadeIntelectualRegistrada;
    }

    public void setPropriedadeIntelectualRegistrada(int propriedadeIntelectualRegistrada) {
        this.propriedadeIntelectualRegistrada = propriedadeIntelectualRegistrada;
    }

    public int getOutrasPublicacoesTraducoes() {
        return outrasPublicacoesTraducoes;
    }

    public void setOutrasPublicacoesTraducoes(int outrasPublicacoesTraducoes) {
        this.outrasPublicacoesTraducoes = outrasPublicacoesTraducoes;
    }

    public int getOutrasPublicacoesProjetos() {
        return outrasPublicacoesProjetos;
    }

    public void setOutrasPublicacoesProjetos(int outrasPublicacoesProjetos) {
        this.outrasPublicacoesProjetos = outrasPublicacoesProjetos;
    }

    public int getOutrasPublicacoesProducao() {
        return outrasPublicacoesProducao;
    }

    public void setOutrasPublicacoesProducao(int outrasPublicacoesProducao) {
        this.outrasPublicacoesProducao = outrasPublicacoesProducao;
    }
    
    
}

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
public class Bibliografia {
    private int idBibliografia;
    private String  titulo;
    private String autor;
    private String isbn;
    private String ano;
    private String editora;
    private int fk_id_curso;
    private int fk_id_disciplina;

    public int getIdBibliografia() {
        return idBibliografia;
    }

    public void setIdBibliografia(int idBibliografia) {
        this.idBibliografia = idBibliografia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
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
    
}

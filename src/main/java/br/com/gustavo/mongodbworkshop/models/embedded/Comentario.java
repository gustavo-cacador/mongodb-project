package br.com.gustavo.mongodbworkshop.models.embedded;

import java.time.Instant;

public class Comentario {

    private String texto;
    private Instant momento;

    private Autor autor;

    public Comentario() {}

    public Comentario(String texto, Instant momento, Autor autor) {
        this.texto = texto;
        this.momento = momento;
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}

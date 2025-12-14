package br.com.gustavo.mongodbworkshop.models.entities;

import br.com.gustavo.mongodbworkshop.models.embedded.Autor;
import br.com.gustavo.mongodbworkshop.models.embedded.Comentario;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "postagens")
public class Postagem {

    @Id
    private String id;
    private Instant momento;
    private String titulo;
    private String corpo;

    private Autor autor;

    private List<Comentario> comentarios = new ArrayList<>();

    public Postagem() {}

    public Postagem(String id, Instant momento, String titulo, String corpo, Autor autor) {
        this.id = id;
        this.momento = momento;
        this.titulo = titulo;
        this.corpo = corpo;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}

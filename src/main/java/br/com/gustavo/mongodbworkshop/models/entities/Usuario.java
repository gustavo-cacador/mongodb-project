package br.com.gustavo.mongodbworkshop.models.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "usuarios")
public class Usuario {

    //mongodb usa string como id (usa alfanumerico)
    @Id
    private String id;
    private String nome;
    private String email;

    @DBRef(lazy = true)
    public List<Postagem> postagens = new ArrayList<>();

    private Usuario() {}

    public Usuario(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }
}

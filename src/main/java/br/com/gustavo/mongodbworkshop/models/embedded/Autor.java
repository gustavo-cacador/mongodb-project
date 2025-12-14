package br.com.gustavo.mongodbworkshop.models.embedded;

import br.com.gustavo.mongodbworkshop.models.entities.Usuario;

public class Autor {

    private String id;
    private String nome;

    public Autor() {}

    public Autor(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Autor(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
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
}

package br.com.gustavo.mongodbworkshop.models.dto;

import br.com.gustavo.mongodbworkshop.models.entities.Usuario;

public class UsuarioDTO {

    private String id;
    private String nome;
    private String email;

    private UsuarioDTO() {}

    public UsuarioDTO(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public UsuarioDTO(Usuario entity) {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
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
}

package br.com.gustavo.mongodbworkshop.dao;

import br.com.gustavo.mongodbworkshop.models.entities.Postagem;
import br.com.gustavo.mongodbworkshop.models.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostagemRepository extends MongoRepository<Postagem, String> {

    List<Postagem> findByTituloContainingIgnoreCase(String titulo);
}

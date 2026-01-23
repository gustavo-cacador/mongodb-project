package br.com.gustavo.mongodbworkshop.dao;

import br.com.gustavo.mongodbworkshop.models.entities.Postagem;
import br.com.gustavo.mongodbworkshop.models.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostagemRepository extends MongoRepository<Postagem, String> {

    @Query("{ 'titulo': { $regex: ?0, $options:  'i' } }")
    List<Postagem> searchTitle(String titulo);

    List<Postagem> findByTituloContainingIgnoreCase(String titulo);
}

package br.com.gustavo.mongodbworkshop.dao;

import br.com.gustavo.mongodbworkshop.models.entities.Postagem;
import br.com.gustavo.mongodbworkshop.models.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostagemRepository extends MongoRepository<Postagem, String> {
}

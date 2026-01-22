package br.com.gustavo.mongodbworkshop.services;

import br.com.gustavo.mongodbworkshop.dao.PostagemRepository;
import br.com.gustavo.mongodbworkshop.dao.UsuarioRepository;
import br.com.gustavo.mongodbworkshop.models.dto.PostagemDTO;
import br.com.gustavo.mongodbworkshop.models.dto.UsuarioDTO;
import br.com.gustavo.mongodbworkshop.models.entities.Postagem;
import br.com.gustavo.mongodbworkshop.models.entities.Usuario;
import br.com.gustavo.mongodbworkshop.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostagemRepository postagemRepository;

    public PostService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public PostagemDTO buscarPorId(String id) {
        Postagem postagem = getUsuarioById(id);
        return new PostagemDTO(postagem);
    }

    private Postagem getUsuarioById(String id) {
        Optional<Postagem> result = postagemRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Post não encontrado."));
    }
}

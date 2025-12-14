package br.com.gustavo.mongodbworkshop.config;

import br.com.gustavo.mongodbworkshop.dao.PostagemRepository;
import br.com.gustavo.mongodbworkshop.dao.UsuarioRepository;
import br.com.gustavo.mongodbworkshop.models.entities.Usuario;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    private final UsuarioRepository usuarioRepository;
    private final PostagemRepository postagemRepository;

    public TestConfig(UsuarioRepository usuarioRepository, PostagemRepository postagemRepository) {
        this.usuarioRepository = usuarioRepository;
        this.postagemRepository = postagemRepository;
    }

    @PostConstruct
    public void init() {

        usuarioRepository.deleteAll();
        postagemRepository.deleteAll();
        
        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario bob = new Usuario(null, "Bob Brown", "bob@gmail.com");
        Usuario joao = new Usuario(null, "João Brown", "joao@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(maria, bob, joao));
    }
}

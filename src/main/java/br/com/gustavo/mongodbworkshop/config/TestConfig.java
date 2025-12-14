package br.com.gustavo.mongodbworkshop.config;

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

    public TestConfig(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostConstruct
    public void init() {
        usuarioRepository.deleteAll();
        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario bob = new Usuario(null, "Bob Brown", "bob@gmail.com");
        Usuario joao = new Usuario(null, "João Brown", "joao@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(maria, bob, joao));
    }
}

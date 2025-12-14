package br.com.gustavo.mongodbworkshop.config;

import br.com.gustavo.mongodbworkshop.dao.PostagemRepository;
import br.com.gustavo.mongodbworkshop.dao.UsuarioRepository;
import br.com.gustavo.mongodbworkshop.models.embedded.Autor;
import br.com.gustavo.mongodbworkshop.models.embedded.Comentario;
import br.com.gustavo.mongodbworkshop.models.entities.Postagem;
import br.com.gustavo.mongodbworkshop.models.entities.Usuario;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
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
        Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));

        Postagem post1 = new Postagem(null, Instant.parse("2021-02-13T11:15:01Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new Autor(maria));
        Postagem post2 = new Postagem(null, Instant.parse("2021-02-14T10:05:49Z"), "Bom dia", "Acordei feliz hoje!", new Autor(maria));

        Comentario c1 = new Comentario("Boa viagem mano!", Instant.parse("2021-02-13T14:30:01Z"), new Autor(alex));
        Comentario c2 = new Comentario("Aproveite", Instant.parse("2021-02-13T15:38:05Z"), new Autor(bob));
        Comentario c3 = new Comentario("Tenha um ótimo dia!", Instant.parse("2021-02-14T12:34:26Z"), new Autor(alex));

        post1.getComentarios().addAll(Arrays.asList(c1, c2));
        post2.getComentarios().addAll(Arrays.asList(c3));

        postagemRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPostagens().addAll(Arrays.asList(post1, post2));
        usuarioRepository.save(maria);
    }
}

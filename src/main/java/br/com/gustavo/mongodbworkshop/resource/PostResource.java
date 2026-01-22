package br.com.gustavo.mongodbworkshop.resource;

import br.com.gustavo.mongodbworkshop.models.dto.PostagemDTO;
import br.com.gustavo.mongodbworkshop.models.dto.UsuarioDTO;
import br.com.gustavo.mongodbworkshop.services.PostService;
import br.com.gustavo.mongodbworkshop.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("posts")
public class PostResource {

    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostagemDTO> buscarPorId(@PathVariable String id) {
        PostagemDTO postagemDTO = postService.buscarPorId(id);
        return ResponseEntity.ok().body(postagemDTO);
    }
}

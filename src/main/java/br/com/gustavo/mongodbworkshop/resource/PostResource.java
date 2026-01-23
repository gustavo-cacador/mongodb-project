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

    @GetMapping("/buscartitulo")
    public ResponseEntity<List<PostagemDTO>> buscarPorTitulo(@RequestParam(value = "titulo", defaultValue = "") String titulo) {
        List<PostagemDTO> posts = postService.buscarPorTitulo(titulo);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/buscartudo")
    public ResponseEntity<List<PostagemDTO>> buscarPorTudo(
            @RequestParam(value = "titulo", defaultValue = "") String titulo,
            @RequestParam(value = "start", defaultValue = "") String start,
            @RequestParam(value = "end", defaultValue = "") String end
            ) {
        List<PostagemDTO> posts = postService.buscarPorTudo(titulo, start, end);
        return ResponseEntity.ok().body(posts);
    }
}

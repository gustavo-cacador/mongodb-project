package br.com.gustavo.mongodbworkshop.resource;

import br.com.gustavo.mongodbworkshop.models.dto.UsuarioDTO;
import br.com.gustavo.mongodbworkshop.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
        List<UsuarioDTO> listaUsuario = usuarioService.buscarTodos();
        return ResponseEntity.ok().body(listaUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable String id) {
        UsuarioDTO usuarioDTO = usuarioService.buscarPorId(id);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO = usuarioService.inserir(usuarioDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(usuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable String id, @RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO = usuarioService.atualizar(id, usuarioDTO);
        return ResponseEntity.ok().body(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> deletar(@PathVariable String id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

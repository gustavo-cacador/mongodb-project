package br.com.gustavo.mongodbworkshop.services;

import br.com.gustavo.mongodbworkshop.dao.UsuarioRepository;
import br.com.gustavo.mongodbworkshop.models.dto.UsuarioDTO;
import br.com.gustavo.mongodbworkshop.models.entities.Usuario;
import br.com.gustavo.mongodbworkshop.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> buscarTodos() {
        List<Usuario> listaUsuario = usuarioRepository.findAll();
        return listaUsuario.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO findById(String id) {
        Optional<Usuario> result = usuarioRepository.findById(id);
        Usuario usuario = result.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        return new UsuarioDTO(usuario);
    }

    public UsuarioDTO inserir(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        copyDTOToEntity(usuarioDTO, usuario);
        usuario = usuarioRepository.insert(usuario);
        return new UsuarioDTO(usuario);
    }

    private void copyDTOToEntity(UsuarioDTO usuarioDTO, Usuario usuario) {
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
    }
}

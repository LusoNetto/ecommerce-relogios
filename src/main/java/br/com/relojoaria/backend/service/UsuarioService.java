package br.com.relojoaria.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relojoaria.backend.entity.Usuario;
import br.com.relojoaria.backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioPorId(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
}

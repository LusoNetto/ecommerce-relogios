package br.com.relojoaria.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.relojoaria.backend.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	// Métodos personalizados podem ser adicionados aqui, se necessário
}

package br.com.relojoaria.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.relojoaria.backend.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}

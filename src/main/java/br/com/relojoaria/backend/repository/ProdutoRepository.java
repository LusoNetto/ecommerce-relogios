package br.com.relojoaria.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.relojoaria.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}


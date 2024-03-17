package br.com.relojoaria.backend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.relojoaria.backend.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	Produto save(Produto cliente);
	
	Optional<Produto> findById(long id);
}


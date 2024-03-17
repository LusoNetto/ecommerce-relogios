package br.com.relojoaria.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.relojoaria.backend.entity.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
	// Métodos personalizados podem ser adicionados aqui, se necessário
}

package br.com.relojoaria.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.relojoaria.backend.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	// Métodos personalizados podem ser adicionados aqui, se necessário
}

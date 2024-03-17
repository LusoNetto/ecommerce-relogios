package br.com.relojoaria.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relojoaria.backend.entity.Pedido;
import br.com.relojoaria.backend.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}

	public Pedido buscarPedidoPorId(Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	public Pedido salvarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public void deletarPedido(Long id) {
		pedidoRepository.deleteById(id);
	}
}

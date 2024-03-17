package br.com.relojoaria.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relojoaria.backend.entity.ItemPedido;
import br.com.relojoaria.backend.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public List<ItemPedido> listarItensPedido() {
		return itemPedidoRepository.findAll();
	}

	public ItemPedido buscarItemPedidoPorId(Long id) {
		return itemPedidoRepository.findById(id).orElse(null);
	}

	public ItemPedido salvarItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}

	public void deletarItemPedido(Long id) {
		itemPedidoRepository.deleteById(id);
	}
}

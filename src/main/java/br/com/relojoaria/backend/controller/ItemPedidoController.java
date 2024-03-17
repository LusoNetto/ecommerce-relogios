package br.com.relojoaria.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.relojoaria.backend.entity.ItemPedido;
import br.com.relojoaria.backend.service.ItemPedidoService;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {
	@Autowired
	private ItemPedidoService itemPedidoService;

	@GetMapping
	public ResponseEntity<List<ItemPedido>> listarItensPedido() {
		List<ItemPedido> itensPedido = itemPedidoService.listarItensPedido();
		return ResponseEntity.ok(itensPedido);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> buscarItemPedidoPorId(@PathVariable Long id) {
		ItemPedido itemPedido = itemPedidoService.buscarItemPedidoPorId(id);
		if (itemPedido != null) {
			return ResponseEntity.ok(itemPedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<ItemPedido> salvarItemPedido(@RequestBody ItemPedido itemPedido) {
		ItemPedido novoItemPedido = itemPedidoService.salvarItemPedido(itemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoItemPedido);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarItemPedido(@PathVariable Long id) {
		itemPedidoService.deletarItemPedido(id);
		return ResponseEntity.noContent().build();
	}
}

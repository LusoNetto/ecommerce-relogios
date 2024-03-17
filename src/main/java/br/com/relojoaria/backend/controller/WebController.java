package br.com.relojoaria.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.relojoaria.backend.entity.Categoria;
import br.com.relojoaria.backend.entity.Produto;
import br.com.relojoaria.backend.service.CategoriaService;
import br.com.relojoaria.backend.service.ProdutoService;
import br.com.relojoaria.backend.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class WebController {

	@Autowired
	private ProdutoService produtoService; // Injete o serviço de Produto aqui

	@Autowired
	private CategoriaService categoriaService; // Injete o serviço de Produto aqui

	@Autowired
	private UsuarioService usuarioService; // Injete o serviço de Produto aqui

	@GetMapping("/produtos")
	public String listarProdutos(Model model) {
		model.addAttribute("produtos", produtoService.listarProdutos());
		List<Categoria> categorias = categoriaService.listarCategorias(); // Supondo que você tenha um serviço para											// categorias
		model.addAttribute("categorias", categorias);
		model.addAttribute("produto", new Produto());
		return "crud-produtos"; // Nome da página Thymeleaf para o formulário
	}

	@GetMapping("/categorias")
	public String listarCategorias(Model model) {
		model.addAttribute("categorias", categoriaService.listarCategorias());
		return "crud-categorias"; // Nome do arquivo HTML Thymeleaf
	}

	@GetMapping("/usuarios")
	public String listarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.listarUsuarios());
		return "crud-usuarios"; // Nome do arquivo HTML Thymeleaf
	}
}

package br.com.relojoaria.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.relojoaria.backend.entity.Categoria;
import br.com.relojoaria.backend.entity.Produto;
import br.com.relojoaria.backend.service.CategoriaService;
import br.com.relojoaria.backend.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/produtos")
	public String listarProdutos(Model model) {
		List<Produto> produtos = produtoService.listarProdutos();
		model.addAttribute("produtos", produtos);
		return "pagina-de-listagem-de-produtos"; // Nome da página Thymeleaf
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
		Produto produto = produtoService.buscarProdutoPorId(id);
		if (produto != null) {
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public String adicionarProduto(@ModelAttribute Produto produto) {
		produtoService.salvarProduto(produto);
		return "redirect:/produtos"; // Redireciona de volta para a lista de produtos
	}

	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
	    produtoService.deletarProduto(id);
	    return ResponseEntity.noContent().build();
	}


	@GetMapping("/novo")
	public String novoProduto(Model model) {
		List<Categoria> categorias = categoriaService.listarCategorias();
		model.addAttribute("categorias", categorias);
		model.addAttribute("produto", new Produto());
		return "crud-produtos"; // Nome da página Thymeleaf
	}
}

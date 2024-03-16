package br.com.relojoaria.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.relojoaria.backend.model.Produto;
import br.com.relojoaria.backend.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public String listarProdutos(Model model) {
		List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
		model.addAttribute("produtos", produtos);
		return "produtos";
		
	}
}

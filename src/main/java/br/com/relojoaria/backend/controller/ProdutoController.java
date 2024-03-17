package br.com.relojoaria.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.relojoaria.backend.entity.Produto;
import br.com.relojoaria.backend.service.ProdutoService;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoService.listarTodosProdutos();
        model.addAttribute("produtos", produtos);
        return "lista-produtos";
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable("id") long id, Model model) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        model.addAttribute("produto", produto);
        return "formulario-produto";
    }

    @PostMapping("/editar/{id}")
    public String atualizarProduto(@PathVariable("id") long id, @ModelAttribute("produto") Produto produto) {
        produtoService.atualizarProduto(id, produto);
        return "redirect:/produtos";
    }

    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") long id) {
        produtoService.excluirProduto(id);
        return "redirect:/produtos";
    }
}


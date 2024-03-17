package br.com.relojoaria.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.relojoaria.backend.entity.Produto;
import br.com.relojoaria.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodosProdutos() {
        return (List<Produto>) produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void salvarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public void atualizarProduto(long id, Produto produtoAtualizado) {
        Produto produtoExistente = buscarProdutoPorId(id);
        if (produtoExistente != null) {
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setValor(produtoAtualizado.getValor());
            produtoRepository.save(produtoExistente);
        }
    }

    public void excluirProduto(long id) {
        produtoRepository.deleteById(id);
    }
}

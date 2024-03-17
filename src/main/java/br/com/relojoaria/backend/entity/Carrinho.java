package br.com.relojoaria.backend.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrinhos")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDoCarrinho> itens = new ArrayList<>();

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemDoCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoCarrinho> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemDoCarrinho item) {
        this.itens.add(item);
    }

    public void removerItem(ItemDoCarrinho item) {
        this.itens.remove(item);
    }
}


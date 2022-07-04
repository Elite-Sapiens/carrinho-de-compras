package com.elitesapiens.model;

import com.elitesapiens.model.interfaces.ICarrinho;
import com.elitesapiens.model.interfaces.IProduto;
import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

@Data
public class Carrinho implements ICarrinho {
    private final Set<IProduto> produtos = new TreeSet<>();

    public void addProduto(IProduto produto) {
        produtos.add(produto);
    }

    public void removeProduto(IProduto produto) {
        produtos.remove(produto);
    }

    @Override
    public double getPrecoTotal() {
        return produtos.stream().map(IProduto::getPrecoTotal).reduce(0.0, Double::sum);
    }
}

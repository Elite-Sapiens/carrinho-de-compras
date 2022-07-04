package com.elitesapiens.model;

import com.elitesapiens.model.exceptions.InvalidProductException;
import com.elitesapiens.model.interfaces.ICarrinho;
import com.elitesapiens.model.interfaces.IProduto;
import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

@Data
public class Carrinho implements ICarrinho {
    private final Set<IProduto> produtos = new TreeSet<>();

    public void addProduto(IProduto produto) {
        if (produto == null ) {
            throw new InvalidProductException("Produto não pode ser nulo");
        }

        if (produtos.contains(produto)) {
            produtos.stream()
                    .filter(p -> p.getNome().equals(produto.getNome()))
                    .findFirst()
                    .orElseThrow()
                    .addQuantidade(produto.getQuantidade());
        } else {
            produtos.add(produto);
        }
    }

    public void removeProduto(IProduto produto) {
        produtos.remove(produto);
    }

    @Override
    public double getPrecoTotal() {
        return produtos.stream().map(IProduto::getPrecoTotal).reduce(0.0, Double::sum);
    }
}

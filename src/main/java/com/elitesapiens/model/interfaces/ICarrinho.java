package com.elitesapiens.model.interfaces;

import java.util.Set;

public interface ICarrinho {

    Set<IProduto> getProdutos();
    void addProduto(IProduto produto);
    void removeProduto(IProduto produto);
    double getPrecoTotal();
}

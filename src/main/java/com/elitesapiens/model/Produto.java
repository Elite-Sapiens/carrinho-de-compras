package com.elitesapiens.model;

import com.elitesapiens.model.exceptions.InvalidQuantityException;
import com.elitesapiens.model.interfaces.IProduto;
import lombok.Data;

@Data
public class Produto implements IProduto {

    private String nome;
    private double preco;
    private int quantidade;

    @Override
    public void addQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public void removeQuantidade(int quantidade) {
        try {
            if (this.quantidade - quantidade < 0) {
                throw new InvalidQuantityException("Quantidade inválida");
            }
            this.quantidade -= quantidade;
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public double getPrecoTotal() {
        return this.preco * this.quantidade;
    }
}

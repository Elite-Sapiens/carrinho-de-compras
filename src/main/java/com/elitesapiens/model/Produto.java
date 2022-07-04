package com.elitesapiens.model;

import com.elitesapiens.model.exceptions.InvalidQuantityException;
import com.elitesapiens.model.interfaces.IProduto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Produto implements IProduto {

    private String nome;
    private double preco;
    private int quantidade;

    @Builder
    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new InvalidQuantityException("Quantidade deve ser maior ou igual a zero.");
        }
        this.quantidade = quantidade;
    }

    @Override
    public void addQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public void removeQuantidade(int quantidade) {
        if (this.quantidade - quantidade < 0) {
            throw new InvalidQuantityException("Quantidade inválida");
        }
        this.quantidade -= quantidade;
    }

    @Override
    public double getPrecoTotal() {
        return this.preco * this.quantidade;
    }

    @Override
    public int compareTo(IProduto o) {
        return this.nome.compareTo(o.getNome());
    }
}

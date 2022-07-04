package com.elitesapiens.model.interfaces;

public interface IProduto {
    // Getters
    String getNome();
    double getPreco();
    int getQuantidade();

    // Setters
    void setNome(String nome);
    void setPreco(double preco);
    void setQuantidade(int quantidade);

    // Methods
    void addQuantidade(int quantidade);
    void removeQuantidade(int quantidade);
    double getPrecoTotal();
}

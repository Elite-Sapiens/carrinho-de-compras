package com.elitesapiens.model;

import com.elitesapiens.model.interfaces.IProduto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {

    private Carrinho carrinho;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
    }

    @Test
    void deveRetornarVazioParaCarrinhoAoInicializar() {
        assertTrue(carrinho.getProdutos().isEmpty());
    }

    @ParameterizedTest(name = "Item = {0} - Preço = {1} - Quantidade = {2}")
    @CsvSource({"Creme Dental, 2.50, 1"})
    void deveRetornarQuantidadeDeItensParaCarrinho(String nome, double preco, int quantidade) {
        IProduto produto = Produto.builder()
                        .nome(nome)
                        .preco(preco)
                        .quantidade(quantidade)
                        .build();
        carrinho.addProduto(produto);
        assertEquals(1, carrinho.getProdutos().size());
    }

    @Test
    void deveRetornarPrecoTotalDeTodosOsItens() {
        IProduto P1 = Produto.builder()
                        .nome("Creme Dental")
                        .preco(2.50)
                        .quantidade(1)
                        .build();

        IProduto P2 = Produto.builder()
                        .nome("Coca-Cola")
                        .preco(6.50)
                        .quantidade(2)
                        .build();

        IProduto P3 = Produto.builder()
                        .nome("Suco de Laranja")
                        .preco(4.20)
                        .quantidade(3)
                        .build();

        carrinho.addProduto(P1);
        carrinho.addProduto(P2);
        carrinho.addProduto(P3);

        var expected =
                (P1.getPreco() * P1.getQuantidade()) +
                (P2.getPreco() * P2.getQuantidade()) +
                (P3.getPreco() * P3.getQuantidade());

        assertEquals(expected, carrinho.getPrecoTotal());
    }

    @Test
    void deveRetornarZeroQuandoRemoverAListComUmItem() {
        IProduto P1 = Produto.builder()
                        .nome("Creme Dental")
                        .preco(2.50)
                        .quantidade(1)
                        .build();

        carrinho.addProduto(P1);
        carrinho.removeProduto(P1);
        assertEquals(0, carrinho.getProdutos().size());
    }

    @Test
    void naoDeveAceitarItensIguaisPoremAumentarSuaQuantidadeNoCarrinho() {
        IProduto P1 = Produto.builder()
                        .nome("Creme Dental")
                        .preco(2.50)
                        .quantidade(1)
                        .build();

        IProduto P2 = Produto.builder()
                        .nome("Creme Dental")
                        .preco(2.50)
                        .quantidade(1)
                        .build();

        carrinho.addProduto(P1);
        carrinho.addProduto(P2);

        var itensDiferentesNoCarrinho = carrinho.getProdutos().size();
        var quantidadeDeCremeDental = carrinho.getProdutos().stream().iterator().next().getQuantidade();

        assertEquals(1, itensDiferentesNoCarrinho);
        assertEquals(2, quantidadeDeCremeDental);
    }
}
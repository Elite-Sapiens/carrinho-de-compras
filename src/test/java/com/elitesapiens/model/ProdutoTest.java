package com.elitesapiens.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = new Produto();
    }

    @Nested
    class VerificandoNome {

        @Test
        void deveRetornarNullParaNome() {
            assertNull(produto.getNome());
        }

        @Test
        void deveRetornarCremeDentalParaNome() {
            produto.setNome("Creme Dental");
            assertEquals("Creme Dental", produto.getNome());
        }
    }

    @Nested
    class VerificandoPreco {

        @Test
        void deveRetornarZeroParaPreco() {
            assertEquals(0.0, produto.getPreco());
        }

        @Test
        void deveRetornarR$10ParaPreco() {
            produto.setPreco(10.0);
            assertEquals(10.0, produto.getPreco());
        }
    }

    @Nested
    class VerificandoQuantidade {

        @Test
        void deveRetornarZeroParaQuantidade() {
            assertEquals(0, produto.getQuantidade());
        }

        @Test
        void deveRetornar1ParaQuantidade() {
            produto.setQuantidade(1);
            assertEquals(1, produto.getQuantidade());
        }
    }

    @Nested
    class VerificandoPrecoTotal {

        @Test
        void deveRetornarR$0ParaPrecoTotal() {
            assertEquals(0.0, produto.getPrecoTotal());
        }

        @Test
        void deveRetornarR$10ParaPrecoTotal() {
            produto.setPreco(10.0);
            produto.setQuantidade(1);
            assertEquals(10.0, produto.getPrecoTotal());
        }

        @Test
        void deveRetornarR$20ParaPrecoTotal() {
            produto.setPreco(10.0);
            produto.setQuantidade(2);
            assertEquals(20.0, produto.getPrecoTotal());
        }
    }

    @Nested
    class VerificandoPrecoTotalComCsv {

        @ParameterizedTest(name = "Produto = {0} - Preço = {1} - Quantidade = {2} - Preço Total = {3}")
        @CsvFileSource(resources = "/produtos.csv", numLinesToSkip = 1)
        void deveRetornarPrecoTotalCorreto(String nome, double preco, int quantidade, double precoTotal) {
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);

            assertEquals(precoTotal, produto.getPrecoTotal());
        }
    }
}
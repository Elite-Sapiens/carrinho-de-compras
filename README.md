# Carrinho de Compras com JUnit5

Mini projeto com duas classes: ```Carrinho``` e ```Produto```. Foram criadas duas classes de exceções: ```InvalidQuantityException``` e ```InvalidProductException``` para
a validação de alguns métodos.

A ideia não necessariamente simular uma compra, mas como adicionar, remover e atualizar um produto no carrinho.

Alguns testes feitos:

- Preço total do produto de acordo com a sua quantidade no carrinho
- Testes com um arquivo csv contendo nome, preço, quantidade e valor total
- Testes com exceptions, por exemplo, se o produto X tem 1 de quantidade, não é possível passar 2 ou mais como parâmetro
- Verificação do valor total somando todos os produtos
- Se o produto for nulo, o carrinho não vai fazer a inclusão
- O carrinho foi composto com um TreeSet, logo, é ordenado e não aceita itens iguais. Foi feito um teste de validação para adicionar o mesmo produto, como a implementação
não permite, o que é adicionado é a quantidade ao item que já está no carrinho. 

~~~EXEMPLO
  
  Carrinho carrinho = new Carrinho();
  
  // Iniciando dois produtos idênticos
  IProduto P1 = Produto.builder()
                        .nome("Creme Dental")
                        .preco(2.50)
                        .quantidade(1)
                        .build();
                        
  IProduto P2 = Produto.builder()
                        .nome("Creme Dental")
                        .preco(2.50)
                        .quantidade(2)
                        .build();
                        
  // Adicionando os produtos
  carrinho.addProduto(P1);
  carrinho.addProduto(P2);
  
  // Aqui acontece que o primeiro produto vai receber a quantidade do segundo produto porque eles são idênticos.
  var quantidadeDeCremeDental = carrinho.getProdutos().stream().iterator().next().getQuantidade();
  
  // Se fosse imprimir isso, daria 3.
  System.out.println("Quantidade de Creme Dental no Carrinho: " + quantidadeDeCremeDental);
  
  // Resultado
  Quantidade de Creme Dental no Carrinho: 3
                    
  
~~~

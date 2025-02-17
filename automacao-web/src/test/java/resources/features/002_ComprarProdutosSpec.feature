#language:pt

@Suite_Comprar_produtos

Funcionalidade: Realizar Compras de Produto


    @Comprar_produtos
    Cenario: Comprar Produtos específicos
    Dado que realizo o login
   	E verifico se o login foi realizado com sucesso
   	E Realizo a compra de 3 Stylish Dresses
   	E Realizo a compra de 2 Beautiful Peacock Blue Cotton Linen Saree
   	E Realizo a compra de 1 Men Tshirt
   	E Verifico se os itens foram adicionados corretamente no carrinho
   	E Realizo o Pagamento
   	Então Verifico se a compra foi realizada com sucesso
   	
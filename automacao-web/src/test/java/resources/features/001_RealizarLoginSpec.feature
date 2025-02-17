#language:pt

@Suite_Comprar_produtos

Funcionalidade: Realizar Compras de Produto

   	@Realizar_cadastro
   	 Cenario: Realizar Cadastro
   	 Dado que acesso a tela de cadastro
   	 E preencho os campos de cadastro
   	 Então verifico se o cadastro foi realizado com sucesso

	@Realizar_login
   	 Cenario: Realizar Login com Sucesso
   	 Dado que realizo o login
   	 Então verifico se o login foi realizado com sucesso

	@Realizar_logout
   	 Cenario: Realizar Logout com Sucesso
   	 Dado que realizo o login
   	 E verifico se o login foi realizado com sucesso
	 E realizo o logout
	 Então verifico se o logout foi realizado com sucesso

	@Realizar_login_credencial_incorreta
	 Cenario: Tentar Realizar Login com Credenciais Incorretas
   	 Dado que realizo o login com credenciais incorretas
	 Então verifico a mensagem de alerta de credenciais incorretas

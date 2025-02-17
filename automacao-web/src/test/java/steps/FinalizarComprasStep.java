package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import pages.FinalizarCompraPage;
import settings.DriverManager;

public class FinalizarComprasStep {
	private WebDriver driver;

	public FinalizarComprasStep() {
		this.driver = DriverManager.getDriver(); // Recupera o WebDriver da DriverManager
	}

	@Dado("Realizo o Pagamento")
	public void realizar_pagamento() {

		FinalizarCompraPage finalizarCompra = new FinalizarCompraPage(driver);
		finalizarCompra.acessarCheckout();
		finalizarCompra.acessarDadosPagamento();
		finalizarCompra.preencherDadosPagamento();
		finalizarCompra.finalizarPagamento();

	}

	@Então("Verifico se a compra foi realizada com sucesso")
	public void verificar_compra_sucesso() {

		FinalizarCompraPage finalizarCompra = new FinalizarCompraPage(driver);
		finalizarCompra.verCompraSucesso();
	}

}

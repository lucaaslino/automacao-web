package steps;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.ComprarProdutosPage;
import settings.DriverManager;

public class ComprarProdutosStep {
	private WebDriver driver;

	public ComprarProdutosStep() {
		this.driver = DriverManager.getDriver(); // Recupera o WebDriver da DriverManager
	}

	@Quando("Realizo a compra de {int} Stylish Dresses")
	public void comprar_stylish_dress(int qtdStylishDress) {

		ComprarProdutosPage compraPage = new ComprarProdutosPage(driver);
		ComprarProdutosPage.qtdStylishDress = qtdStylishDress;
		compraPage.adicionarCarrinhoStylishDress(ComprarProdutosPage.qtdStylishDress);

	}

	@Quando("Realizo a compra de {int} Beautiful Peacock Blue Cotton Linen Saree")
	public void comprar_beautiful_peacock(int qtdBeautPeacock) {

		ComprarProdutosPage compraPage = new ComprarProdutosPage(driver);
		ComprarProdutosPage.qtdBeautPeacock = qtdBeautPeacock;
		compraPage.adicionarCarrinhoBeautifulPeacock(ComprarProdutosPage.qtdBeautPeacock);

	}

	@Quando("Realizo a compra de {int} Men Tshirt")
	public void comprar_men_tshirt(int qtdMenTshirt) {

		ComprarProdutosPage compraPage = new ComprarProdutosPage(driver);
		ComprarProdutosPage.qtdMenTshirt = qtdMenTshirt;
		compraPage.adicionarCarrinhoMenTshirt(ComprarProdutosPage.qtdMenTshirt);

	}

	@Então("Verifico se os itens foram adicionados corretamente no carrinho")
	public void ver_itens_carrinho() {

		ComprarProdutosPage compraPage = new ComprarProdutosPage(driver);
		compraPage.acessarTelaCarrinho();
		compraPage.verQtdStylishDress();
		compraPage.verQtdBeautPeacock();
		compraPage.verQtdMenTshirt();

	}

}

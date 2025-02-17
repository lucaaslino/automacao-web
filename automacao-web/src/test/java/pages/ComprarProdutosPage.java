package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComprarProdutosPage {
	WebDriver driver;

	public ComprarProdutosPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static int qtdStylishDress;
	String sQtdStylishDress = Integer.toString(qtdStylishDress);

	public static int qtdBeautPeacock;
	String sQtdBeautPeacock = Integer.toString(qtdBeautPeacock);

	public static int qtdMenTshirt;
	String sQtdMenTshirt = Integer.toString(qtdMenTshirt);

	// Elementos Tela COMPRAS
	@FindBy(xpath = "//a[@data-product-id='4']")
	private WebElement stylishDress;

	@FindBy(xpath = "//a[@data-product-id='41']")
	private WebElement beautifulPeacock;

	@FindBy(xpath = "//a[@data-product-id='2']")
	private WebElement menTshirt;

	@FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
	private WebElement continuarCompras;

	// Elementos Tela Carrinho
	@FindBy(xpath = "//a[@href='/view_cart']")
	private WebElement pageCarrinho;

	@FindBy(xpath = "//tr[@id='product-4']/td/button[@class='disabled']")
	private WebElement qtd_cart_stylishDress;

	@FindBy(xpath = "//tr[@id='product-41']/td/button[@class='disabled']")
	private WebElement qtd_cart_beautifulPeacock;

	@FindBy(xpath = "//tr[@id='product-2']/td/button[@class='disabled']")
	private WebElement qtd_cart_menTshirt;

	// METODOS GERAIS
	// Método para esperar a visibilidade de um elemento
	public void waitForVisibility(WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void comprarQtdProduto(WebElement element, int qtdCompras) {
		for (int i = 0; i < qtdCompras; i++) {
			element.click();
			// Espera o elemento continuarCompras ser visível antes de clicar
			waitForVisibility(continuarCompras, 10);
			continuarCompras.click();
		}
	}

	// METODOS DE TESTES

	public void adicionarCarrinhoStylishDress(int qtdStylishDress) {

		System.out.println("Comprando StylishDress");
		ComprarProdutosPage.qtdStylishDress = qtdStylishDress;
		comprarQtdProduto(stylishDress, qtdStylishDress);
	}

	public void adicionarCarrinhoBeautifulPeacock(int qtdBeautPeacock) {

		System.out.println("Comprando BeautifulPeacock");
		ComprarProdutosPage.qtdBeautPeacock = qtdBeautPeacock;
		comprarQtdProduto(beautifulPeacock, qtdBeautPeacock);
	}

	public void adicionarCarrinhoMenTshirt(int qtdMenTshirt) {

		System.out.println("Comprando MenTshirt");
		ComprarProdutosPage.qtdMenTshirt = qtdMenTshirt;
		comprarQtdProduto(menTshirt, qtdMenTshirt);
	}

	public void acessarTelaCarrinho() {
		System.out.println("Acessando Carrinho de Compras");

		try {
			// Espera o elemento ficar visível e tenta clicar
			waitForVisibility(pageCarrinho, 10);
			pageCarrinho.click();
		} catch (Exception e) {
			// Caso não consiga clicar, acessa a URL diretamente
			System.out.println("Não foi possível clicar no botão devido aos ADS, acessando a URL diretamente.");
			String carrinhoUrl = "https://automationexercise.com/view_cart"; // Substitua pela URL real
			driver.get(carrinhoUrl);
		}
	}

	public void verQtdStylishDress() {

		Assert.assertEquals(sQtdStylishDress, qtd_cart_stylishDress.getText());
		System.out.println("Quantidade Correta de Stylish Dress no Carrinho");
	}

	public void verQtdBeautPeacock() {

		Assert.assertEquals(sQtdBeautPeacock, qtd_cart_beautifulPeacock.getText());
		System.out.println("Quantidade Correta de Beautiful Peacock Blue Cotton Linen Saree no Carrinho");

	}

	public void verQtdMenTshirt() {

		Assert.assertEquals(sQtdMenTshirt, qtd_cart_menTshirt.getText());
		System.out.println("Quantidade Correta de Men Tshirt no Carrinho");

	}

}

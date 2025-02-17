package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalizarCompraPage {
	WebDriver driver;

	public FinalizarCompraPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elementos Acessar Pagamento
	@FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
	private WebElement pageCheckout;

	@FindBy(xpath = "//a[@href='/payment']")
	private WebElement pagePagamento;

	// Elementos Pagamento
	@FindBy(xpath = "//input[@name='name_on_card']")
	private WebElement nomeCartao;

	@FindBy(xpath = "//input[@data-qa='card-number']")
	private WebElement numeroCartao;

	@FindBy(xpath = "//input[@data-qa='cvc']")
	private WebElement cvcCartao;

	@FindBy(xpath = "//input[@data-qa='expiry-month']")
	private WebElement mesExpiracaoCartao;

	@FindBy(xpath = "//input[@data-qa='expiry-year']")
	private WebElement anoExpiracaoCartao;

	@FindBy(xpath = "//button[@data-qa='pay-button']")
	private WebElement btnRealizarPagamento;

	@FindBy(xpath = "//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
	private WebElement verCompraSucesso;

	public void acessarCheckout() {

		pageCheckout.click();

	}

	public void acessarDadosPagamento() {

		pagePagamento.click();

	}
	
	public void preencherDadosPagamento() {

		nomeCartao.sendKeys("Joao da Silva");
		numeroCartao.sendKeys("5874698512548569");
		cvcCartao.sendKeys("654");
		mesExpiracaoCartao.sendKeys("10");
		anoExpiracaoCartao.sendKeys("2026");

	}
	
	public void finalizarPagamento() {

		btnRealizarPagamento.click();

	}

	public void verCompraSucesso() {

		Assert.assertEquals("Congratulations! Your order has been confirmed!", verCompraSucesso.getText());
		System.out.println("Verificado que a compra foi realizado com sucesso!");

	}
}

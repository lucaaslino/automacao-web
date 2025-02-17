package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

public class RealizarLoginPage {

	WebDriver driver;

	public RealizarLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Elementos LOGIN
	@FindBy(xpath = "//a[@href='/login']")
	private WebElement pageLogin;

	@FindBy(xpath = "//a[@href='/logout']")
	private WebElement pageLogout;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	private WebElement campoEmail;

	@FindBy(xpath = "//input[@data-qa='login-password']")
	private WebElement campoSenha;

	// Elementos Cadastro
	@FindBy(xpath = "//input[@data-qa='signup-name']")
	private WebElement nomeCadastro;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	private WebElement emailCadastro;

	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement radioMr;

	@FindBy(xpath = "//input[@data-qa='password']")
	private WebElement senhaCadastro;

	@FindBy(xpath = "//select[@id='days']")
	private WebElement diaNascCadastro;

	@FindBy(xpath = "//option[@value='6']")
	private WebElement selectDia;

	@FindBy(xpath = "//select[@id='months']")
	private WebElement mesNascCadastro;

	@FindBy(xpath = "//option[@value='June']")
	private WebElement selectMes;

	@FindBy(xpath = "//select[@id='years']")
	private WebElement anoNascCadastro;

	@FindBy(xpath = "//option[@value='2000']")
	private WebElement selectAno;

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement endNomeCadastro;

	@FindBy(xpath = "//input[@data-qa='last_name']")
	private WebElement endSobrenomeCadastro;

	@FindBy(xpath = "//input[@id='address1']")
	private WebElement enderecoCadastro;

	@FindBy(xpath = "//input[@id='state']")
	private WebElement endEstadoCadastro;

	@FindBy(xpath = "//input[@id='city']")
	private WebElement endCidadeCadastro;

	@FindBy(xpath = "//input[@id='zipcode']")
	private WebElement endCepCadastro;

	@FindBy(xpath = "//input[@id='mobile_number']")
	private WebElement numTelCadastro;

	@FindBy(xpath = "//button[@data-qa='create-account']")
	private WebElement btnCriarConta;

	@FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
	private WebElement verCadastroSucessoMsg;

	@FindBy(xpath = "//b[contains(text(),'Joao da Silva')]")
	private WebElement verLoginSucessoMsg;

	@FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
	private WebElement verLoginIncorretoMsg;

	// METODOS AVULSO

	Faker faker = new Faker();
	String fakeEmail = faker.internet().emailAddress();
	private static String emailCadastrado;

	public String getEmailCadastrado() {
		return emailCadastrado;
	}

	// Metodos de Testes

	public void realizarLogin() {
		System.out.println("Realizando Login com o: " + getEmailCadastrado());
		pageLogin.click();
		campoEmail.sendKeys(getEmailCadastrado());
		campoSenha.sendKeys("senhaforte123");
		campoSenha.sendKeys(Keys.ENTER);

	}

	public void realizarLogout() {
		System.out.println("Realizando Logout");
		pageLogout.click();
	}

	public void acessarTelaCadastro() {
		System.out.println("Acessando a tela de Cadastro");
		String email = fakeEmail;
		pageLogin.click();
		nomeCadastro.sendKeys("Joao da Silva");
		emailCadastro.sendKeys(email);
		emailCadastro.sendKeys(Keys.ENTER);

		// Armazenando o email para login posterior
		emailCadastrado = email;
	}

	public void preencherCadastro() {
		System.out.println("Preenchendo os dados de Cadastro");
		radioMr.click();
		senhaCadastro.sendKeys("senhaforte123");
		diaNascCadastro.sendKeys("10");
		mesNascCadastro.sendKeys("June");
		anoNascCadastro.sendKeys("2000");
		endNomeCadastro.sendKeys("Joao");
		endSobrenomeCadastro.sendKeys("Da Silva");
		enderecoCadastro.sendKeys("Rua 02");
		endEstadoCadastro.sendKeys("DF");
		endCidadeCadastro.sendKeys("Brasilia");
		endCepCadastro.sendKeys("72410106");
		numTelCadastro.sendKeys("61981853337");
		btnCriarConta.click();

	}

	public void realizarLoginCredIncorretas() {
		System.out.println("Realizando Login com credenciais Incorretas");
		pageLogin.click();
		campoEmail.sendKeys(getEmailCadastrado());
		campoSenha.sendKeys("senhaerrada123");
		campoSenha.sendKeys(Keys.ENTER);

	}

	public void verCadastroSucesso() {

		Assert.assertEquals("Congratulations! Your new account has been successfully created!",
				verCadastroSucessoMsg.getText());
		System.out.println("Verificado que o cadastro foi realizado com sucesso!");

	}

	public void verLoginSucesso() {

		Assert.assertEquals("Joao da Silva",
				verLoginSucessoMsg.getText());
		System.out.println("Verificado que o Login foi realizado com sucesso!");

	}

	public void verLogoutSucesso() {

		Assert.assertEquals("Signup / Login",
				pageLogin.getText());
		System.out.println("Verificado que o Logout foi realizado com sucesso!");

	}

	public void verLoginIncorreto() {

		Assert.assertEquals("Your email or password is incorrect!",
				verLoginIncorretoMsg.getText());
		System.out.println("Verificado que o Alerta de Credenciais Incorretas foi Mostrado");

	}

}

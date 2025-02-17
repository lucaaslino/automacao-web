package steps;

import org.openqa.selenium.WebDriver;
import settings.DriverManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import pages.RealizarLoginPage;

public class RealizarLoginStep {

	private WebDriver driver;

	public RealizarLoginStep() {
		this.driver = DriverManager.getDriver(); // Recupera o WebDriver da DriverManager
	}

	@Dado("que realizo o login")
	public void realizar_login() {
		RealizarLoginPage loginPage = new RealizarLoginPage(driver);
		loginPage.realizarLogin();
	}

	@Dado("realizo o logout")
	public void realizar_logout() {
		RealizarLoginPage loginPage = new RealizarLoginPage(driver);
		loginPage.realizarLogout();
	}

	@Dado("que acesso a tela de cadastro")
	public void acessar_tela_cadastro() {
		RealizarLoginPage loginPage = new RealizarLoginPage(driver);
		loginPage.acessarTelaCadastro();
	}

	@Dado("preencho os campos de cadastro")
	public void preencher_cadastro() {
		RealizarLoginPage loginPage = new RealizarLoginPage(driver);
		loginPage.preencherCadastro();
	}

	@Dado("que realizo o login com credenciais incorretas")
	public void realizar_login_incorreto() {
		RealizarLoginPage loginPage = new RealizarLoginPage(driver);
		loginPage.realizarLoginCredIncorretas();
	}

	@Então("verifico se o cadastro foi realizado com sucesso")
	public void verificar_cadastro_sucesso() {
		RealizarLoginPage loginPage = new RealizarLoginPage(driver);
		loginPage.verCadastroSucesso();
	}

	@Então("verifico se o login foi realizado com sucesso")
	public void verificar_login_sucesso() {
		RealizarLoginPage loginPage = new RealizarLoginPage(driver);
		loginPage.verLoginSucesso();
	}

	@Então("verifico se o logout foi realizado com sucesso")
	public void verificar_logout_sucesso() {
		RealizarLoginPage loginPage = new RealizarLoginPage(driver);
		loginPage.verLogoutSucesso();
	}

	@Então("verifico a mensagem de alerta de credenciais incorretas")
	public void verificar_login_incorreto() {
		RealizarLoginPage loginPage = new RealizarLoginPage(driver);
		loginPage.verLoginIncorreto();
	}

}

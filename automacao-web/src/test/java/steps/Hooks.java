package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import settings.DriverManager;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverManager.getDriver();
        driver.get("https://automationexercise.com/");
        System.out.println("Cenário em execução: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        String status = scenario.isFailed() ? "- FALHOU!" : "- PASSOU!";
        System.out.println("O cenário '" + scenario.getName() + "' " + status);

        saveScreenshot(scenario); // Captura e anexa o screenshot sempre
        saveTextLog("Status do Teste: " + status); // Salva um log no Allure

        // Sempre salva o HTML da página
        savePageSource();

        if (scenario.isFailed()) {
            // Se o cenário falhou, marca no log
            System.out.println(" O cenário falhou! Verifique o relatório para mais detalhes.");
        }

        DriverManager.quitDriver();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(Scenario scenario) {
        System.out.println("Capturando Screenshot...");
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Criar o diretório de resultados, se necessário
        try {
            Files.createDirectories(Paths.get("target/allure-results"));
        } catch (Exception e) {
            System.out.println("Erro ao criar diretório de resultados: " + e.getMessage());
        }

        // Usar ByteArrayInputStream para criar um InputStream a partir do byte[]
        Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");

        // Retornar o screenshot em formato byte[] para o Allure
        return screenshot;
    }

    @Attachment(value = "Log do Teste", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "HTML da Página", type = "text/html")
    public String savePageSource() {
        return driver.getPageSource();
    }
}

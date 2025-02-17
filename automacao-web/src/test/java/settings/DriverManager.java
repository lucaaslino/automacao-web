package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            // Aqui você pode configurar a resolução do navegador
            options.addArguments("--window-size=400,872");
            // WebDriverManager irá baixar e configurar automaticamente o chromedriver
            // Adiciona a opção headless
            options.addArguments("--headless");
            options.addArguments("--disable-gpu"); // Evita erro em alguns sistemas
            options.addArguments("--no-sandbox"); // Necessário em alguns sistemas
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver(options);

        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

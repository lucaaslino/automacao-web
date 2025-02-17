package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/features/", // Caminho correto das features
                glue = { "steps" }, // Pacote das classes de step
                plugin = {
                                "pretty",
                                "html:target/cucumber-reports.html", // Relatório HTML do Cucumber
                                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Plugin do Allure para gerar os
                                                                                   // resultados
                })
public class TestRunner {
}

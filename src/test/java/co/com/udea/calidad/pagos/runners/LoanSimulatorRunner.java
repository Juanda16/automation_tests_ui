package co.com.udea.calidad.pagos.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/loan_simulator.feature",
        glue = "co.com.udea.calidad.pagos.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class LoanSimulatorRunner {
    
}

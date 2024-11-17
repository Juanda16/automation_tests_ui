package co.com.udea.calidad.pagos.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

import org.openqa.selenium.WebDriver;

import co.com.udea.calidad.loan_simulator.interactions.ChooseDropdownValue;
import co.com.udea.calidad.loan_simulator.interactions.EnterLoanAmount;
import co.com.udea.calidad.loan_simulator.models.LoanSimulatorModel;
import co.com.udea.calidad.loan_simulator.questions.ValidateMessage;
import co.com.udea.calidad.loan_simulator.questions.ValueGraterThan;
import co.com.udea.calidad.loan_simulator.tasks.OpenThe;
import co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;    

public class LoanSimulatorStepDefinition {

    public final Actor cliente = Actor.named("Cliente");

    @Managed(driver = "chrome",uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void setup(){
        cliente.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());

    }

    @Given("I am in the loan simulator page")
    public void I_am_in_the_loan_simulator_page() {
        cliente.attemptsTo(OpenThe.browser(new LoanSimulatorPage()));
    }

    @When("I enter the loan amount {int}")
    public void I_enter_the_loan_amount(int i) {
        System.out.println("amount: "+i);
        cliente.attemptsTo(EnterLoanAmount.withAmount(i));
    }


    @And("I choose the number of payments {string}")
    public void I_choose_the_number_of_payments(String payments) {
        System.out.println("payments: "+payments);
        cliente.attemptsTo(ChooseDropdownValue.withValue(payments));
    }

    @Then("I can see the monthly payment higher than {int}")
    public void I_can_see_the_monthly_payment_higher_than(int value) {
    
        ValueGraterThan.isGreaterThan(value);
       
    }

    @Then("I can see the minimun ammount required error message")
    public void I_can_see_the_minimun_ammount_required_error_message() {

        ValidateMessage.contains("*El valor mínimo es de 400.000 pesos");
    }

    @When("I enter the loan model {int} and {string}")
    public void i_have_a_loan_simulator_model(int ammount, String payments) {
        LoanSimulatorModel loanSimulatorModel = new LoanSimulatorModel(ammount, payments);

        cliente.attemptsTo(
            EnterLoanAmount.withAmount(loanSimulatorModel.getLoanAmount()),
            ChooseDropdownValue.withValue(loanSimulatorModel.getLoanTerm())
        );
    }

}

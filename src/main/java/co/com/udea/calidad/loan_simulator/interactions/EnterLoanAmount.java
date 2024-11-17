package co.com.udea.calidad.loan_simulator.interactions;

import static co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage.DROPDOWN_LIST;
import static co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage.LINK_TO_SIMULATE;
import static co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage.VALUE_INPUT_TEXT;

import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class EnterLoanAmount implements Interaction {

    private final int loanAmount;

    public EnterLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LINK_TO_SIMULATE));
        actor.attemptsTo(WaitUntil.the(VALUE_INPUT_TEXT, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds());
        actor.attemptsTo(WaitUntil.the(VALUE_INPUT_TEXT, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(WaitUntil.the(DROPDOWN_LIST, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(WaitUntil.the(VALUE_INPUT_TEXT, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Enter.theValue(String.valueOf(loanAmount)).into(VALUE_INPUT_TEXT).thenHit(Keys.RETURN));
    }

    public static EnterLoanAmount withAmount(int loanAmount) {
        return Tasks.instrumented(EnterLoanAmount.class, loanAmount);
    }
}

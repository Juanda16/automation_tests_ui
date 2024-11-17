package co.com.udea.calidad.loan_simulator.interactions;

import static co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage.DROPDOWN_LIST;
import static co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage.DROPDOWN_LIST_CONTAINER;
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

public class EnterThe  implements Interaction {

private final int loanAmount;

    public EnterThe(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LINK_TO_SIMULATE));

        actor.attemptsTo(WaitUntil.the(VALUE_INPUT_TEXT, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds());
        
        actor.attemptsTo(Enter.theValue(String.valueOf(loanAmount)).into(VALUE_INPUT_TEXT).thenHit(Keys.RETURN));
        
        actor.attemptsTo(WaitUntil.the(DROPDOWN_LIST, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
        
        actor.attemptsTo(Click.on(DROPDOWN_LIST));
        
        actor.attemptsTo(Click.on(DROPDOWN_LIST_CONTAINER));
        
        // Wait for a few seconds to see the result before closing the browser
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static EnterThe withAmount(int loanAmount) {
        return Tasks.instrumented(EnterThe.class, loanAmount);
    }

}




// @Override
// public <T extends Actor> void performAs(T actor) {
//      actor.attemptsTo(Click.on(LINK_TO_SIMULATE));
//     // actor.attemptsTo(Enter.theValue(" 1000000").into(VALUE_INPUT_TEXT).thenHit(Keys.RETURN));
//     // actor.attemptsTo(SelectFromOptions.byVisibleText("72 meses").from(DROPDOWN_LIST));
//     // actor.attemptsTo(Click.on(LINK_TO_UDEA_HOMEPAGE));

//     // Wait until the VALUE_INPUT_TEXT is visible
//     actor.attemptsTo(WaitUntil.the(VALUE_INPUT_TEXT, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());
    
//     actor.attemptsTo(Enter.theValue("1000000").into(VALUE_INPUT_TEXT).thenHit(Keys.RETURN));


//     actor.attemptsTo(Click.on(DROPDOWN_LIST));
    
//     // Wait until the DROPDOWN_LIST is visible
//     actor.attemptsTo(WaitUntil.the(DROPDOWN_LIST, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds());

//     actor.attemptsTo(Click.on(DROPDOWN_LIST_CONTAINER));
// // Wait for a few seconds to see the result before closing the browser
//     try {
//         Thread.sleep(5000); // Wait for 5 seconds
//     } catch (InterruptedException e) {
//         e.printStackTrace();
//     }


  


// }
// public static EnterThe ammount(int ammount){
//     return Tasks.instrumented(EnterThe.class);
// }
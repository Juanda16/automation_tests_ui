package co.com.udea.calidad.loan_simulator.interactions;

import static co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage.DROPDOWN_LIST;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;

public class ChooseDropdownValue implements Interaction {

    private final String value;

    public ChooseDropdownValue(String value) {
        if (!isValidValue(value)) {
            throw new IllegalArgumentException("Invalid value: " + value);
        }
        this.value = value;
    }

    private boolean isValidValue(String value) {
        return value.equals("36 meses") || value.equals("48 meses") || value.equals("60 meses") || value.equals("72 meses");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("ChooseDropdownValue: " + value);

        actor.attemptsTo(WaitUntil.the(DROPDOWN_LIST, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Click.on(DROPDOWN_LIST));

         // Define a dynamic target for the dropdown value
         Target DROPDOWN_OPTION = Target.the("dropdown option").locatedBy("//div[contains(text(), '{0}')]");
        
         // Click on the specific value in the dropdown container
         actor.attemptsTo(Click.on(DROPDOWN_OPTION.of(value)));

        // actor.attemptsTo(SelectFromOptions.byVisibleText(value).from(DROPDOWN_LIST_CONTAINER));
        // Click on the specific value in the dropdown container
        //actor.attemptsTo(Click.on(DROPDOWN_LIST_CONTAINER.of(value)));
        // Wait for a few seconds to see the result before closing the browser
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ChooseDropdownValue withValue(String value) {
        return Tasks.instrumented(ChooseDropdownValue.class, value);
    }
}
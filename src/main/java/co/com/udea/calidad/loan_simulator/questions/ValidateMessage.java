package co.com.udea.calidad.loan_simulator.questions;

import static co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage.AMMOUNT_ERROR_MESSAGE;

import org.hamcrest.Matchers;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateMessage implements Question<Boolean> {

    private final String expectedMessage;

    public ValidateMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String errorMessage = Text.of(AMMOUNT_ERROR_MESSAGE).answeredBy(actor);
        System.out.println("errorMessage: " + errorMessage);
        return Matchers.containsString(expectedMessage).matches(errorMessage);
    }

    public static ValidateMessage contains(String expectedMessage) {
        return new ValidateMessage(expectedMessage);
    }
}



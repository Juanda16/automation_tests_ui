package co.com.udea.calidad.loan_simulator.tasks;



import static co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage.AMMOUNT_ERROR_MESSAGE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;




public class FindOutThe implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(AMMOUNT_ERROR_MESSAGE).answeredBy(actor);
    }

    public static FindOutThe errorMessage() {
        return new FindOutThe();
    }
}

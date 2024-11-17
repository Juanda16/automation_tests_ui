package co.com.udea.calidad.loan_simulator.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class Validation implements Question<String> {

    private final Target target;

    public Validation(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        String  msg = BrowseTheWeb.as(actor).find(target).getText();
        return msg;
    }

    

    public static Validation of(Target target) {
        return new Validation(target);
    }
}
package co.com.udea.calidad.loan_simulator.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValueGraterThan implements Question<Boolean> {

    private final double value;

    public ValueGraterThan(double value) {
        this.value = value;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String answer = VerifyLoanMontlyPayment.theLoanMontlyPayment().answeredBy(actor);
        String cleanedAnswer = answer.replace("$", "").replace(",", "").replace(".", "");
        System.out.println("cleanedAnswer: " + cleanedAnswer);
        double parsedValue = Double.parseDouble(cleanedAnswer);
        System.out.println("parsedValue: " + parsedValue);
        return parsedValue > value;
    }

    public static Question<Boolean> isGreaterThan(double value) {
        return new ValueGraterThan(value);
    }
}
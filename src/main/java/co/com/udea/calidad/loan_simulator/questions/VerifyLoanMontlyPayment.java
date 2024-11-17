package co.com.udea.calidad.loan_simulator.questions;

import static co.com.udea.calidad.loan_simulator.userinterfaces.LoanSimulatorPage.LOAN_VALUE_RESULT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class VerifyLoanMontlyPayment implements Question<String> {
    public VerifyLoanMontlyPayment(){}

    @Override
    public String answeredBy(Actor actor) {
        String  msg = BrowseTheWeb.as(actor).find(LOAN_VALUE_RESULT).getText();
        System.out.println("msg: "+msg);
        return msg;
    }

    

    public static VerifyLoanMontlyPayment theLoanMontlyPayment(){
        return new VerifyLoanMontlyPayment();
    }

    
}

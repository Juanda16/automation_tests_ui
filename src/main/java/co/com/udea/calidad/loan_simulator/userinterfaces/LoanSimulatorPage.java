package co.com.udea.calidad.loan_simulator.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoanSimulatorPage extends PageObject {
    
    public static final Target VALUE_INPUT_TEXT = Target.the("INPUT TEXT").located(By.id("txt-input-amount"));
    public static final Target DROPDOWN_LIST = Target.the("DROPDOWN LIST").locatedBy("/html/body/ion-app/ng-component/ion-nav/page-simulator/ion-content/div[2]/input-amount/div/div[4]/div/dropdown-bdb/div/div/div");
    public static final Target INPUT_TEXT1 = Target.the("INPUT TEXT").locatedBy("//*[@name='q']");
    public static final Target LINK_TO_SIMULATE = Target.the("LINK TO SIMULATE").located(By.id("cta01"));
    public static final Target LOAN_VALUE_RESULT_TARGET = Target.the("LOAN VALUE RESULT TARGET").locatedBy("//*[@id='loan-value']");
    public static final Target DROPDOWN_LIST_CONTAINER = Target.the("DROPDOWN LIST CONTAINER").located(By.id("dd-options-terms"));
    public static final Target LOAN_VALUE_RESULT = Target.the("LOAN VALUE RESULT").locatedBy("/html/body/ion-app/ng-component/ion-nav/page-simulator/ion-content/div[2]/div[4]/resume-simulator/div/div[1]/div[2]/div[2]");
    public static final Target AMMOUNT_ERROR_MESSAGE = Target.the("AMMOUNT ERROT MESSAGE").locatedBy("/html/body/ion-app/ng-component/ion-nav/page-simulator/ion-content/div[2]/input-amount/div/div[2]/div/form/p");


}

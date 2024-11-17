package co.com.udea.calidad.loan_simulator.models;

public class LoanSimulatorModel {
    private int loanAmount;
    private String loanTerm;

    public LoanSimulatorModel(int loanAmount, String loanTerm) {
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }
}

package ru.netology.losev;

public class LoanOperation extends Operation implements ConsolePrintable {
    private int loanId;

    public LoanOperation(double amount, boolean isTransfer, String date, int loanId) {
        super(amount, isTransfer, date);
        this.loanId = loanId;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Loan ID: " + loanId);
    }
}

package ru.netology.losev;
class LoanOperation extends Operation {
    private int loanId;

    @Override
    public void print() {
        super.print();
        System.out.println("Loan ID: " + loanId);
    }
}
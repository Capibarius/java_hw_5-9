package ru.netology.losev;

public class CashbackOperation extends Operation implements ConsolePrintable {
    private int cashbackAmount;

    public CashbackOperation(double amount, boolean isTransfer, String date, int cashbackAmount) {
        super(amount, isTransfer, date);
        this.cashbackAmount = cashbackAmount;
    }

    public int getCashbackAmount() {
        return cashbackAmount;
    }

    public void setCashbackAmount(int cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Cashback Amount: " + cashbackAmount);
    }
}

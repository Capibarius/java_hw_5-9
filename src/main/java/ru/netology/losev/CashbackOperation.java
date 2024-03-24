package ru.netology.losev;
class CashbackOperation extends Operation {
    private int cashbackAmount;

    @Override
    public void print() {
        super.print();
        System.out.println("Cashback Amount: " + cashbackAmount);
    }
}
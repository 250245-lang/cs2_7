public class CashTransaction extends Payment {
    private double cashTendered;

    public CashTransaction(int paymentID, double amount, double cashTendered) {
        super(paymentID, amount);
        this.cashTendered = cashTendered;
    }

    public double getCashTendered() { return cashTendered; }
    public void setCashTendered(double cashTendered) { this.cashTendered = cashTendered; }

    @Override
    public boolean makeTransaction() {
        if (cashTendered >= getAmount()) {
            System.out.println("Processing Cash. Change to return: $" + (cashTendered - getAmount()));
            return super.makeTransaction();
        } else {
            System.out.println("Insufficient cash tendered.");
            setStatus(PaymentStatus.FAILED);
            return false;
        }
    }
}

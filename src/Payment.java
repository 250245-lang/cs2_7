public class Payment {
    private int paymentID;
    private double amount;
    private PaymentStatus status;
    
    public Payment(int paymentID, double amount) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.status = PaymentStatus.UNPAID;
    }

    public int getPaymentID() { return paymentID; }
    public void setPaymentID(int paymentID) { this.paymentID = paymentID; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }

    public boolean makeTransaction() {
        this.status = PaymentStatus.COMPLETED;
        System.out.println("Transaction completed for amount: $" + amount);
        return true;
    }
}

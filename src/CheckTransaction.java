public class CheckTransaction extends Payment {
    private String bankName;
    private String checkNumber;

    public CheckTransaction(int paymentID, double amount, String bankName, String checkNumber) {
        super(paymentID, amount);
        this.bankName = bankName;
        this.checkNumber = checkNumber;
    }

    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    public String getCheckNumber() { return checkNumber; }
    public void setCheckNumber(String checkNumber) { this.checkNumber = checkNumber; }

    @Override
    public boolean makeTransaction() {
        System.out.println("Processing Check from " + bankName + " [CheckNo: " + checkNumber + "]");
        return super.makeTransaction();
    }
}

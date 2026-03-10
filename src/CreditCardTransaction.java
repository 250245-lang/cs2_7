public class CreditCardTransaction extends Payment {
    private String nameOnCard;

    public CreditCardTransaction(int paymentID, double amount, String nameOnCard) {
        super(paymentID, amount);
        this.nameOnCard = nameOnCard;
    }

    public String getNameOnCard() { return nameOnCard; }
    public void setNameOnCard(String nameOnCard) { this.nameOnCard = nameOnCard; }

    @Override
    public boolean makeTransaction() {
        System.out.println("Processing Credit Card for " + nameOnCard);
        return super.makeTransaction();
    }
}

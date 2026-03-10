public class SmsNotification extends Notification {
    private String phoneNumber;

    public SmsNotification(int notificationId, String content, String phoneNumber) {
        super(notificationId, content);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public boolean send() {
        System.out.println("Sending SMS to " + phoneNumber + " -> " + getContent());
        return true;
    }
}

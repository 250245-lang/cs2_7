public class PostalNotification extends Notification {
    private Address address;

    public PostalNotification(int notificationId, String content, Address address) {
        super(notificationId, content);
        this.address = address;
    }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Override
    public boolean send() {
        System.out.println("Sending postal mail to " + address.getStreetAddress() + " -> " + getContent());
        return true;
    }
}

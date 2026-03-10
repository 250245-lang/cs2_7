public class FrontDeskOfficer extends Person {
    public FrontDeskOfficer(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
    }

    public boolean createItinerary(Itinerary itinerary) {
        System.out.println("FrontDeskOfficer created itinerary for customer ID: " + itinerary.getCustomerId());
        return itinerary.makeReservation();
    }
}

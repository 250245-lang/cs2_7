public class Admin extends Person {
    public Admin(String name, Address address, String email, String phone, Account account) {
        super(name, address, email, phone, account);
    }

    public boolean addAircraft(Aircraft aircraft) { 
        System.out.println("Aircraft added: " + aircraft.getName());
        return true; 
    }
    
    public boolean addFlight(Flight flight) { 
        System.out.println("Flight added: " + flight.getFlightNumber());
        return true; 
    }
    
    public boolean blockUser(Person user) { 
        if (user.getAccount() != null) {
            user.getAccount().setStatus(AccountStatus.BLOCKED);
            System.out.println("User blocked: " + user.getName());
            return true;
        }
        return false; 
    }
}

public class Admin {
    private static Admin instance;

    private Admin() {
    }

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }

    public void viewCoachStatus(Train train) {
        for (Coach coach : train.getCoaches()) {
            int bookedSeats = (int) coach.getSeats().stream().filter(Seat::isBooked).count();
            System.out.println("Coach " + coach.getCoachNumber() + " has " + bookedSeats + " seats booked.");
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private int coachNumber;
    private List<Seat> seats;

    public Coach(int coachNumber) {
        this.coachNumber = coachNumber;
        this.seats = new ArrayList<>();
        double basePrice = 2000.0;
        for (int i = 1; i <= 60; i++) {
            String berthType = (i <= 20) ? "Upper" : (i <= 40) ? "Lower" : "Middle";
            seats.add(new Seat(i, berthType, basePrice));
        }
    }

    public boolean bookSeat(String berthPreference) {
        int filledSeats = (int) seats.stream().filter(Seat::isBooked).count();
        double basePrice = 2000.0;
        double dynamicPrice = basePrice;

        double percentageFilled = (double) filledSeats / seats.size();
        if (percentageFilled >= 0.4) {
            dynamicPrice = basePrice * 1.18;
        } else if (percentageFilled >= 0.35) {
            dynamicPrice = basePrice * 1.15;
        } else if (percentageFilled >= 0.3) {
            dynamicPrice = basePrice * 1.12;
        } else if (percentageFilled >= 0.2) {
            dynamicPrice = basePrice * 1.10;
        }

        for (Seat seat : seats) {
            if (!seat.isBooked() && seat.getBerthType().equalsIgnoreCase(berthPreference)) {
                seat.setBooked(true);
                seat.setPrice(dynamicPrice);
                System.out.println("Booking seat number: " + seat.getNumber() + " in Coach " + coachNumber + " with price: " + dynamicPrice);
                return true;
            }
        }
        return false;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getCoachNumber() {
        return coachNumber;
    }
}

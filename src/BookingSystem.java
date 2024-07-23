import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class BookingSystem {
    private static BookingSystem instance;

    private BookingSystem() {
    }

    public static BookingSystem getInstance() {
        if (instance == null) {
            instance = new BookingSystem();
        }
        return instance;
    }

    public void start() {
        Train train1 = new Train(1);
        Train train2 = new Train(2);

        Scanner scanner = new Scanner(System.in);

        boolean continueBooking = true;

        while (continueBooking) {
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            System.out.println("Enter your meal preference (Veg/Non-Veg):");
            String mealPreference = scanner.nextLine();
            System.out.println("Enter your berth preference (Upper/Lower/Middle):");
            String berthPreference = scanner.nextLine();

            User user = new User(name, mealPreference, berthPreference);

            boolean bookingSuccessful = false;

            for (Train train : new Train[]{train1, train2}) {
                for (Coach coach : train.getCoaches()) {
                    if (coach.bookSeat(user.getBerthPreference())) {
                        bookingSuccessful = true;
                        System.out.println("Booking successful in Train " + train.getTrainNumber() + ", Coach " + coach.getCoachNumber());
                        System.out.println("Please wait for 5 seconds to see your booking details...");

                        Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                System.out.println("User Details: ");
                                System.out.println("Name: " + user.getName());
                                System.out.println("Meal Preference: " + user.getMealPreference());
                                System.out.println("Berth Preference: " + user.getBerthPreference());
                                System.out.println("Booked Seat Price: " + coach.getSeats().stream().filter(seat -> seat.isBooked() && seat.getBerthType().equalsIgnoreCase(user.getBerthPreference())).findFirst().get().getPrice());
                            }
                        }, 5000);

                        break;
                    }
                }
                if (bookingSuccessful) {
                    break;
                }
            }

            if (!bookingSuccessful) {
                System.out.println("No available seats matching your preference.");
            }

            System.out.println("Would you like to book another seat? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                continueBooking = false;
            }
        }

        System.out.println("Are you an admin? (yes/no)");
        String isAdmin = scanner.nextLine();
        if (isAdmin.equalsIgnoreCase("yes")) {
            Admin admin = Admin.getInstance();
            admin.viewCoachStatus(train1);
            admin.viewCoachStatus(train2);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        BookingSystem bookingSystem = BookingSystem.getInstance();
        bookingSystem.start();
    }
}

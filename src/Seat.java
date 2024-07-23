public class Seat {
    private int number;
    private String berthType;
    private boolean isBooked;
    private double price;

    public Seat(int number, String berthType, double basePrice) {
        this.number = number;
        this.berthType = berthType;
        this.isBooked = false;
        this.price = basePrice;
    }

    public int getNumber() {
        return number;
    }

    public String getBerthType() {
        return berthType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

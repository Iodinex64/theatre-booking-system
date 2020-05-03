package ADT;

public class Seat {
    private Booking assignedBooking;
    private char seatTier;
    private int seatNumber;
    //private boolean isConnected;

    public Seat(char seatTier, int seatNumber/*, boolean isConnected*/) {
        this.seatTier = seatTier;
        this.seatNumber = seatNumber;
        //this.isConnected = isConnected;
    }

    public Booking getAssignedBooking() {
        return assignedBooking;
    }

    public void setAssignedBooking(Booking assignedBooking) {
        this.assignedBooking = assignedBooking;
    }

    public char getSeatTier() {
        return seatTier;
    }

    public void setSeatTier(char seatTier) {
        this.seatTier = seatTier;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "" + seatTier + seatNumber;
    }

    /*
    public boolean isContinuous() {
        return isConnected;
    }

    public void setContinuous(boolean continuous) {
        isConnected = continuous;
    }*/
}

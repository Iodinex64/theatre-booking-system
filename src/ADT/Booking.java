package ADT;

import Utils.LinkedList.LinkedList;
import Utils.LinkedList.Node;

public class Booking {
    public LinkedList<Seat> seatList;
    private String customerName;
    private int bookingID;
    private Performance assignedPerformance;

    public Booking(String customerName, int bookingID, Performance assignedPerformance) {
        this.customerName = customerName;
        this.bookingID = bookingID;
        this.assignedPerformance = assignedPerformance;
        this.seatList = new LinkedList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Performance getAssignedPerformance() {
        return assignedPerformance;
    }

    public void setAssignedPerformance(Performance assignedPerformance) {
        this.assignedPerformance = assignedPerformance;
    }

    @Override
    public String toString() {
        String allSeats;
        StringBuilder allSeatsBuilder = new StringBuilder();
        for (Node se = seatList.head; se != null; se = se.next) {
            allSeatsBuilder.append(" ").append(se.data);
        }
        allSeats = allSeatsBuilder.toString();
        return "Booking: " +
                "\nCustomer Name: " + customerName +
                "\nBooking ID: " + bookingID +
                "\nSeats: " + allSeats;
    }
}
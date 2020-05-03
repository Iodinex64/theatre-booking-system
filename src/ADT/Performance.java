package ADT;

import Utils.LinkedList.LinkedList;

import java.time.LocalDate;

public class Performance {

    public LinkedList<Booking> bookingsList;
    private Show assignedShow;
    private LocalDate assignedDate;
    private boolean timeIsMatinee;

    public Performance(Show assignedShow, LocalDate assignedDate, boolean timeIsMatinee) {
        this.assignedShow = assignedShow;
        this.assignedDate = assignedDate;
        this.timeIsMatinee = timeIsMatinee;
        this.bookingsList = new LinkedList<Booking>();
    }

    @Override
    public String toString() {
        String matineeIndicator;
        if (timeIsMatinee) {
            matineeIndicator = "Matinee";
        } else {
            matineeIndicator = "Evening";
        }
        return "Performance: " +
                "\nShow: " + assignedShow.getTitle() +
                "\nDate: " + assignedDate +
                "\nShow type: " + matineeIndicator;
    }

    public LinkedList getBookingsList() {
        return bookingsList;
    }

    public void setBookingsList(LinkedList bookingsList) {
        this.bookingsList = bookingsList;
    }

    public Show getAssignedShow() {
        return assignedShow;
    }

    public void setAssignedShow(Show assignedShow) {
        this.assignedShow = assignedShow;
    }

    public LocalDate getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(LocalDate assignedDate) {
        this.assignedDate = assignedDate;
    }

    public boolean isTimeIsMatinee() {
        return timeIsMatinee;
    }

    public void setTimeIsMatinee(boolean timeIsMatinee) {
        this.timeIsMatinee = timeIsMatinee;
    }
}

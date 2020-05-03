package ADT;

import Utils.LinkedList.LinkedList;

import java.time.LocalDate;

public class Show {

    public LinkedList<Performance> performanceList;
    private String title;
    private int runningTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private double balconyTicketPrice;
    private double circleTicketPrice;
    private double stallTicketPrice;

    public Show(String title, int runningTime, LocalDate startDate, LocalDate endDate, double balconyTicketPrice, double circleTicketPrice, double stallTicketPrice) {
        this.title = title;
        this.runningTime = runningTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.balconyTicketPrice = balconyTicketPrice;
        this.circleTicketPrice = circleTicketPrice;
        this.stallTicketPrice = stallTicketPrice;
        this.performanceList = new LinkedList<Performance>();
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nLength: " + runningTime + " Minutes" +
                "\nStart Date: " + startDate +
                "\nEnd Date: " + endDate +
                "\nBalcony Ticket Price: €" + balconyTicketPrice +
                "\nCircle Ticket Price: €" + circleTicketPrice +
                "\nStall Ticket Price: €" + stallTicketPrice;
    }

    public String conciseToString() {
        return "\"" + title + "\"";
    }

    public LinkedList getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(LinkedList performanceList) {
        this.performanceList = performanceList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getBalconyTicketPrice() {
        return balconyTicketPrice;
    }

    public void setBalconyTicketPrice(double balconyTicketPrice) {
        this.balconyTicketPrice = balconyTicketPrice;
    }

    public double getCircleTicketPrice() {
        return circleTicketPrice;
    }

    public void setCircleTicketPrice(double circleTicketPrice) {
        this.circleTicketPrice = circleTicketPrice;
    }

    public double getStallTicketPrice() {
        return stallTicketPrice;
    }

    public void setStallTicketPrice(double stallTicketPrice) {
        this.stallTicketPrice = stallTicketPrice;
    }
}

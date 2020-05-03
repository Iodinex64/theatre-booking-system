package Controllers;

import ADT.Booking;
import ADT.Performance;
import ADT.Seat;
import ADT.Show;
import Utils.LinkedList.Node;
import Utils.Main;
import Utils.MyUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddBookingController {

    @FXML
    private ListView performancesList;
    @FXML
    private TextField customerNameField;
    @FXML
    private TextField bookingIDField;
    @FXML
    private GridPane balconyGrid;
    @FXML
    private GridPane circleGrid;
    @FXML
    private GridPane stallGrid;
    @FXML
    private Text warningLabel;

    public void initialize() {
        warningLabel.setOpacity(0);
        populatePerformanceList();
    }

    @FXML
    void UpdateSeatArrangement() {
        //Clear all seats before disabling buttons that are part of
        //Selected performance's booking's seat list.
        ClearAllSeats(balconyGrid);
        ClearAllSeats(circleGrid);
        ClearAllSeats(stallGrid);
        DisableBookedSeats(balconyGrid);
        DisableBookedSeats(circleGrid);
        DisableBookedSeats(stallGrid);
    }

    //Part of Update Seat Arrangement method (DRY programming)
    private void ClearAllSeats(GridPane grid) {
        for (int n = 0; n < grid.getChildren().size(); n++) {
            ToggleButton myToggle = (ToggleButton) grid.getChildren().get(n);
            myToggle.setDisable(false);
        }
    }

    //Part of Update Seat Arrangement method (DRY programming)
    private void DisableBookedSeats(GridPane grid) {
        Performance p = (Performance) performancesList.getSelectionModel().getSelectedItem();
        for (Node i = p.bookingsList.head; i != null; i = i.next) {
            Booking b = (Booking) i.data;
            for (Node j = b.seatList.head; j != null; j = j.next) {
                Seat se = (Seat) j.data;
                String seatName = "" + se.getSeatTier() + se.getSeatNumber();
                for (int n = 0; n < grid.getChildren().size(); n++) {
                    ToggleButton myToggle = (ToggleButton) grid.getChildren().get(n);
                    if (seatName.equals(myToggle.getText())) {
                        myToggle.setDisable(true);
                    }
                }
            }
        }
    }

    //literally filling seat constructor with data from just button name.
    //...i am a mad scientist and must be stopped
    private Seat findButton(GridPane grid, int buttonIndex) {
        ToggleButton buttonObject = (ToggleButton) grid.getChildren().get(buttonIndex);
        String buttonName = ((ToggleButton) grid.getChildren().get(buttonIndex)).getText();
        char seatTier;
        int seatNumber;
        if (buttonObject.isSelected()) {
            seatTier = buttonName.charAt(0);
            if (buttonName.length() > 2) {
                //adding "" makes everything after it an overflow of string. easy way to concat integers, doesn't
                //sum them (had problem with this)
                seatNumber = Integer.parseInt("" + buttonName.charAt(1) + (buttonName.charAt(2)));
            } else {
                seatNumber = Integer.parseInt(Character.toString(buttonName.charAt(1)));
            }
            return new Seat(seatTier, seatNumber);
        }
        return null;
    }

    @FXML
    private void CloseCurrentWindow() {
        performancesList.getScene().getWindow().hide();
    }

    private void AddSeats(Booking myBooking, GridPane grid) {
        for (int i = 0; i < grid.getChildren().size(); i++) {
            Seat currentSeat = findButton(grid, i);
            if (currentSeat != null) {
                myBooking.seatList.AddNode(currentSeat);
                System.out.println(currentSeat);
            }
        }
    }

    @FXML
    void populatePerformanceList() {
        performancesList.getItems().clear();
        if (Main.showList.size() > 0)
            for (Node i = Main.showList.head; i != null; i = i.next) {
                Show s = (Show) i.data;
                for (Node j = s.performanceList.head; j != null; j = j.next) {
                    Performance p = (Performance) j.data;
                    performancesList.getItems().add(p);
                }
            }
    }

    @FXML
    void enterBookingIntoPerformance() {
        if (VerifyData()) {
            Performance p = (Performance) performancesList.getSelectionModel().getSelectedItem();
            Booking myBooking = new Booking(customerNameField.getText(), Integer.parseInt(bookingIDField.getText()), p);
            AddSeats(myBooking, balconyGrid);
            AddSeats(myBooking, circleGrid);
            AddSeats(myBooking, stallGrid);
            p.bookingsList.AddNode(myBooking);
            CloseCurrentWindow();
        } else {
            warningLabel.setOpacity(1);
        }
    }

    @FXML
    boolean VerifyData() {
        boolean isUniqueID = true;
        Performance p = (Performance) performancesList.getSelectionModel().getSelectedItem();
        if (p != null) {
            for (Node i = p.bookingsList.head; i != null; i = i.next) {
                Booking b = (Booking) i.data;
                if (b.getBookingID() == Integer.parseInt(bookingIDField.getText())) {
                    isUniqueID = false;
                }
            }
        }
        return performancesList.getSelectionModel().getSelectedItem() != null && customerNameField.getText() != null
                && MyUtilities.StringIsInt(bookingIDField.getText()) && isUniqueID;
    }
}
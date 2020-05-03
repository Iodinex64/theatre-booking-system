package Controllers;

import Utils.LinkedList.Node;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import ADT.Booking;
import Utils.Main;
import ADT.Performance;
import ADT.Show;

public class CancellationsController {

    @FXML
    private ListView showsList;

    @FXML
    private ListView performancesList;

    @FXML
    private ListView bookingsList;

    @FXML
    void initialize() {
        PopulateListViews();
    }

    @FXML
    void PopulateListViews() {
        showsList.getItems().clear();
        performancesList.getItems().clear();
        bookingsList.getItems().clear();
        if (Main.showList.size() > 0)
            for (Node i = Main.showList.head; i != null; i = i.next) {
                Show s = (Show) i.data;
                showsList.getItems().add(s);
                for (Node j = s.performanceList.head; j != null; j = j.next) {
                    Performance p = (Performance) j.data;
                    performancesList.getItems().add(p);
                    for (Node n = p.bookingsList.head; n != null; n = n.next) {
                        Booking b = (Booking) n.data;
                        bookingsList.getItems().add(b);
                    }
                }
            }
    }

    //Delete selected object by looping through nodes, comparing node objects and getting the object that
    //contains the linked list the object is contained in, then running delete method on that to remove
    //our selected node.
    @FXML
    void DeleteSelected() {
        if (Main.showList.size() > 0) {
            //Delete show
            for (Node i = Main.showList.head; i != null; i = i.next) {
                Show s = (Show) i.data; //current show in loop
                if (showsList.getSelectionModel().getSelectedItem() == s) {
                    Main.showList.DeleteNode(s);
                }
                //Delete performance
                for (Node j = s.performanceList.head; j != null; j = j.next) {
                    Performance p = (Performance) j.data; //current performance in loop
                    if (performancesList.getSelectionModel().getSelectedItem() == p) {
                        p.getAssignedShow().performanceList.DeleteNode(p);
                    }
                    //Delete booking
                    for (Node n = p.bookingsList.head; n != null; n = n.next) {
                        Booking b = (Booking) n.data; //current booking in loop
                        if (bookingsList.getSelectionModel().getSelectedItem() == b) {
                            b.getAssignedPerformance().bookingsList.DeleteNode(b);
                        }
                    }
                }
            }
        }
        PopulateListViews();
    }

}


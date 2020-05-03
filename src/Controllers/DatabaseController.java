package Controllers;

import Utils.LinkedList.Node;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import ADT.Booking;
import Utils.Main;
import ADT.Performance;
import ADT.Show;

public class DatabaseController {

    @FXML
    private Button updateButton;

    @FXML
    private TreeView<String> dataTreeList;

    private TreeItem rootItem = new TreeItem<>("Shows");

    @FXML
    public void initialize() {
        dataTreeList.setEditable(true);
        UpdateData();
    }

    @FXML
        //constructs hierarchical tree list of all data entered
    void UpdateData() {
        rootItem.getChildren().clear();
        dataTreeList.setShowRoot(false);
        if (Main.showList.size() > 0) {
            for (Node i = Main.showList.head; i != null; i = i.next) {
                TreeItem<String> ti;
                TreeItem<String> ti2;
                Show s = (Show) i.data;
                rootItem.getChildren().add(ti = new TreeItem(s.toString()));
                for (Node j = s.performanceList.head; j != null; j = j.next) {
                    Performance p = (Performance) j.data;
                    ti.getChildren().add(ti2 = new TreeItem(p.toString()));
                    for (Node n = p.bookingsList.head; n != null; n = n.next) {
                        Booking b = (Booking) n.data;
                        ti2.getChildren().add(new TreeItem(b.toString()));
                    }
                }
            }
        }
        dataTreeList.setRoot(rootItem);
    }
}
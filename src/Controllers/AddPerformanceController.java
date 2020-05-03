package Controllers;

import Utils.LinkedList.Node;
import Utils.MyUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Utils.Main;
import ADT.Performance;
import ADT.Show;
import javafx.scene.text.Text;

public class AddPerformanceController {

    @FXML
    private ListView showLists;
    @FXML
    private ToggleButton isMatineeButton;
    @FXML
    private DatePicker performanceDatePicker;
    @FXML
    private Text WarningLabel;

    @FXML
    void initialize() {
        WarningLabel.setOpacity(0);
        displayShows();
    }

    @FXML
    private void CloseCurrentWindow() {
        showLists.getScene().getWindow().hide();
    }

    @FXML
    private void displayShows() {
        showLists.getItems().clear();
        if (Main.showList.size() > 0)
            for (Node i = Main.showList.head; i != null; i = i.next) {
                showLists.getItems().add(i.data);
            }
    }

    @FXML
    void EnterPerformanceInfo() {
        if (VerifyData()) {
            Show s = (Show) showLists.getSelectionModel().getSelectedItem();
            Performance myPerformance = new Performance(s,
                    performanceDatePicker.getValue(),
                    isMatineeButton.isSelected());
            s.getPerformanceList().AddNode(myPerformance);
            CloseCurrentWindow();
        } else {
            WarningLabel.setOpacity(1);
        }
    }

    @FXML
    boolean VerifyData() {
        Show s = (Show) showLists.getSelectionModel().getSelectedItem();
        return performanceDatePicker.getValue() != null && showLists.getSelectionModel().getSelectedItem() != null
                && MyUtilities.DateBetween(performanceDatePicker.getValue(), s.getStartDate(), s.getEndDate());
    }
}

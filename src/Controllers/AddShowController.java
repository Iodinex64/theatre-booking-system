package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Utils.Main;
import Utils.MyUtilities;
import ADT.Show;

public class AddShowController {

    @FXML
    private TextField addTitle;
    @FXML
    private TextField addLength;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private TextField balconyPrice;
    @FXML
    private TextField circlePrice;
    @FXML
    private TextField stallsPrice;
    @FXML
    private Label warningLabel;

    public void initialize() {
        warningLabel.setOpacity(0);
    }

    @FXML
    private void CloseCurrentWindow() {
        addTitle.getScene().getWindow().hide();
    }

    @FXML
    void EnterShowInfo() {
        if (VerifyData()) {
            Show myShow = new Show(addTitle.getText(), Integer.parseInt(addLength.getText()),
                    startDate.getValue(), endDate.getValue(), Double.parseDouble(balconyPrice.getText()),
                    Double.parseDouble(circlePrice.getText()), Double.parseDouble(stallsPrice.getText()));
            Main.showList.AddNode(myShow);
            warningLabel.setOpacity(0);
            CloseCurrentWindow();
        } else {
            warningLabel.setOpacity(1);
        }
    }

    @FXML
    boolean VerifyData() {
        return MyUtilities.StringIsInt(addLength.getText()) && MyUtilities.StringIsDouble(balconyPrice.getText())
                && MyUtilities.StringIsDouble(circlePrice.getText()) && MyUtilities.StringIsDouble(stallsPrice.getText())
                && MyUtilities.DateCompare(startDate.getValue(), endDate.getValue());
    }
}
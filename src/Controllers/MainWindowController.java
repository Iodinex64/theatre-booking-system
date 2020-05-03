package Controllers;

import Utils.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import Utils.IO;

public class MainWindowController {

    @FXML
    void initialize() {
        LoadData();
    }

    @FXML
    void OpenAddShowWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/AddShow.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Add A Show");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void OpenAddPerformanceWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/AddPerformance.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Add A Performance");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void OpenDatabaseWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/Database.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Database");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void OpenAddBooking_1Window() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/AddBooking.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Add Booking");
            myStage.setScene(new Scene(root, 600, 730));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void OpenCancellationsWindow() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/Cancellations.fxml"));
            Stage myStage = new Stage();
            myStage.setTitle("Make A Cancellation");
            myStage.setScene(new Scene(root, 600, 400));
            myStage.setResizable(false);
            myStage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void LoadData() {
        try {
            IO input = new IO();
            input.load();
            System.out.println("Loaded successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void SaveData() {
        try {
            IO output = new IO();
            output.save();
            System.out.println("Saved successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void ResetData() {
        Main.showList.Reset();
        System.out.println("All data cleared! Load to restore, or Save to clear permanently.");
    }

}

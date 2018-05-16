package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import sample.Main;

public class RootLayoutController {
    private Main main;

    public void setTest(Test test) {
        this.main = main;
    }
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About");
        alert.setContentText("Author: George Zhevnerov");
        alert.showAndWait();
    }
}

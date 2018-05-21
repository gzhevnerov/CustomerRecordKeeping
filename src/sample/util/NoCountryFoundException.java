package sample.util;

import javafx.scene.control.Alert;

public class NoCountryFoundException extends Exception {
    public void getAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("This country does not exist");
        alert.setContentText("Ooops, there was an error!");
        alert.showAndWait();
        return;
    }
}

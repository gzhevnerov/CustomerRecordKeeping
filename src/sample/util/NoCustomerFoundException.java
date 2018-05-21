package sample.util;

import javafx.scene.control.Alert;

public class NoCustomerFoundException extends Exception {

    public void getAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("This customer id does not exist");
        alert.setContentText("Ooops, there was an error!");
        alert.showAndWait();
        return;
    }
    public void getSecondAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Offer for this customer id does not exist");
        alert.setContentText("Ooops, there was an error!");
        alert.showAndWait();
        return;
    }
}

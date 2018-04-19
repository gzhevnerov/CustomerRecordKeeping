package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.model.Offer;
import sample.util.DBUtil;

import java.io.IOException;

public class MarketingOfferController {
    @FXML
    private Button createOfferButton;
    @FXML
    private AnchorPane offerLayout;
    @FXML
    TextField serviceField;
    @FXML
    TextField offerTypeField;
    @FXML
    TextField statusField;
    @FXML
    TextField sumField;
    @FXML
    Button commitButton;
    @FXML
    TextField customerIdField;


    @FXML
    public void initialize(){
        commitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(serviceField.getText());
                createOffer();
            }
        });
    }
    public void createOffer() {
        Offer offer = new Offer(Integer.parseInt(customerIdField.getText()), serviceField.getText(),offerTypeField.getText(), statusField.getText(),sumField.getText());
        DBUtil dbUtil = new DBUtil();
        dbUtil.createOffer(offer);
    }
}

package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import sample.Main;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;



public class RootLayoutController {
    private Main main;
    public static String GITHUB = "github.com/gzhevnerov/CustomerRecordKeeping";

    public void setTest(Test test) {
        this.main = main;
    }
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    @FXML
    public void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("About");
        alert.setContentText("Delevoper: George Zhevnerov" +
        "\nThe main goal of this app is to help tourist company deal with their clients");
        alert.showAndWait();
    }
}

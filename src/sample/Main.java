package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.controller.CustomerController;

import java.awt.*;
import java.io.IOException;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private Component frame;
    private AnchorPane tableCustomer;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Customer record-keeping");
        Image icon = new Image("sample/view/global.png");
        this.primaryStage.getIcons().add(icon);
        initRootLayout();
        showEmployeeOperationsView();
}

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showEmployeeOperationsView() {
        try {
            CustomerController ec = new CustomerController();
            FXMLLoader loader = new FXMLLoader();
            loader.setController(ec);
            loader.setLocation(Main.class.getResource("view/CustomerView.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();
            rootLayout.setCenter(employeeOperationsView);
            // rootLayout.setBackground();
            ec.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);

    }
}





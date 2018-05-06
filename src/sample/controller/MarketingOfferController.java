package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.model.Employee;
import sample.model.MarketingOfferType;
import sample.model.Offer;
import sample.util.DBUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MarketingOfferController {
    @FXML
    TextField employeeIdField;
    @FXML
    ChoiceBox<MarketingOfferType> offerTypeDropDown;
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
    TextField marketingOfferIdField;
    @FXML
    Button deleteOfferButton;
    @FXML
    Label statusLabel;
    @FXML
    Button updateOfferButton;
    @FXML
    Button tableViewButton;
    @FXML
    TableView offerTableView;
    @FXML
    private ObservableList<Offer> tableData;
    @FXML
    Button activeOfferButton;



    @FXML
    public void initial(){
        commitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(serviceField.getText());
                createOffer();
            }
        });
        deleteOfferButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                deleteOffer();
            }
        });
        updateOfferButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                updateOffer();
            }
        });
        activeOfferButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fillActiveTableView();
            }
        });
        tableViewButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fillTableView();
            }
        });
        ArrayList<MarketingOfferType> marketingOfferTypes = new DBUtil().getAllMarketingOfferTypes();
        offerTypeDropDown.setItems(FXCollections.observableArrayList(marketingOfferTypes));
        offerTypeDropDown.setValue(marketingOfferTypes.get(0));
    }

    public void createOffer() {
        MarketingOfferType marketingOfferType = offerTypeDropDown.getValue();
        System.out.println(offerTypeDropDown.getValue().toString());
        Offer offer = new Offer(serviceField.getText(),offerTypeField.getText(), statusField.getText(),sumField.getText(), marketingOfferType.getMarketingOfferTypeId(), Integer.parseInt(employeeIdField.getText()));
        DBUtil dbUtil = new DBUtil();
        dbUtil.createOffer(offer);
        marketingOfferIdField.clear();
        serviceField.clear();
        offerTypeField.clear();
        statusField.clear();
        sumField.clear();
        statusLabel.setText("Offer was successfully created");
        statusLabel.setTextFill(Color.web("#32CD32"));

    }
    public void deleteOffer() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete confirmation");
        alert.setHeaderText("Delete offer " + marketingOfferIdField.getText() + "?");
        alert.setContentText("Are you sure you want to delete this offer?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Offer offer = new Offer(Integer.parseInt(marketingOfferIdField.getText()));
            DBUtil dbUtil = new DBUtil();
            dbUtil.deleteOffer(offer);
            marketingOfferIdField.clear();
            statusLabel.setText("Offer was successfully deleted");
            statusLabel.setTextFill(Color.web("#FF0000"));
        }
    }
    public void updateOffer() {
        Offer offer = new Offer(Integer.parseInt(marketingOfferIdField.getText()), serviceField.getText(), offerTypeField.getText(), statusField.getText(), sumField.getText(), 1 );
        DBUtil dbUtil = new DBUtil();
        dbUtil.updateOffer(offer);
        statusLabel.setText("Offer was successfully updated");
        statusLabel.setTextFill(Color.web("#FF0000"));
    }
    public void fillTableView() {
        DBUtil dbUtil = new DBUtil();
        ObservableList<Offer> tableData = FXCollections.observableArrayList(dbUtil.getMarketingOffer());
        TableColumn offerIdColumn = new TableColumn("Offer ID");
        TableColumn serviceNameColumn = new TableColumn("Service Name");
        TableColumn offerTypeColumn = new TableColumn("Offer Type");
        TableColumn statusColumn = new TableColumn("Status");
        TableColumn offerSumIdColumn = new TableColumn("Offer Sum");
        TableColumn employeeIdColumn = new TableColumn("Employee ID");
        offerTableView.getColumns().addAll(offerIdColumn,serviceNameColumn,offerTypeColumn,statusColumn,offerSumIdColumn,employeeIdColumn);
        offerIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("marketingOfferId"));
        serviceNameColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("serviceName"));
        offerTypeColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("offerType"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("status"));
        offerSumIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("offerSum"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("employeeId"));
        offerTableView.setItems(tableData);
    }
    public void fillActiveTableView() {
        DBUtil dbUtil = new DBUtil();
        ObservableList<Offer> tableData = FXCollections.observableArrayList(dbUtil.getActiveMarketingOffer());
        TableColumn offerIdColumn = new TableColumn("Offer ID");
        TableColumn serviceNameColumn = new TableColumn("Service Name");
        TableColumn offerTypeColumn = new TableColumn("Offer Type");
        TableColumn statusColumn = new TableColumn("Status");
        TableColumn offerSumIdColumn = new TableColumn("Offer Sum");
        TableColumn employeeIdColumn = new TableColumn("Employee ID");
        offerTableView.getColumns().addAll(offerIdColumn,serviceNameColumn,offerTypeColumn,statusColumn,offerSumIdColumn,employeeIdColumn);
        offerIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("marketingOfferId"));
        serviceNameColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("serviceName"));
        offerTypeColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("offerType"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("status"));
        offerSumIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("offerSum"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("employeeId"));
        offerTableView.setItems(tableData);
    }

}

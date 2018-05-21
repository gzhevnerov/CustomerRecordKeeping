package sample.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import sample.model.Customer;
import sample.model.MarketingOfferType;
import sample.model.Offer;
import sample.util.DBUtil;
import sample.util.NoCustomerFoundException;
import sample.util.NoOfferFoundException;

import java.util.ArrayList;
import java.util.Optional;

public class MarketingOfferController {
    @FXML
    JFXTextField employeeIdField;
    @FXML
    ChoiceBox<MarketingOfferType> offerTypeDropDown;
    @FXML
    private Button createOfferButton;
    @FXML
    private AnchorPane offerLayout;
    @FXML
    JFXTextField serviceField;
    @FXML
    JFXTextField offerTypeField;
    @FXML
    JFXTextField statusField;
    @FXML
    JFXTextField sumField;
    @FXML
    Button commitButton;
    @FXML
    JFXTextField marketingOfferIdField;
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
    Button findButton;
    @FXML
    Button customerIdButton;
    @FXML
    Button clearButton;




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
        findButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                find();
            }
        });
        customerIdButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                findEmloyeeId();
            }
        });
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clear();
            }
        });
        ArrayList<MarketingOfferType> marketingOfferTypes = new DBUtil().getAllMarketingOfferTypes();
        offerTypeDropDown.setItems(FXCollections.observableArrayList(marketingOfferTypes));
        offerTypeDropDown.setValue(marketingOfferTypes.get(0));
    }

    private void find() {
        try {
            DBUtil dbUtil = new DBUtil();
            ArrayList<Offer> offers;
            offers = dbUtil.getMarketingOfferById(Integer.parseInt(marketingOfferIdField.getText()));
            serviceField.setText(offers.get(0).getServiceName());
            offerTypeField.setText(offers.get(0).getOfferType());
            statusField.setText(offers.get(0).getStatus());
            sumField.setText(offers.get(0).getOfferSum());
            statusLabel.setText("Offer was found");
            statusLabel.setTextFill(Color.web("#FF4500"));
        } catch (NoOfferFoundException e) {
            e.printStackTrace();
        }
    }
    private void findEmloyeeId() {
        try {
            DBUtil dbUtil = new DBUtil();
            ArrayList<Offer> offers;
            offers = dbUtil.getMarketingOfferByEmployeeId(Integer.parseInt(employeeIdField.getText()));
            serviceField.setText(offers.get(0).getServiceName());
            offerTypeField.setText(offers.get(0).getOfferType());
            statusField.setText(offers.get(0).getStatus());
            sumField.setText(offers.get(0).getOfferSum());
            statusLabel.setText("Offer was found");
            statusLabel.setTextFill(Color.web("#FF4500"));
        } catch (NoCustomerFoundException e) {
            e.printStackTrace();
        }
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
        offerTableView.getColumns().clear();
        DBUtil dbUtil = new DBUtil();
        ObservableList<Offer> tableData = FXCollections.observableArrayList(dbUtil.getMarketingOffer());
        TableColumn offerIdColumn = new TableColumn("Offer ID");
        TableColumn serviceNameColumn = new TableColumn("Service Name");
        TableColumn offerTypeColumn = new TableColumn("Offer Type");
        TableColumn statusColumn = new TableColumn("Status");
        TableColumn offerSumIdColumn = new TableColumn("Offer Sum");
        TableColumn employeeIdColumn = new TableColumn("Customer ID");
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
        offerTableView.getColumns().clear();
        DBUtil dbUtil = new DBUtil();
        ObservableList<Offer> tableData = FXCollections.observableArrayList(dbUtil.getActiveMarketingOffer());
        TableColumn offerIdColumn = new TableColumn("Offer ID");
        TableColumn serviceNameColumn = new TableColumn("Service Name");
        TableColumn offerTypeColumn = new TableColumn("Offer Type");
        TableColumn statusColumn = new TableColumn("Status");
        TableColumn offerSumIdColumn = new TableColumn("Offer Sum");
        TableColumn employeeIdColumn = new TableColumn("Customer ID");
        offerTableView.getColumns().addAll(offerIdColumn,serviceNameColumn,offerTypeColumn,statusColumn,offerSumIdColumn,employeeIdColumn);
        offerIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("marketingOfferId"));
        serviceNameColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("serviceName"));
        offerTypeColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("offerType"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("status"));
        offerSumIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("offerSum"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("employeeId"));
        offerTableView.setItems(tableData);
    }
    public void updateTableView() {
        offerTableView.getColumns().clear();
        DBUtil dbUtil = new DBUtil();
        ObservableList<Offer> tableData = FXCollections.observableArrayList(dbUtil.getMarketingOffer());
        TableColumn offerIdColumn = new TableColumn("Offer ID");
        TableColumn serviceNameColumn = new TableColumn("Service Name");
        TableColumn offerTypeColumn = new TableColumn("Offer Type");
        TableColumn statusColumn = new TableColumn("Status");
        TableColumn offerSumIdColumn = new TableColumn("Offer Sum");
        TableColumn employeeIdColumn = new TableColumn("Customer ID");
        offerTableView.getColumns().addAll(offerIdColumn,serviceNameColumn,offerTypeColumn,statusColumn,offerSumIdColumn,employeeIdColumn);
        offerIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("marketingOfferId"));
        serviceNameColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("serviceName"));
        offerTypeColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("offerType"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("status"));
        offerSumIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, String>("offerSum"));
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("employeeId"));
        offerTableView.setItems(tableData);
    }
    public void clear() {
        offerTableView.getColumns().clear();
        marketingOfferIdField.clear();
        serviceField.clear();
        offerTypeField.clear();
        statusField.clear();
        sumField.clear();
        employeeIdField.clear();
        statusLabel.setText("Cleared");
        statusLabel.setTextFill(Color.web("#FF0000"));
    }
}

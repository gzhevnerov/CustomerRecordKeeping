package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sample.model.Employee;

public class EmployeesListController {
    private ObservableList<Employee> usersData = FXCollections.observableArrayList();
    @FXML
    private TableView<Employee> tableCustomer;
    @FXML
    private TableColumn<Employee, Integer> idColumn;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, String> surnameColumn;
    @FXML
    private TableColumn<Employee, String> emailColumn;
    @FXML
    private TableColumn<Employee, String> telephoneColumn;
    @FXML
    private TableColumn<Employee, String> qualColumn;
    @FXML
    Button tableViewButton;
    private TableView<Employee> tableView;


    public void initialize() {
        initData();
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("telephone"));
        qualColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("qualification"));
        tableViewButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                initData();
            }
        });
        tableCustomer.setItems(usersData);
    }

    private void initData() {
        usersData.add(new Employee(1, "qwdqd", "qwdqwd","qwdqwd", "qwdq", "qwdqw"));
        usersData.add(new Employee(2, "qwdqd", "qwdqwd","qwdqwd", "qwdq", "qwdqw"));
        usersData.add(new Employee(3, "qwdqd", "qwdqwd","qwdqwd", "qwdq", "qwdqw"));
        usersData.add(new Employee(4, "qwdqd", "qwdqwd","qwdqwd", "qwdq", "qwdqw"));
        usersData.add(new Employee(5, "qwdqd", "qwdqwd","qwdqwd", "qwdq", "qwdqw"));
    }

}



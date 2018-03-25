package sample.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sample.model.Employee;
import sample.util.DBUtil;

import java.util.ArrayList;


public class EmployeeController {
    @FXML
    TextField nameField;
    @FXML
    Button searchButton;
    @FXML
    TextField employeeID;
    @FXML
    TextField surnameField;
    @FXML
    TextField emailField;
    @FXML
    TextField telephoneField;
    @FXML
    Button updateButton;
    @FXML
    TextField operationField;
    @FXML
    Button clearButton;
    @FXML
    Label statusLabel;



    public void init() {
        searchButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                find();
            }
        });

        updateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                updateEmployee();
            }
        });
    }

    private void find() {
        DBUtil dbUtil = new DBUtil();
        ArrayList<Employee> employees;
        if(employeeID.getText().isEmpty()) {
            employees = dbUtil.getEmployeesList();
        } else {
            employees = dbUtil.getEmployeesListByID(Integer.parseInt(employeeID.getText()));
        }
        employeeID.setText(String.valueOf(employees.get(0).getId()));
        nameField.setText(employees.get(0).getName());
        surnameField.setText(employees.get(0).getSurname());
        emailField.setText(employees.get(0).getEmail());
        telephoneField.setText(employees.get(0).getTelephone());
    }

    private void updateEmployee() {
      Employee emp = new Employee(Integer.parseInt(employeeID.getText()), nameField.getText(), surnameField.getText(), emailField.getText(), telephoneField.getText());
      DBUtil dbUtil = new DBUtil();
      dbUtil.updateEmployee(emp);
      employeeID.clear();
      nameField.clear();
      surnameField.clear();
      emailField.clear();
      telephoneField.clear();
      statusLabel.setText("Success");
      statusLabel.setTextFill(Color.web("#ff0000"));
    }
}


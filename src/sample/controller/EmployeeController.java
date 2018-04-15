package sample.controller;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sample.model.Employee;
import sample.util.DBUtil;

import java.awt.*;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    Button updateButton;
    @FXML
    TextField telephoneField;
    @FXML
    Button deleteButton;
    @FXML
    Label statusLabel;
    @FXML
    Button addButton;
    @FXML
    Button clearButton;
    @FXML
    Button tableViewButton;
    @FXML
    CheckBox checkBox;
    @FXML
    TableView<Employee> customersTableView;
    @FXML
    private ObservableList<Employee> tableData = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Employee, Integer>  idColumn;
    @FXML
    private TableColumn<Employee, String>  nameColumn;
    @FXML
    private TableColumn<Employee, String> surnameColumn;
    @FXML
    private TableColumn<Employee, String> emailColumn;
    @FXML
    private TableColumn<Employee, String> telephoneColumn;
    @FXML
    private TableColumn<Employee, String> qualColumn;


    public void init() {

        searchButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { find();
            }
        });

        updateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { updateEmployee();
            }
        });
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { createEmployee();
            }
        });
        deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { deleteEmployee();
            }
        });
        clearButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { clearFields();
            }
        });
        tableViewButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                fillTableView();
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
        if(employeeID.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Fill employee Id field");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
            return;
        }
      Employee emp = new Employee(Integer.parseInt(employeeID.getText()), nameField.getText(), surnameField.getText(), emailField.getText(), telephoneField.getText());
      DBUtil dbUtil = new DBUtil();
      dbUtil.updateEmployee(emp);
      employeeID.clear();
      nameField.clear();
      surnameField.clear();
      emailField.clear();
      telephoneField.clear();
      statusLabel.setText("Employee was updated");
      statusLabel.setTextFill(Color.web("#FF4500"));
    }
    private void createEmployee() {
        List<String> choices = new ArrayList<>();
        List<String> customertype = new ArrayList<>();
        if(nameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Fill name field");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
            return;
        }
        if(surnameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Fill surname field");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
            return;
        }
        if(emailField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Fill email field");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
            return;
        }
        if(telephoneField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Fill telephone field");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
            return;
        }

        choices.add("hot");
        choices.add("warm");
        choices.add("cold");
        customertype.add("ordinary");
        customertype.add("potential");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("warm", choices);
        dialog.setTitle("Customer qualification");
        dialog.setHeaderText("Choose customer qualification");
        dialog.setContentText("Chooses:");
        Optional<String> result = dialog.showAndWait();
        ChoiceDialog<String> type = new ChoiceDialog<>("ordinary", customertype);
        type.setTitle("Customer type");
        type.setHeaderText("Choose customer type");
        type.setContentText("Chooses:");
        Optional<String> resulttype = type.showAndWait();

            Employee emp = new Employee(0,nameField.getText(),surnameField.getText(), emailField.getText(), telephoneField.getText(), result.get(), resulttype.get());
            DBUtil dbUtil = new DBUtil();
            dbUtil.createEmployee(emp);

        nameField.clear();
        surnameField.clear();
        emailField.clear();
        telephoneField.clear();
        statusLabel.setText("Customer was created");
        statusLabel.setTextFill(Color.web("#32CD32"));

    }
    private void deleteEmployee() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete confirmation");
        alert.setHeaderText("Delete id " + employeeID.getText() + "?");
        alert.setContentText("Are you sure you want to delete customer's record?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Employee emp = new Employee(Integer.parseInt(employeeID.getText()));
            DBUtil dbUtil = new DBUtil();
            dbUtil.deleteEmployee(emp);
            employeeID.clear();
            statusLabel.setText("Customer was deleted");
            statusLabel.setTextFill(Color.web("#FF0000"));
        }
    }
    private void clearFields() {
        employeeID.clear();
        nameField.clear();
        surnameField.clear();
        emailField.clear();
        telephoneField.clear();
        statusLabel.setText("Fields were cleared");
        statusLabel.setTextFill(Color.web("#008080"));
    }

   public ObservableList<Employee> getCustomerData() {
    return tableData;
   }


     public void fillTableView() {
        DBUtil dbUtil = new DBUtil();
        ObservableList<Employee> tableData = FXCollections.observableArrayList(dbUtil.getAllCustomers());
        System.out.println(tableData.size());
         TableColumn<Employee, Integer> idColumn = new TableColumn<Employee, Integer>("id");
         TableColumn<Employee, String> nameColumn = new TableColumn<Employee, String>("name");
         TableColumn<Employee, String> surnameColumn = new TableColumn<Employee, String>("surname");
         TableColumn<Employee, String> emailColumn = new TableColumn<Employee, String>("email");
         TableColumn<Employee, String> telephoneColumn = new TableColumn<Employee, String>("telephone");
         TableColumn<Employee, String> qualColumn = new TableColumn<Employee, String>("qualification");
         idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
         nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
         surnameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
         emailColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
         telephoneColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("telephone"));
         qualColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("qualification"));
         customersTableView.setItems(tableData);
     }
}



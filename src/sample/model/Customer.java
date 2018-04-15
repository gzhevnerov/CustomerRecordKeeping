package sample.model;

import javafx.beans.property.*;

public class Customer {

    public SimpleIntegerProperty id = new SimpleIntegerProperty();
    public SimpleStringProperty name = new SimpleStringProperty();
    public SimpleStringProperty surname = new SimpleStringProperty();
    public SimpleStringProperty email = new SimpleStringProperty();
    public SimpleStringProperty telephone = new SimpleStringProperty();
    public SimpleStringProperty qualification = new SimpleStringProperty();

    public void setId(int id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public void setQualification(String qualification) {
        this.qualification.set(qualification);
    }

    public int getId() {

        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public String getTelephone() {
        return telephone.get();
    }

    public SimpleStringProperty telephoneProperty() {
        return telephone;
    }

    public String getQualification() {
        return qualification.get();
    }

    public SimpleStringProperty qualificationProperty() {
        return qualification;
    }

    public Customer(SimpleIntegerProperty id, SimpleStringProperty name, SimpleStringProperty surname, SimpleStringProperty email, SimpleStringProperty telephone, SimpleStringProperty qualification) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.qualification = qualification;
    }
}

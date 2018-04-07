package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty surname;
    private final StringProperty email;
    private final StringProperty telephone;
    private final StringProperty qual;


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

    public void setQual(String qual) {
        this.qual.set(qual);
    }

    public Customer(IntegerProperty id, StringProperty name, StringProperty surname, StringProperty email, StringProperty telephone, StringProperty qual) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.qual = qual;

    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getTelephone() {
        return telephone.get();
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public String getQual() {
        return qual.get();
    }

    public StringProperty qualProperty() {
        return qual;
    }
}

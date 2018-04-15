package sample.model;


import javafx.beans.property.*;

public class Employee {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String telephone;
    private String qualification;
    private String customertype;

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getCustomertype() {
        return customertype;
    }

    public Employee(int id, String name, String surname, String email, String telephone, String qualification, String customertype) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.qualification = qualification;
        this.customertype = customertype;
    }

    public Employee(int id, String name, String surname, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    public Employee(int id, String name, String surname, String email, String telephone, String qualification) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.qualification = qualification;
    }

    public Employee(String name, String surname, String email, String telephone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }


    public Employee(int id) {
        this.id = id;
    }

    public Employee(String qualification) {
        this.qualification = qualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String name) {
        this.name = qualification;
    }

    public int idProperty() {
        return id;
    }

    public String nameProperty() {
        return name;
    }

    public String surnameProperty() {
        return surname;
    }

    public String emailProperty() {
        return email;
    }

    public String telephoneProperty() {
        return telephone;
    }

    public String qualProperty() {
        return qualification;
    }

}


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
    private String country;
    private String customerclass;


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

    public Employee(int id, String name, String surname, String email, String telephone, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.country = country;
    }

    public Employee(int id, String name, String surname, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    public Employee(String name, String surname, String email, String telephone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }

    public String getCustomerclass() {
        return customerclass;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCustomerclass(String customerclass) {
        this.customerclass = customerclass;
    }

    public Employee(int id, String name, String surname, String email, String telephone, String qualification, String customertype, String country, String customerclass) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.qualification = qualification;
        this.customertype = customertype;
        this.country = country;
        this.customerclass = customerclass;
    }
    public Employee(int id, String name, String surname, String country, String email, String telephone, String qualification, String customerclass) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.qualification = qualification;
        this.country = country;
        this.customerclass = customerclass;
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
}


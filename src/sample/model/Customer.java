package sample.model;


import javafx.beans.property.*;

public class Customer {


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", customertype='" + customertype + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Customer(String country) {
        this.country = country;
    }

    public Customer(int id, String name, String surname, String email, String telephone, String customertype, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.country = country;
        this.customertype = customertype;
    }

    private int id;
    private String name;
    private String surname;
    private String email;
    private String telephone;
    private String customertype;
    private String country;


    public Customer(String name, String surname, String email, String telephone, String customertype, String country) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.customertype = customertype;
        this.country = country;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getCustomertype() {
        return customertype;
    }

    public Customer(int id, String name, String surname, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    public Customer(String name, String surname, String email, String telephone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    public Customer(int id, String name, String surname, String email, String telephone, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.country = country;
    }

    public Customer(int id) {
        this.id = id;
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

}


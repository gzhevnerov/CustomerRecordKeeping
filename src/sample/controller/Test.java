package sample.controller;

import sample.model.Customer;
import sample.util.DBUtil;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        ArrayList<Customer> customers = dbUtil.getAllCustomers();
        for(Customer emp : customers) {
            System.out.println(emp.getName());
            System.out.println(emp.getCustomertype());

        }
    }
}

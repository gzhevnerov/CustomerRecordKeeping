package sample.controller;

import sample.model.Employee;
import sample.util.DBUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        ArrayList<Employee> employees = dbUtil.getAllCustomers();
        for(Employee emp : employees) {
            System.out.println(emp.getName());
            System.out.println(emp.getSurname());

        }
    }
}

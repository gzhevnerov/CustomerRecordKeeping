package sample.util;


import sample.model.Customer;
import sample.model.Employee;

import java.sql.*;
import java.util.ArrayList;

public class DBUtil {
    private static final String JDBC_DRIVER = "";
    private static Connection conn = null;
    private static final String connStr = "jdbc:mysql://localhost:3306/database_of_employee?useSSL=false";
    private ResultSet resultSet;
    private ArrayList<Employee> employees;

    public ArrayList<Employee> getEmployeesList() {
        try {
            Connection connection = DriverManager.getConnection(connStr, "java", "password");
            Statement myStat = connection.createStatement();
            resultSet = myStat.executeQuery("SELECT * FROM database_of_employee.employees");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        employees = new ArrayList<>();

        createUsers();
        return employees;
    }

    public ArrayList<Employee> getEmployeesListByID(int employeeID) {
        try {
            Connection connection = DriverManager.getConnection(connStr, "java", "password");
            Statement myStat = connection.createStatement();
            resultSet = myStat.executeQuery("SELECT * FROM database_of_employee.employees WHERE employee_id = " + employeeID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        employees = new ArrayList<>();

        createUsers();
        return employees;
    }

    private void createUsers() {
        try {
            while (resultSet.next()) {
                employees.add(new Employee(resultSet.getInt("employee_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("telephone"),
                        resultSet.getString("qualification")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee emp) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connStr, "java", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "UPDATE database_of_employee.employees SET name = ?, surname = ?, email = ?, telephone = ? where employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getSurname());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getTelephone());
            preparedStatement.setInt(5, emp.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createEmployee(Employee emp) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connStr, "java", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "insert into database_of_employee.employees (name, surname, email, telephone, qualification, customer_type) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getSurname());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getTelephone());
            preparedStatement.setString(5, emp.getQualification());
            preparedStatement.setString(6, emp.getCustomertype());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteEmployee(Employee emp) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connStr, "java", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "delete from database_of_employee.employees where employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, emp.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public ArrayList<Employee> getAllCustomers() {
            ArrayList<Employee> employees = new ArrayList<>();
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(connStr, "java", "password");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String statement = "SELECT * FROM database_of_employee.employees";
            try {
                Statement st = connection.createStatement();
                ResultSet set = st.executeQuery(statement);
                while(set.next()) {
                    employees.add(new Employee(set.getInt("employee_id"),
                            set.getString("name"),
                            set.getString("surname"),
                            set.getString("email"),
                            set.getString("telephone"),
                            set.getString("qualification")));
                }
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return employees;
        }
    }




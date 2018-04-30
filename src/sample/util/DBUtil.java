package sample.util;


import sample.model.Employee;
import sample.model.MarketingOfferType;
import sample.model.Offer;

import java.sql.*;
import java.util.*;

public class DBUtil {
    private static final String JDBC_DRIVER = "";
    private static Connection conn = null;
    private static final String connStr = "jdbc:mysql://localhost:3306/database_of_employee?useSSL=false";
    private ResultSet resultSet;
    private ArrayList<Employee> employees;
    private ArrayList<Offer> offers;

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

    public ArrayList<Offer> getOffersList() {
        try {
            Connection connection = DriverManager.getConnection(connStr, "java", "password");
            Statement myStat = connection.createStatement();
            resultSet = myStat.executeQuery("SELECT * FROM database_of_employee.marketing_offer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        offers = new ArrayList<>();

        createOffers();

        return offers;
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

    private void createOffers() {
        try {
            while (resultSet.next()) {
                offers.add(new Offer(resultSet.getInt("marketing_offer_id"),
                        resultSet.getString("service_name"),
                        resultSet.getString("offer_type"),
                        resultSet.getString("status"),
                        resultSet.getString("offer_sum"),
                        resultSet.getInt("marketing_offer_type_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createUsers() {
        try {
            while (resultSet.next()) {
                employees.add(new Employee(resultSet.getInt("employee_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("telephone"),
                        resultSet.getString("country")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createOffer(Offer offer) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connStr, "java", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "insert into database_of_employee.marketing_offer (marketing_offer_id, service_name, offer_type, status, offer_sum, marketing_offer_type_id, employee_id) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, offer.getMarketingOfferId());
            preparedStatement.setString(2, offer.getServiceName());
            preparedStatement.setString(3, offer.getOfferType());
            preparedStatement.setString(4, offer.getStatus());
            preparedStatement.setString(5, offer.getOfferSum());
            preparedStatement.setInt(6, offer.getMarketingOfferTypeId());
            preparedStatement.setInt(7, offer.getEmployeeId());
            preparedStatement.executeUpdate();
            connection.close();
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
        String statement = "UPDATE database_of_employee.employees SET name = ?, surname = ?, email = ?, telephone = ?, country = ?, customer_class = ? where employee_id = ?";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getSurname());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getTelephone());
            preparedStatement.setString(5, emp.getCountry());
            preparedStatement.setString(6, emp.getCustomerclass());
            preparedStatement.setInt(7, emp.getId());
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
        String statement = "insert into database_of_employee.employees (name, surname, email, telephone, qualification, customer_type, country, customer_class) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getSurname());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getTelephone());
            preparedStatement.setString(5, emp.getQualification());
            preparedStatement.setString(6, emp.getCustomertype());
            preparedStatement.setString(7, emp.getCountry());
            preparedStatement.setString(8, emp.getCustomerclass());
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
        ArrayList<Employee> employees = new ArrayList<Employee>();
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
            while (set.next()) {
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

    public void deleteOffer(Offer offer) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connStr, "java", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "delete from database_of_employee.marketing_offer where marketing_offer_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, offer.getMarketingOfferId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOffer(Offer offer) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connStr, "java", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "UPDATE database_of_employee.marketing_offer SET service_name = ?, offer_type = ?, status = ?, offer_sum = ? where employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, offer.getServiceName());
            preparedStatement.setString(2, offer.getOfferType());
            preparedStatement.setString(3, offer.getStatus());
            preparedStatement.setString(4, offer.getOfferSum());
            preparedStatement.setInt(5, offer.getMarketingOfferId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MarketingOfferType> getAllMarketingOfferTypes() {
        ArrayList<MarketingOfferType> marketingOfferTypes = new ArrayList<MarketingOfferType>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connStr, "java", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "SELECT * FROM database_of_employee.marketing_offer_type";
        try {
            Statement st = connection.createStatement();
            ResultSet set = st.executeQuery(statement);
            while (set.next()) {
                marketingOfferTypes.add(new MarketingOfferType(set.getInt("marketing_offer_type_id"),
                        set.getString("marketing_offer_type_name")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marketingOfferTypes;
    }

    public ArrayList<Offer> getMarketingOffer() {
        ArrayList<Offer> offer = new ArrayList<Offer>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connStr, "java", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "SELECT * FROM database_of_employee.marketing_offer";
        try {
            Statement st = connection.createStatement();
            ResultSet set = st.executeQuery(statement);
            while (set.next()) {
                offer.add(new Offer(set.getInt("marketing_offer_id"),
                        set.getString("service_name"),
                        set.getString("offer_type"),
                        set.getString("status"),
                        set.getString("offer_sum"),
                        set.getInt("employee_id")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offer;
    }
}

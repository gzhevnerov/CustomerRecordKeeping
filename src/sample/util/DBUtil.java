package sample.util;


import sample.model.Customer;
import sample.model.MarketingOfferType;
import sample.model.Offer;

import java.sql.*;
import java.util.*;

public class DBUtil {
    private static final String JDBC_DRIVER = "";
    private static Connection CONN = null;
    private static final String CONN_STR = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7237286?useSSL=false";
    private static final String USER = "sql7237286";
    private static final String PASSWORD = "HzZwQixz9B";
    private ResultSet resultSet;
    private ArrayList<Customer> customers;
    private ArrayList<Offer> offers;

    public ArrayList<Customer> getEmployeesList() {
        try {
            Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
            Statement myStat = connection.createStatement();
            resultSet = myStat.executeQuery("SELECT * FROM sql7237286.employees");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        customers = new ArrayList<>();

        createUsers();
        return customers;
    }

    public ArrayList<Offer> getOffersList() {
        try {
            Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
            Statement myStat = connection.createStatement();
            resultSet = myStat.executeQuery("SELECT * FROM sql7237286.marketing_offer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        offers = new ArrayList<>();
        createOffers();
        return offers;
    }

    public ArrayList<Customer> getEmployeesListByID(int employeeID) throws NoCustomerFoundException {
        try {
            Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
            Statement myStat = connection.createStatement();
            resultSet = myStat.executeQuery("SELECT * FROM sql7237286.employees WHERE employee_id = " + employeeID);
            if(resultSet.next() == false) {
                throw new NoCustomerFoundException();
            }
            resultSet.beforeFirst();
        } catch (NoCustomerFoundException e) {
            e.getAlert();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        customers = new ArrayList<>();
        createUsers();
        return customers;
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
                customers.add(new Customer(resultSet.getInt("employee_id"),
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
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "insert into sql7237286.marketing_offer (marketing_offer_id, service_name, offer_type, status, offer_sum, marketing_offer_type_id, employee_id) values (?, ?, ?, ?, ?, ?, ?)";
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

    public void updateEmployee(Customer emp) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "UPDATE sql7237286.employees SET name = ?, surname = ?, email = ?, telephone = ?, country = ? where employee_id = ?";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getSurname());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getTelephone());
            preparedStatement.setString(5, emp.getCountry());
            preparedStatement.setInt(6, emp.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createEmployee(Customer emp) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "insert into sql7237286.employees (name, surname, email, telephone, customer_type, country) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getSurname());
            preparedStatement.setString(3, emp.getEmail());
            preparedStatement.setString(4, emp.getTelephone());
            preparedStatement.setString(5, emp.getCustomertype());
            preparedStatement.setString(6, emp.getCountry());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Customer emp) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "delete from sql7237286.employees where employee_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setInt(1, emp.getId());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "SELECT * FROM sql7237286.employees";
        try {
            Statement st = connection.createStatement();
            ResultSet set = st.executeQuery(statement);
            while (set.next()) {
                customers.add(new Customer(set.getInt("employee_id"),
                        set.getString("name"),
                        set.getString("surname"),
                        set.getString("email"),
                        set.getString("telephone"),
                        set.getString("customer_type"),
                        set.getString("country")));

            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void deleteOffer(Offer offer) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "delete from sql7237286.marketing_offer where marketing_offer_id = ?";
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
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "UPDATE sql7237286.marketing_offer SET service_name = ?, offer_type = ?, status = ?, offer_sum = ? where employee_id = ?";
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
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "SELECT * FROM sql7237286.marketing_offer_type";
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
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "SELECT * FROM sql7237286.marketing_offer";
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

    public ArrayList<Offer> getActiveMarketingOffer() {
        ArrayList<Offer> offer = new ArrayList<Offer>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "SELECT * FROM sql7237286.marketing_offer where status = 'Active'";
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
    public ArrayList<Customer> getAllCustomersByCountry(String country) throws NoCountryFoundException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            try {
            String statement = "SELECT * FROM sql7237286.employees WHERE country = ?";
            PreparedStatement ps = connection.prepareStatement(statement);
            ps.setObject(1, country);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) {
                throw new NoCountryFoundException();
            } rs.beforeFirst();
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("employee_id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("customer_type"),
                        rs.getString("country")));

            }
            ps.close();
        } catch (NoCountryFoundException e) {
            e.getAlert();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public ArrayList<Customer> getAllCustomersByNameSurname(String name, String surname) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String statement = "SELECT * FROM sql7237286.employees WHERE name = ? AND surname = ?";
            PreparedStatement ps = connection.prepareStatement(statement);
            ps.setObject(1, name);
            ps.setObject(2, surname);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("employee_id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("customer_type"),
                        rs.getString("country")));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public ArrayList<Offer> getMarketingOfferById(int marketingOfferID) throws NoOfferFoundException {
        try {
            Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
            Statement myStat = connection.createStatement();
            resultSet = myStat.executeQuery("SELECT * FROM sql7237286.marketing_offer WHERE marketing_offer_id = " + marketingOfferID);
            if (resultSet.next() == false) {
                throw new NoOfferFoundException();
            } resultSet.beforeFirst();
        } catch (NoOfferFoundException e) {
            e.getAlert();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        offers = new ArrayList<>();
        createOffers();
        return offers;
    }
    public ArrayList<Offer> getMarketingOfferByEmployeeId(int employeeID) throws NoCustomerFoundException {
        try {
            Connection connection = DriverManager.getConnection(CONN_STR, USER, PASSWORD);
            Statement myStat = connection.createStatement();
            resultSet = myStat.executeQuery("SELECT * FROM sql7237286.marketing_offer WHERE employee_id = " + employeeID);
            if (resultSet.next() == false) {
                throw new NoCustomerFoundException();
            }
            resultSet.beforeFirst();
        } catch (NoCustomerFoundException e) {
            e.getAlert();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        offers = new ArrayList<>();
        createOffers();
        return offers;
    }
}

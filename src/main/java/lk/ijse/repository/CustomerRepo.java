package lk.ijse.repository;

import lk.ijse.db.DbConnection;
import lk.ijse.model.Customer;
import lk.ijse.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
   //public static boolean save(Customer customer) throws SQLException {
        public static boolean save(Customer customer) throws SQLException {
            String sql = "INSERT INTO Customer VALUES(?, ?, ?, ?)";

            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, customer.getCustomerId());
            pstm.setObject(2, customer.getName());
            pstm.setObject(3, customer.getAddress());
            pstm.setObject(4, customer.getContact());

            return pstm.executeUpdate() > 0;
        }

    public static Customer searchById(String id) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE customerId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String customerId = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String contact = resultSet.getString(4);
           // String age = resultSet.getString(5);


            Customer customer = new Customer(customerId, name, address, contact);

            return customer;
        }

        return null;
    }

    public static boolean update(Customer customer) throws SQLException {
        String sql = "UPDATE Customer SET name = ?, address = ?, contact = ?  WHERE customerId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject( 1, customer.getName());
        pstm.setObject( 2, customer.getAddress());
        pstm.setObject( 3, customer.getContact());
       // pstm.setObject( 4, customer.getAge());
        pstm.setObject(4, customer.getCustomerId());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Customer WHERE customerId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }



    public static List<String> getIds() throws SQLException {
        String sql = "SELECT CustomerId FROM Customer";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;
    }
    public static List<Customer> getAll() throws SQLException {
        String sql = "SELECT * FROM Customer";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Customer> cusList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String contact = resultSet.getString(4); // Corrected index

            Customer customer = new Customer(id, name, address, contact); // Corrected order
            cusList.add(customer);
        }
        return cusList;
    }
}

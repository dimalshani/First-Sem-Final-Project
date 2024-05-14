package lk.ijse.repository;

import lk.ijse.db.DbConnection;
import lk.ijse.model.Customer;
import lk.ijse.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierRepo {
    public static boolean save(Supplier supplier) throws SQLException {
        String sql = "INSERT INTO Supplier VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, supplier.getSupplierId());
        pstm.setObject(2, supplier.getName());
        pstm.setObject(3, supplier.getLocation());
        pstm.setObject(4, supplier.getContact());

        return pstm.executeUpdate() > 0;
    }

    public static Supplier searchById(String id) throws SQLException {
        String sql = "SELECT * FROM Supplier WHERE supplierId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String supplierId= resultSet.getString(1);
            String name = resultSet.getString(2);
            String location = resultSet.getString(3);
            String contact = resultSet.getString(4);


           Supplier supplier = new Supplier(supplierId, name, location, contact);

            return supplier;
        }

        return null;
    }
    public static boolean update(Supplier supplier) throws SQLException {
        String sql = "UPDATE Supplier SET name = ?, location = ?, contact = ?  WHERE supplierId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject( 1, supplier.getName());
        pstm.setObject( 2, supplier.getLocation());
        pstm.setObject( 3, supplier.getContact());
        pstm.setObject(4, supplier.getSupplierId());

        return pstm.executeUpdate() > 0;
    }
    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Supplier WHERE supplierId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }

    public static List<Supplier> getAll() throws SQLException {
        String sql = "SELECT * FROM Supplier";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Supplier> supList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String location = resultSet.getString(3);
            String contact = resultSet.getString(4);

            Supplier supplier = new Supplier(id, name, location, contact);
            supList.add(supplier);
        }
        return supList;
    }

    public static List<String> getIds() throws SQLException {
        String sql = "SELECT SupplierId FROM Customer";
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
}


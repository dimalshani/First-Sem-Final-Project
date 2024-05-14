package lk.ijse.repository;

import lk.ijse.db.DbConnection;
import lk.ijse.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepo {
    public static boolean save(Item item) throws SQLException {
        String sql = "INSERT INTO Item VALUES(?, ?, ?, ?,?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getItemId());
        pstm.setObject(2, item.getName());
        pstm.setObject(3,item.getQty());
        pstm.setObject(4, item.getPrice());
        pstm.setObject(5, item.getDescription());


        return pstm.executeUpdate() > 0;


    }
    public static Item searchById(String id) throws SQLException {
        String sql = "SELECT * FROM Item WHERE ItemId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String Id = resultSet.getString(1);
            String name = resultSet.getString(2);
            Integer qty = Integer.valueOf(resultSet.getString(3));
            Double price = Double.valueOf(resultSet.getString(4));
            String description = resultSet.getString(5);




            Item item= new Item(Id, name, qty,price,description);

            return item;
        }

        return null;
    }

    public static boolean update(Item item) throws SQLException {
        String sql = "UPDATE Item SET name = ?, qty = ?,price= ?, description=?  WHERE ItemId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, item.getName());
        pstm.setObject(2, item.getQty());
        pstm.setObject(3, item.getPrice());
        pstm.setObject(4, item.getDescription());
        pstm.setObject(5, item.getItemId());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Item WHERE ItemId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }


    public static List<String> getIds() throws SQLException {
        String sql = "SELECT ItemId FROM Item";
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
    public static List<Item> getAll() throws SQLException {
        String sql = "SELECT * FROM Item";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Item> itemList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            Integer qty = Integer.valueOf(resultSet.getString(3));
            Double price = Double.valueOf(resultSet.getString(4));
            String description = resultSet.getString(5);


            Item item = new Item(id, name, qty, price,description); // Corrected order
            itemList.add(item);
        }
        return itemList;
    }


}

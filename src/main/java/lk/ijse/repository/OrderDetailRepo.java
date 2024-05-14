package lk.ijse.repository;

import lk.ijse.db.DbConnection;
import lk.ijse.model.OrderDetails;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailRepo {
    public static boolean save(List<OrderDetails> odList) throws SQLException {
        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        for (OrderDetails od : odList) {
            System.out.println(odList);
            boolean isSaved = save(od);
            if(!isSaved) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(OrderDetails od) throws SQLException {
        String sql = "INSERT INTO OrderDetails VALUES(?, ?, ?, ?)";

        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);


        pstm.setString(1, od.getOrderId());
        pstm.setString(2, od.getItemId());
        pstm.setDouble(3, od.getQty());
        pstm.setDouble(4, od.getUnitPrice());

        return pstm.executeUpdate() > 0;
    }

}

package lk.ijse.repository;

import javafx.scene.control.Alert;
import lk.ijse.db.DbConnection;
import lk.ijse.model.PlaceOrder;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaceOrderRepo {
    public static boolean placeOrder(PlaceOrder po) throws SQLException {
        System.out.println(">>>>> "+po);
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isOrderSaved = OrderRepo.save(po.getOrder());
            System.out.println("order eka save" + po.getOrder());
            if (isOrderSaved) {
                System.out.println("order eka save" + po.getOrderDetailsList());
                boolean isOrderDetailSaved = OrderDetailRepo.save(po.getOrderDetailsList());
                if (isOrderDetailSaved) {
                    connection.commit();
                    return true;
                }
            }
            System.out.println("order eka failed");
            connection.rollback();
            return false;
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }
}

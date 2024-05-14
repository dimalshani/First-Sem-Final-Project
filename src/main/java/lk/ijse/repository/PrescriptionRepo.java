package lk.ijse.repository;

import lk.ijse.db.DbConnection;
import lk.ijse.model.Prescription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PrescriptionRepo {

    public static boolean save(Prescription prescription) throws SQLException {
        String sql = "INSERT INTO Prescription VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, prescription.getPrescriptionId());
        pstm.setObject(2, prescription.getDescription());
        pstm.setObject(3, prescription.getDate());
        pstm.setObject(4, prescription.getNameOfDocter());



        return pstm.executeUpdate() > 0;


    }
    public static boolean update(Prescription prescription) throws SQLException {
        String sql = "UPDATE Prescription SET description = ?, date = ?, nameOfDocter= ? WHERE prescriptionId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, prescription.getDescription());
        pstm.setObject(2, prescription.getDate());
        pstm.setObject(3, prescription.getNameOfDocter());
        pstm.setObject(4, prescription.getPrescriptionId());

        return pstm.executeUpdate() > 0;
    }

    public static Prescription searchById(String id) throws SQLException {
        String sql = "SELECT * FROM Prescription WHERE prescriptionId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String Id = resultSet.getString(1);
            String description = resultSet.getString(2);
            String date = resultSet.getString(3);
            String nameOfDocter= resultSet.getString(4);




            Prescription prescription =new Prescription(Id, description, date,nameOfDocter);

            return prescription;
        }

        return null;
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Prescription WHERE prescriptionId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }




}

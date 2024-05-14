package lk.ijse.repository;

import lk.ijse.db.DbConnection;
import lk.ijse.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    public static boolean save(Employee employee) throws SQLException {
        String sql = "INSERT INTO Employee VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, employee.getEmployeeId());
        pstm.setObject(2, employee.getName());
        pstm.setObject(3, employee.getAddress());
        pstm.setObject(4, employee.getAge());
        //pstm.setObject(4, employee.getAddress());


        return pstm.executeUpdate() > 0;


    }

    public static Employee searchById(String id) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String Id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String age = resultSet.getString(3);
            String address = resultSet.getString(4);




            Employee employee= new Employee(Id, name, age,address);

            return employee;
        }

        return null;
    }

    public static boolean update(Employee employee) throws SQLException {
        String sql = "UPDATE Employee SET name = ?, age = ?,address= ? WHERE id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, employee.getName());
        pstm.setObject(2, employee.getAddress());
        pstm.setObject(3, employee.getAge());
        pstm.setObject(4, employee.getEmployeeId());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM Employee WHERE id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }


    public static List<String> getIds() throws SQLException {
        String sql = "SELECT id FROM Employee";
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
    public static List<Employee> getAll() throws SQLException {
        String sql = "SELECT * FROM Employee";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Employee> empoList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String age = resultSet.getString(4); // Corrected index

            Employee employee = new Employee(id, name, age, address); // Corrected order
            empoList.add(employee);
        }
        return empoList;
    }
}

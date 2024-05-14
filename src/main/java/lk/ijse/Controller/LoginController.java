package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.db.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javafx.fxml.FXMLLoader.load;

public class LoginController {

    @FXML
    private Hyperlink SignUpHyperlink;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtPassword;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtUserId;



    @FXML
    void btnLoginOnAction(ActionEvent event) throws SQLException {
        String userId = txtUserId.getText();
        String pw = txtPassword.getText();

        try {
            checkCredential(userId, pw);
           // checkCredential("U001", "1234");

        } catch (SQLException | IOException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void checkCredential(String userId, String pw) throws SQLException, IOException {
        String sql = "SELECT userId, password FROM Users WHERE userId = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, userId);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            String dbPw = resultSet.getString("password");

            if(pw.equals(dbPw)) {
                navigateToTheDashboard();
            } else {
                new Alert(Alert.AlertType.ERROR, "sorry! password is incorrect!").show();
            }

        } else {
            new Alert(Alert.AlertType.INFORMATION, "sorry! user id can't be find!").show();
        }

    }

    private void navigateToTheDashboard() throws IOException {
        AnchorPane rootNode = load(this.getClass().getResource("/view/dashboard.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard Form");
    }



    @FXML
    void clickedOnHyperlink(ActionEvent event) throws IOException {

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/registerForm.fxml"));

        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Registration Form");
        stage.centerOnScreen();
    }
    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        try {
            btnLoginOnAction(event);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void txtUserIdOnAction(ActionEvent event) {
        txtPassword.requestFocus();

    }

}



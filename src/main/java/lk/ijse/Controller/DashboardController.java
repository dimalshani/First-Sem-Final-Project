package lk.ijse.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class DashboardController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnEmployee;

    @FXML
    private Button btnMedicine;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnPrescription;

    @FXML
    private Button btnSupplier;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane rootNode2;

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        /*AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/customerRegister.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Customer Form");
        stage.centerOnScreen();*/

        try {
            AnchorPane root = FXMLLoader.load(this.getClass().getResource("/view/customerRegister.fxml"));
            rootNode2.getChildren().clear();
            rootNode2.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
      /*  AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/employeeRegister.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Employee Form");
        stage.centerOnScreen();*/

        try {
            AnchorPane root = FXMLLoader.load(this.getClass().getResource("/view/employeeRegister.fxml"));
            rootNode2.getChildren().clear();
            rootNode2.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnPrescriptionOnAction(ActionEvent event) throws IOException {
        /*AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/prescription.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Prescription Form");
        stage.centerOnScreen();*/

        try {
            AnchorPane root = FXMLLoader.load(this.getClass().getResource("/view/prescription.fxml"));
            rootNode2.getChildren().clear();
            rootNode2.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
       /* AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/supplierManage.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Supplier Form");
        stage.centerOnScreen();*/

        try {
            AnchorPane root = FXMLLoader.load(this.getClass().getResource("/view/supplierManage.fxml"));
            rootNode2.getChildren().clear();
            rootNode2.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnOrderOnAction(ActionEvent event) throws IOException {
       /* AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/placeOrder.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Place Order Form");
        stage.centerOnScreen();*/

        try {
            AnchorPane root = FXMLLoader.load(this.getClass().getResource("/view/placeOrder.fxml"));
            rootNode2.getChildren().clear();
            rootNode2.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/loginForm.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Login Form");
        stage.centerOnScreen();

    }
    @FXML
    void btnMedicineOnAction(ActionEvent event) throws IOException {
        /*AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/itemManage.fxml"));
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Supplier Form");
        stage.centerOnScreen();*/

        try {
            AnchorPane root = FXMLLoader.load(this.getClass().getResource("/view/itemManage.fxml"));
            rootNode2.getChildren().clear();
            rootNode2.getChildren().add(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

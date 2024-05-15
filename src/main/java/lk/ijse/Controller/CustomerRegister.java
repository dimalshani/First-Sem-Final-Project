package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.model.Customer;
import lk.ijse.repository.CustomerRepo;
import lk.ijse.repository.EmployeeRepo;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerRegister {


    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private AnchorPane root;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtAddress;


    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtName;

   /* @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }*/


    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();

        try {
            boolean isDeleted = CustomerRepo.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        Customer customer = new Customer(id, name, address, contact);

        try {
            boolean isSaved = CustomerRepo.save(customer);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                // clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        }



    private void clearFields() {
        txtCustomerId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException {
        String id = txtCustomerId.getText();

        Customer customer = CustomerRepo.searchById(id);
        if (customer != null) {
            txtCustomerId.setText(customer.getCustomerId());
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtContact.setText(customer.getContact());
        } else {
            new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtCustomerId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();


        Customer customer = new Customer(id, name, address, contact);

        try {
            boolean isUpdated = CustomerRepo.update(customer);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    @FXML
    void txtAddressOnAction(ActionEvent event) {
        txtContact.requestFocus();

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {


    }

    @FXML
    void txtCustomerIdOnAction(ActionEvent event) {
        txtName.requestFocus();

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtAddress.requestFocus();

    }


    public void initialize() {

        addRegex(txtCustomerId);
       // addRegex(txtName);
        //addRegex(txtAddress);
        addRegex(txtContact);

    }

    private void addRegex(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtCustomerId && !newValue.matches("^C.*$")){
               // new Alert(Alert.AlertType.INFORMATION,"Start with C").show();
                txtCustomerId.setStyle("-fx-focus-color:#f21e0f");
                txtCustomerId.clear();
            }else {
                txtCustomerId.setStyle("-fx-focus-color:#c4c1c0");
            }
        });

//        textField.textProperty().addListener((observable, oldValue, newValue) -> {
//
//            if (textField == txtName && !newValue.matches("^[A-z|\\s]{3,}$")){
//                new Alert(Alert.AlertType.INFORMATION,"First letter should be capital").show();
//                txtName.clear();
//            }
//        });

       /* textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtAddress && !newValue.matches("^[\\w\\s\\.,#\\-\\/]+$")){
                new Alert(Alert.AlertType.INFORMATION,"example- 123 Main Street or Matara").show();
                txtAddress.clear();
            }
        });*/

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtContact && !newValue.matches("^\\+?[0-9\\s-]+$")){
                new Alert(Alert.AlertType.INFORMATION,"example - +765823106 or 0765823106").show();
                txtContact.clear();
            }
        });
    }

    }


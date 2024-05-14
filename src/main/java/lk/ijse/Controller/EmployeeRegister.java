package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.model.Employee;
import lk.ijse.repository.EmployeeRepo;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeRegister {


   // @FXML
    //private Button btnBack;

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
    private TextField txtAge;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtName;



    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtEmployeeId.getText();

        try {
            boolean isDeleted = EmployeeRepo.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String Id = txtEmployeeId.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        String address = txtAddress.getText();


        Employee employee = new Employee(Id, name, age, address);

        try {
            boolean isSaved = EmployeeRepo.save(employee);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee saved!").show();
               // clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException {
        String id = txtEmployeeId.getText();

        Employee employee1 = EmployeeRepo.searchById(id);
        if (employee1 != null) {
            txtEmployeeId.setText(employee1.getEmployeeId());
            txtName.setText(employee1.getName());
            txtAge.setText(employee1.getAge());
            txtAddress.setText(employee1.getAddress());

        } else {
            new Alert(Alert.AlertType.INFORMATION, "employee not found!").show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtEmployeeId.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        String address = txtAddress.getText();

        Employee employee = new Employee(id, name, age, address);

        try {
            boolean isUpdated = EmployeeRepo.update(employee);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "employee updated!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "employee Not updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }


    private void clearFields() {
        txtEmployeeId.setText("");
        txtName.setText("");
        txtAge.setText("");
        txtAddress.setText("");

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {

    }

    @FXML
    void txtAgeOnAction(ActionEvent event) {
        txtAddress.requestFocus();

    }

    @FXML
    void txtEmployeeIdOnAction(ActionEvent event) {
        txtName.requestFocus();

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtAge.requestFocus();

    }


    public void initialize() {

        addRegex(txtEmployeeId);
       // addRegex(txtName);
        addRegex(txtAge);
       // addRegex(txtAddress);

    }

    private void addRegex(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtEmployeeId && !newValue.matches("^E.*$")) {
                new Alert(Alert.AlertType.INFORMATION, "Start with E").show();
                txtEmployeeId.clear();
            }
        });

      /*  textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtName && !newValue.matches("^[A-Za-z]+(?:[\s-][A-Za-z]+)*$")) {
                new Alert(Alert.AlertType.INFORMATION, "First letter should be capital").show();
                txtName.clear();
            }
        });*/

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtAge && !newValue.matches("^(?:1[0-4]?\\d|150|[1-9]?\\d)$")) {
                new Alert(Alert.AlertType.INFORMATION, "example- 6,15,102").show();
                txtAge.clear();
            }
        });

        /*textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtAddress && !newValue.matches("^[\\w\\s\\.,#\\-\\/]+$")) {
                new Alert(Alert.AlertType.INFORMATION, "example- 123 Main Street or Matara").show();
                txtAddress.clear();
            }
        });*/

    }
}

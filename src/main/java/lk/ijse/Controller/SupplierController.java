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
import lk.ijse.model.Supplier;
import lk.ijse.repository.SupplierRepo;

import java.io.IOException;
import java.sql.SQLException;

public class SupplierController {

    //@FXML
  //  private Button btnBack;

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
    private TextField txtContact;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSupplierId;

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
        String id = txtSupplierId.getText();

        try {
            boolean isDeleted = SupplierRepo.delete(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "supplier deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id = txtSupplierId.getText();
        String name = txtName.getText();
        String location = txtLocation.getText();
        String contact = txtContact.getText();



        Supplier supplier = new Supplier(id,name,location,contact);

        try {
            boolean isSaved = SupplierRepo.save(supplier);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "supplier saved!").show();
                //clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void clearFields() {
        txtSupplierId.setText("");
        txtName.setText("");
        txtLocation.setText("");
        txtContact.setText("");

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException {
        String id = txtSupplierId.getText();

        Supplier supplier = SupplierRepo.searchById(id);
        if (supplier != null) {
            txtSupplierId.setText(supplier.getSupplierId());
            txtName.setText(supplier.getName());
            txtLocation.setText(supplier.getLocation());
            txtContact.setText(supplier.getContact());
        } else {
            new Alert(Alert.AlertType.INFORMATION, "supplier not found!").show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtSupplierId.getText();
        String name = txtName.getText();
        String location = txtLocation.getText();
        String contact = txtContact.getText();


        Supplier supplier = new Supplier(id, name, location, contact);

        try {
            boolean isUpdated = SupplierRepo.update(supplier);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "supplier updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    public void initialize() {

        addRegex(txtSupplierId);
        //addRegex(txtName);
        addRegex(txtContact);

    }

    private void addRegex(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtSupplierId && !newValue.matches("^S.*$")){
                new Alert(Alert.AlertType.INFORMATION,"Start with S").show();
                txtSupplierId.clear();
            }
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtContact && !newValue.matches("^\\+?[0-9\\s-]+$")){
                new Alert(Alert.AlertType.INFORMATION,"example - +765823106 or 0765823106").show();
                txtContact.clear();
            }
        });
    }


}

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
import lk.ijse.model.Employee;
import lk.ijse.model.Prescription;
import lk.ijse.repository.CustomerRepo;
import lk.ijse.repository.EmployeeRepo;
import lk.ijse.repository.PrescriptionRepo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class PrescriptionController {

   // @FXML
   // private Button btnBack;

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
    private TextField txtDate;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtNameOfDocter;

    @FXML
    private TextField txtPrescriptionId;

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

    private void clearFields() {
        txtPrescriptionId.setText("");
        txtDescription.setText("");
        txtDate.setText("");
        txtNameOfDocter.setText("");

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String id = txtPrescriptionId.getText();

        try {
            boolean isDeleted = PrescriptionRepo.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "prescription deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        String id = txtPrescriptionId.getText();
        String description = txtDescription.getText();
        String date = txtDate.getText();
        String nameOfDocter = txtNameOfDocter.getText();

        Prescription prescription = new Prescription(id, description, date, nameOfDocter);

        try {
            boolean isSaved = PrescriptionRepo.save(prescription);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "prescription saved!").show();
               // clearFields();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException {
        String id = txtPrescriptionId.getText();

        Prescription prescription = PrescriptionRepo.searchById(id);
        if (prescription != null) {
            txtPrescriptionId.setText(prescription.getPrescriptionId());
            txtDescription.setText(prescription.getDescription());
            txtDate.setText(prescription.getDate());
            txtNameOfDocter.setText(prescription.getNameOfDocter());

        } else {
            new Alert(Alert.AlertType.INFORMATION, "prescription not found!").show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String id = txtPrescriptionId.getText();
        String description = txtDescription.getText();
        String date = txtDate.getText();
        String nameOfDocter = txtNameOfDocter.getText();

        Prescription prescription = new Prescription(id, description, date, nameOfDocter);

        try {
            boolean isUpdated = PrescriptionRepo.update(prescription);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "prescription updated!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "prescription Not updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void initialize() {

        addRegex(txtPrescriptionId);
        addRegex(txtDate);

    }

    private void addRegex(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtPrescriptionId && !newValue.matches("^P.*$")) {
                new Alert(Alert.AlertType.INFORMATION, "Start with P").show();
                txtPrescriptionId.clear();
            }
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtDate && !newValue.matches("\\d{2}/\\d{2}/\\d{4}")) {
                new Alert(Alert.AlertType.INFORMATION, "example - 2024-05-08").show();
                txtDate.clear();
            }
        });


    }
}

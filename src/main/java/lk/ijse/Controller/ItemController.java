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
import lk.ijse.model.Employee;
import lk.ijse.model.Item;
import lk.ijse.repository.EmployeeRepo;
import lk.ijse.repository.ItemRepo;

import java.io.IOException;
import java.sql.SQLException;

public class ItemController {

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
    private TextField txtDescription;

    @FXML
    private TextField txtItemId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;



    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();

    }

    private void clearFields() {
        txtItemId.setText("");
        txtName.setText("");
        txtQty.setText("");
        txtPrice.setText("");
        txtDescription.setText("");

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String id = txtItemId.getText();

        try {
            boolean isDeleted = ItemRepo.delete(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, " deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String Id = txtItemId.getText();
        String name = txtName.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(txtPrice.getText());
        String description = txtDescription.getText();


        Item item = new Item(Id, name, qty, price, description);

        try {
            boolean isSaved = ItemRepo.save(item);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "item saved!").show();
                // clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException {

        String id = txtItemId.getText();

        Item item = ItemRepo.searchById(id);
        if (item != null) {
            txtItemId.setText(item.getItemId());
            txtName.setText(item.getName());
            txtQty.setText(String.valueOf(item.getQty()));
            txtPrice.setText(String.valueOf(item.getPrice()));
            txtDescription.setText(item.getDescription());

        } else {
            new Alert(Alert.AlertType.INFORMATION, "employee not found!").show();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String id = txtItemId.getText();
        String name = txtName.getText();
        Integer qty = Integer.valueOf(txtQty.getText());
        Double price = Double.valueOf(txtPrice.getText());
        String description = txtDescription.getText();

        Item item = new Item(id, name, qty, price, description);

        try {
            boolean isUpdated = ItemRepo.update(item);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "item updated!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "item Not updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    @FXML
    void txtDescriptionOnAction(ActionEvent event) {

    }

    @FXML
    void txtItemIdOnAction(ActionEvent event) {
        txtName.requestFocus();

    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtQty.requestFocus();

    }

    @FXML
    void txtPriceOnAction(ActionEvent event) {
        txtDescription.requestFocus();

    }

    @FXML
    void txtQtyOnAction(ActionEvent event) {
        txtPrice.requestFocus();

    }

}


   /* public void initialize() {

        addRegex(txtItemId);
         addRegex(txtName);
        addRegex(txtQty);
        addRegex(txtPrice);

    }

    private void addRegex(TextField textField) {
       textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtItemId && !newValue.matches("^I.*$")) {
                new Alert(Alert.AlertType.INFORMATION, "Start with I").show();
                txtItemId.clear();
            }
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtName && !newValue.matches("^[A-Za-z]+(?:[\s-][A-Za-z]+)*$")) {
                new Alert(Alert.AlertType.INFORMATION, "First letter should be capital").show();
                txtName.clear();
            }
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtQty && !newValue.matches("^\\d+$")) {
                new Alert(Alert.AlertType.INFORMATION, "example - 1,10,100,1000").show();
                txtQty.clear();
            }
        });

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (textField == txtPrice && !newValue.matches("\\d+(\\.\\d{2})?")); {
                new Alert(Alert.AlertType.INFORMATION, "example - 1,10,100,1000").show();
                txtPrice.clear();
            }
        });




    }
}*/

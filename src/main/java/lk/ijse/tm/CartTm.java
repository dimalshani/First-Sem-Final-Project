package lk.ijse.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CartTm {
    private  String code;
    private String description;
    private int qty;
    private double price;
    private  double total;
    private JFXButton btnRemove;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public JFXButton getBtnRemove() {
        return btnRemove;
    }

    public void setBtnRemove(JFXButton btnRemove) {
        this.btnRemove = btnRemove;
    }

    public CartTm(String code, String description, int qty, double price, double total, JFXButton btnRemove) {
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.price = price;
        this.total = total;
        this.btnRemove = btnRemove;
    }

    @Override
    public String toString() {
        return "CartTm{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", total=" + total +
                ", btnRemove=" + btnRemove +
                '}';
    }
}

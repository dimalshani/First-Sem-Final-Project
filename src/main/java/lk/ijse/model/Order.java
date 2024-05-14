package lk.ijse.model;

import java.util.Date;

public class Order {
    private String orderId;
    private String description;
    private String date;
    private String cid;

    public String getOrderId() {
        return orderId;
    }

    public Order(String orderId, String description, String date, String cid) {
        this.orderId = orderId;
        this.description = description;
        this.date = date;
        this.cid = cid;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}

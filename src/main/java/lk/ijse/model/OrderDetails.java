package lk.ijse.model;

public class OrderDetails {
    private String orderId;
    private String ItemId;
    private Integer Qty;
    private Double unitPrice;

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId='" + orderId + '\'' +
                ", ItemId='" + ItemId + '\'' +
                ", Qty=" + Qty +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public OrderDetails(String orderId, String itemId, Integer qty, Double unitPrice) {
        this.orderId = orderId;
        ItemId = itemId;
        Qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}

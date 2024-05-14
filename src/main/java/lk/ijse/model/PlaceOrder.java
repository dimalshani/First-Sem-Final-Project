package lk.ijse.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PlaceOrder {
    private Order order;
    private List<OrderDetails>orderDetailsList;

    public PlaceOrder(Order order, List<OrderDetails> orderDetailsList) {
        this.order = order;
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "order=" + order +
                ", orderDetailsList=" + orderDetailsList +
                '}';
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}

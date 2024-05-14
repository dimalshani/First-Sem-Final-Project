package lk.ijse.model;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private String paymentId;
    private BigDecimal amount;
    private Date date;
    private String method;
    private String orderId;

    // Constructor
    public Payment(String paymentId, BigDecimal amount, Date date, String method, String orderId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.orderId = orderId;
    }

    // Getters and setters
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", method='" + method + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}


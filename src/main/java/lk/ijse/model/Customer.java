package lk.ijse.model;


import lombok.Data;


public class Customer {
    private String customerId;
    private String name;
    private String address;
    private String contact;
    private String age;
    private String orderId;

    // Constructor
    public Customer(String customerId, String name, String address, String contact) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.age = this.age;
        this.orderId = this.orderId;
    }


    // Getters and setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", age='" + age + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}

package lk.ijse.model;

public class Supplier {
    private String supplierId;
    private String name;
    private String location;
    private String contact;
    private String registrationNum;

    // Constructor
    public Supplier(String supplierId, String name, String location, String contact) {
        this.supplierId = supplierId;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.registrationNum = registrationNum;
    }

    // Getters and setters
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                ", registrationNum='" + registrationNum + '\'' +
                '}';
    }
}

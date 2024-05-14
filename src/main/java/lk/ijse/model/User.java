package lk.ijse.model;

public class User {
    private String registrationNum;
    private String userName;
    private String location;
    private String contact;

    // Constructor
    public User(String registrationNum, String userName, String location, String contact) {
        this.registrationNum = registrationNum;
        this.userName = userName;
        this.location = location;
        this.contact = contact;
    }

    // Getters and setters
    public String getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Override
    public String toString() {
        return "User{" +
                "registrationNum='" + registrationNum + '\'' +
                ", userName='" + userName + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}

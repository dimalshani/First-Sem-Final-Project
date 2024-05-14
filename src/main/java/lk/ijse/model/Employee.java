package lk.ijse.model;

public class Employee {
    private String employeeId;
    private String name;
    private String address;
    private String age;
//    private String educationLevel;
//    private String registrationNum;

    // Constructor
    public Employee(String employeeId, String name, String address, String age) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.age = age;
    }



    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

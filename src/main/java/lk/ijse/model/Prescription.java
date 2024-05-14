package lk.ijse.model;

public class Prescription {
    private String prescriptionId;
    private String description;
    private String date;
    private String nameOfDocter;

    // Constructor
    public Prescription(String prescriptionId, String description, String date, String nameOfDocter) {
        this.prescriptionId = prescriptionId;
        this.description = description;
        this.date = date;
        this.nameOfDocter =nameOfDocter;
    }

    // Getters and setters
    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
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

    public String getNameOfDocter() {
        return nameOfDocter;
    }

    public void setOrderId(String orderId) {
        this.nameOfDocter = nameOfDocter;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId='" + prescriptionId + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", name of docter='" + nameOfDocter + '\'' +
                '}';
    }
}

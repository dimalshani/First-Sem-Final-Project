package lk.ijse.model;

public class ItemSupplierDetails {
    private String medicineId;
    private String supplierId;

    // Constructor
    public ItemSupplierDetails(String medicineId, String supplierId) {
        this.medicineId = medicineId;
        this.supplierId = supplierId;
    }

    // Getters and setters
    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "MedicineSupplierDetails{" +
                "medicineId='" + medicineId + '\'' +
                ", supplierId='" + supplierId + '\'' +
                '}';
    }
}

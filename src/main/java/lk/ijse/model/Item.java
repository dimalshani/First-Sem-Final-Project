package lk.ijse.model;

public class Item {
    private String itemId;
    private String name;
    private int  qty;
    private double price;
    private String description;

    // Constructor
    public Item(String itemId, String name, int qty, double price, String description) {
        this.itemId = itemId;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.description = description;
    }

    // Getters and setters
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = Integer.parseInt(qty);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", qty='" + qty + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

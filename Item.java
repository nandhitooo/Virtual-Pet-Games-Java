public abstract class Item {
    private String itemName;
    private String description;
    private int price;

    public Item(String itemName, String description, int price) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
    }

    public abstract void useItem(Pet pet);

    // Getters
    public String getItemName() {
        return itemName;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return itemName + ": " + description + " (Price: " + price + " coins)";
    }
}

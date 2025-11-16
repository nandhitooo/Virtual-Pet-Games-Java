//Food Class extending Item
public class Food extends Item {
    private int nutrition;
    private String type;

    public Food(String itemName, String description, int price, int nutrition, String type) {
        super(itemName, description, price);
        this.nutrition = nutrition;
        this.type = type;
    }

    @Override
    public void useItem(Pet pet) {
        System.out.println("Feeding " + pet.getName() + " with " + getItemName() + ".");
        pet.feed(nutrition);
    }

    //getter
    public String getType() {
        return type;
    }
}

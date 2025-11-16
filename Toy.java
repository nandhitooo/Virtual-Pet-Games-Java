//Toy Class extending Item
public class Toy extends Item {
    private int funValue;
    private String type;

    public Toy(String itemName, String description, int price, int funValue, String type) {
        super(itemName, description, price);
        this.funValue = funValue;
        this.type = type;
    }

    @Override
    public void useItem(Pet pet) {
        pet.play(funValue);
        if(type.equals(pet.getFavoriteToy())) {
            System.out.println(pet.getName() + " loves playing with their favorite toy: " + getItemName() + "! 🎉");
            pet.setHappiness(pet.getHappiness() + 10);
        }
    }
}

//Medicine Class extending Item
public class Medicine extends Item {
    private int healingPower;

    public Medicine(String itemName, String description, int price, int healingPower) {
        super(itemName, description, price);
        this.healingPower = healingPower;
    }

    @Override
    public void useItem(Pet pet) {
        pet.giveMedicine();
        pet.setHealth(pet.getHealth() + healingPower);
    }
}

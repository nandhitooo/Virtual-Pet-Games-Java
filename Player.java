import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private int coins;
    private List<Item> inventory;
    private Pet pet;
    private int score;

    public Player(String playerName) {
        this.playerName = playerName;
        this.coins = 100; // Starting coins
        this.inventory = new ArrayList<>();
        this.score = 0;
        initializeInventory();
    }

    private void initializeInventory() {
        inventory.add(new Food("Regular Food", "Basic pet food", 10, 20, "Regular"));
        inventory.add(new Food("Premium Food", "High quality food", 25, 40, "Premium"));
        inventory.add(new Toy("Ball", "Bouncy ball", 15, 25, "Ball"));
        inventory.add(new Toy("Chew Toy", "Durable chewing toy", 20, 30, "Chew Toy"));
        inventory.add(new Medicine("Health Potion", "Restores health", 30, 30));
    }

    //assessor methods
    public  void adoptPet(Pet pet) {
        this.pet = pet;
        System.out.println("congratulations " + playerName + "! You have adopted " + pet.getName() + " the " + pet.getSpecies() + "!");
    }

    public void buyItem(Item item) {
        if (coins >= item.getPrice()) {
            coins -= item.getPrice();
            inventory.add(item);
            System.out.println("Purchased " + item.getItemName() + " for " + item.getPrice() + " coins.");
        } else {
            System.out.println("Not enough coins to purchase " + item.getItemName() + ".");
        }
    }

    public void useItem(int index) {
        if(pet == null) {
            System.out.println("You need to adopt a pet first!");
            return;
        }

        if (index >= 0 && index < inventory.size()) {
            Item item = inventory.get(index);
            item.useItem(pet);
            inventory.remove(index);
        } else {
            System.out.println("Invalid item selection.");
        }
    }

    public void showInventory() {
        System.out.println("\n=== " + playerName.toUpperCase() + "'S INVENTORY ===");
        System.out.println("Coins: " + coins);
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                System.out.println((i + 1) + ". " + item.getItemName() + " - " + item.getDescription() + " (Price: " + item.getPrice() + " coins)");
            }
        }
        System.out.println("=========================\n");
    }

    public void updateScore() {
        if(pet != null) {
            score = pet.getHealth() + pet.getHappiness() + pet.getEnergy() + pet.getCleanliness() + (100 - pet.getHunger());
        }
    }

    //getters
    public String getPlayerName() {
        return playerName;
    }
    public int getCoins() {
        return coins;
    }
    public Pet getPet() {
        return pet;
    }
    public int getScore() {
        return score;
    }
    public List<Item> getInventory() {
        return inventory;
    }

    public void addCoins(int amount) {
        this.coins += amount;
    }
}

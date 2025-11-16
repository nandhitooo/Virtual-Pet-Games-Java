import java.util.Random;
import java.util.Scanner;

//Main Logic
public class VirtualPet {
    private Player player;
    private Scanner scanner;
    private Random random;
    private boolean isRunning;
    private int day;

    public VirtualPet() {
        this.player = new Player("Player1");
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.isRunning = true;
        this.day = 1;
    }

    public void start() {
        showWelcome();
        createPlayer();
        selectPet();
        gameLoop();
        endGame();
    }

    private void showWelcome() {
        System.out.println("Welcome to Virtual Pet Simulator!");
        System.out.println("Take care of your pet and have fun!");
    }

    private void createPlayer() {
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        this.player = new Player(playerName);
        System.out.println("Hello, " + playerName + "!");
    }

    public void selectPet() {
        System.out.println("\n=== Select Your Pet ===");
        System.out.println("1. Dog 🐶 - Loyal & Playful");
        System.out.println("2. Cat 🐱 - Independent & Graceful");
        System.out.println("3. Rabbit 🐰 - Curious & Energetic");

        int choice = getChoice(1, 3);
        System.out.println("Give your pet a name: ");
        String petName = scanner.nextLine();

        switch (choice) {
            case 1 -> player.adoptPet(new Dog(petName));
            case 2 -> player.adoptPet(new Cat(petName));
            case 3 -> player.adoptPet(new Rabbit(petName));
        }
    }

    private int getChoice(int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter choice (" + min + "-" + max + "): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }

    private void gameLoop() {
        while (isRunning && player.getPet() != null && player.getPet().getHealth() > 0) {
            player.getPet().showStatus();
            
            showMainMenu();
            int choice = getChoice(1, 7);

            processChoice(choice);

            //random event
            if(random.nextDouble() < 0.3) {
                triggerRandomEvent();
            }

            //update stats
            player.getPet().update();
            player.updateScore();

            //check win condition
            if(player.getPet().getHealth() <= 0) {
                System.out.println("Oh no! " + player.getPet().getName() + " has passed away...");
                break;
            }

            if(day >= 10) {
                System.out.println("Congratulations! You have successfully taken care of your pet for 10 days!");
                break;
            }

            day++;
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Feed Pet");
        System.out.println("2. Play with Pet");
        System.out.println("3. Clean Pet");
        System.out.println("4. Let Pet Sleep");
        System.out.println("5. Use Item");
        System.out.println("6. Show Inventory");
        System.out.println("7. Exit Game");
    }

    private void processChoice(int choice) {
        Pet pet = player.getPet();
        switch (choice) {
            case 1 -> {
                System.out.println("\nFeeding " + pet.getName() + "...");
                pet.feed(25);
            }
            case 2 -> {
                System.out.println("\nPlaying with " + pet.getName() + "...");
                pet.play(20);
                //specifoc reaction for favorite toy
                if(pet instanceof Dog) {
                    ((Dog) pet).bark();
                } else if(pet instanceof Cat) {
                    ((Cat) pet).purr();
                } else if(pet instanceof Rabbit) {
                    ((Rabbit) pet).twitchNose();
                }
            }
            case 3 -> {
                System.out.println("\nCleaning " + pet.getName() + "...");
                pet.clean();
            }
            case 4 -> {
                System.out.println("\nLetting " + pet.getName() + " sleeps...");
                pet.sleep();
            }
            case 5 -> useItemMenu();
            case 6 -> player.showInventory();
            case 7 -> isRunning = false;
        }
    }

    public void useItemMenu() {
        player.showInventory();
        if(!player.getInventory().isEmpty()) {
            System.out.print("Select item number to use (or 0 to cancel): ");
            int choice = getChoice(0, player.getInventory().size());
            if(choice != 0) {
                player.useItem(choice - 1);
            }
        }
    }

    private void triggerRandomEvent() {
        Pet pet = player.getPet();
        int eventType = random.nextInt(4);
        switch (eventType) {
            case 0 -> {
                System.out.println("\n🎁 You found some coins on the ground");
                player.addCoins(20);
            }
            case 1 -> {
                System.out.println("\n🏥 " + pet.getName() + "Doesn't feel weel...");
                pet.setHealth(pet.getHappiness() - 15);
            }
            case 2 -> {
                System.out.println("\n☀ It's a sunny day! " + pet.getName() + " feels more happy!");
                pet.setHappiness(pet.getHappiness() + 15);
            }
            case 3 -> {
                System.out.println("\n🛍️ A traveling merchant offers you a special toy!");
                player.buyItem(new Toy("Magic Ball", "Glowing magical ball", 0, 40, "Magic"));
            }
        }
    }

    private void endGame() {
        System.out.println("\n=== Game Over ===");
        if(player.getPet() != null) {
            System.out.println("Final Stats for " + player.getPet().getName() + ":");
            System.out.println("Days Taken Care Of: " + day);
            player.getPet().showStatus();
        }
        System.out.println("Thank you for playing Virtual Pet Simulator!");
    }
}

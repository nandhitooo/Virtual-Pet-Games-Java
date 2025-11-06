import java.util.ArrayList;
import java.util.List;

public abstract class Pet {
    private String name;
    private String species;
    private int age;
    private int happiness;
    private int hunger;
    private int health;
    private int energy;
    private int cleanliness;
    private List<Need> needs;

    public Pet(String name, String species) {
        this.name = name;
        this.species = species;
        this.age = 0;
        this.happiness = 50;
        this.hunger = 50;
        this.health = 100;
        this.energy = 50;
        this.cleanliness = 70;
        this.needs = new ArrayList<>();
        initializeNeeds();
    }

    public abstract String getSound();
    public abstract String getFavoriteFood();
    public abstract String getFavoriteToy();

    public final void showStatus() {
        System.out.println("\n=== " + name.toUpperCase() + " The " + species.toUpperCase() + " ===");
        System.out.println("Age: " + age + " days");
        System.out.println("Health: " + getHealthStatus());
        System.out.println("Happiness: " + getMeter(happiness));
        System.out.println("Hunger: " + getMeter(hunger));
        System.out.println("Energy: " + getMeter(energy));
        System.out.println("Cleanliness: " + getMeter(cleanliness));
        showSpecialStatus();
        System.out.println("=========================\n");
    }

    protected void showSpecialStatus() {
        // Default implementation does nothing
    }

    private void initializeNeeds() {
        needs.add(new Need("Hunger", 30, 80));
        needs.add(new Need("Happiness", 50, 100));
        needs.add(new Need("Energy", 40, 100));
        needs.add(new Need("Cleanliness", 30, 100));
    }

    //getter
    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    public int getAge() {
        return age;
    }
    public int getHappiness() {
        return happiness;
    }
    public int getHunger() {
        return hunger;
    }
    public int getHealth() {
        return health;
    }
    public int getEnergy() {
        return energy;
    }
    public int getCleanliness() {
        return cleanliness;
    }

    //setter
    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }

    private int clamp(int value) {
        return Math.max(0, Math.min(100, value));
    }

    //behavior
    public void feed(int nutrition) {
        hunger = clamp(hunger - nutrition);
        happiness = clamp(happiness + 5);
        System.out.println(name + " eats happily!" + getSound());
    }
    public void play(int fun) {
        happiness = clamp(happiness + fun);
        energy = clamp(energy - 10);
        hunger = clamp(hunger - 10);
        System.out.println(name + " is playing joyfully!" + getSound());
    }
    public void clean() {
        cleanliness = 100;
        happiness = clamp(happiness + 10);
        System.out.println(name + " is now clean and happy!" + getSound());
    }
    public void sleep() {
        energy = 100;
        health = clamp(health + 5);
        age++;
        System.out.println(name + " is sleeping peacefully..... zzz");
    }
    public void giveMedicine() {
        health = clamp(health + 20);
        happiness = clamp(happiness - 5);
        System.out.println(name + " doesn't like medicine :(");
    }
    public void update() {
        hunger = clamp(hunger + 5);
        energy = clamp(energy - 5);
        cleanliness = clamp(cleanliness - 4);
        happiness = clamp(happiness - 3);

        if(hunger > 80 || cleanliness < 20 || energy < 10) {
            health = clamp(health - 3);
        }
        if(happiness > 70 && health > 70) {
            health = clamp(health + 5);
        }
    }

    public boolean isSick() {
        return health < 30;
    }
    public boolean isVeryHappy() {
        return happiness > 80;
    }
    public boolean needsAttention() {
        return hunger > 70 || cleanliness < 30 || happiness < 30;
    }

    private String getHealthStatus() {
        if (health >= 80) return "💚 Excellent";
        if (health >= 60) return "💛 Good";
        if (health >= 40) return "🟡 Fair";
        if (health >= 20) return "🟠 Poor";
        return "🔴 Critical";
    }
    protected String getMeter(int value) {
        StringBuilder meter = new StringBuilder("[");
        int bars = value / 10;
        for (int i = 0; i < 10; i++) {
            if (i < bars) {
                if (value >= 70) meter.append("█");
                else if (value >= 40) meter.append("▓");
                else meter.append("▒");
            } else {
                meter.append("░");
            }
        }
        meter.append("] ").append(value).append("%");
        return meter.toString();
    }
}

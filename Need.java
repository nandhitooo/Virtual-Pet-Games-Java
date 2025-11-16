//Need Class representing a pet's need
public class Need {
    private String name;
    private int decayRate;
    private int optimalLevel;

    public Need(String name, int decayRate, int optimalLevel) {
        this.name = name;
        this.decayRate = decayRate;
        this.optimalLevel = optimalLevel;
    }

    //getter
    public String getName() {
        return name;
    }
    public int getDecayRate() {
        return decayRate;
    }
    public int getOptimalLevel() {
        return optimalLevel;
    }

    public boolean isCritical(int currentLevel) {
        return currentLevel < 20;
    }

    public boolean isOptimal(int currentLevel) {
        return currentLevel >= optimalLevel;
    }
}

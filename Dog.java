public class Dog extends Pet {
    private int loyalty;

    public Dog(String name) {
        super(name, "Dog");
        this.loyalty = 50; // Initial loyalty
    }

    @Override
    public String getSound() {
        return "Woof! 🐶";
    }

    @Override
    public String getFavoriteFood() {
        return "Bone";
    }

    @Override
    public String getFavoriteToy() {
        return "Ball";
    }

    @Override
    protected void showSpecialStatus() {
        System.out.println("Loyalty: " + getMeter(loyalty));
    }

    public void increaseLoyalty() {
        loyalty = Math.min(100, loyalty + 10);
    }

    public void bark() {
        System.out.println(getName() + " says: " + getSound());
        setHappiness(getHappiness() + 5);
    }

    @Override
    public void play(int fun) {
        super.play(fun + 5);
        increaseLoyalty();
    }
}

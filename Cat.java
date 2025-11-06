public class Cat extends Pet {
    private int independence;

    public Cat(String name) {
        super(name, "Cat");
        this.independence = 70; // Initial independence
    }

    @Override
    public String getSound() {
        return "Meow! 🐱";
    }
    
    @Override
    public String getFavoriteFood() {
        return "Fish";
    }

    @Override
    public String getFavoriteToy() {
        return "Yarn Ball";
    }

    @Override
    protected void showSpecialStatus() {
        System.out.println("Independence: " + getMeter(independence));
    }

    public void purr() {
        System.out.println(getName() + " purrs softly.....😸");
        setHappiness(getHappiness() + 5);
    }

    @Override
    public void play(int fun) {
        super.play(fun + 5);
        independence = Math.min(100, independence + 5);
    }
}
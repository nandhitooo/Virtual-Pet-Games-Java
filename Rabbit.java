public class Rabbit extends Pet {
    private int curiousity;

    public Rabbit(String name) {
        super(name, "Rabbit");
        this.curiousity = 60; // Initial curiousity
    }

    @Override
    public String getSound() {
        return "*Quiet sniffing* 🐇";
    }

    @Override
    public String getFavoriteFood() {
        return "Carrot";
    }

    @Override
    public String getFavoriteToy() {
        return "Tunnel";
    }

    @Override
    protected void showSpecialStatus() {
        System.out.println("Curiousity: " + getMeter(curiousity));
    }

    public void twitchNose() {
        System.out.println(getName() + " twitches its nose curiously.....🐰");
        setHappiness(getHappiness() + 5);
    }
}

package homework5_6;

public abstract class WildAnimal extends Animal {

    private boolean isPredator;

    public WildAnimal() {}

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    @Override
    public String voice() {
        return "Hello, I am a wild animal" + (isPredator ? " and I am angry" : "");
    }
}

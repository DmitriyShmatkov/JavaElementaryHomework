package homework5;

public abstract class Pet extends Animal {
    private String name;
    private boolean isVaccinated;

    public Pet() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    @Override
    public String voice() {
        return "Hello," + (name != null ? " my name is " + name : "");
    }
}

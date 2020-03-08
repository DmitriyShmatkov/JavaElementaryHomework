package homework5;

public class GuideDog extends Dog implements Guideable {

    private boolean isTrained;

    public GuideDog() {}

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    @Override
    public String takeHome() {
        return "A guide-dog have taken you home";
    }

    @Override
    public String voice() {
        return super.voice() + (isTrained ? " and I can take you home" : "");
    }
}

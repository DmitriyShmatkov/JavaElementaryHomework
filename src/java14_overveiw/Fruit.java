package java14_overveiw;

public record Fruit(FruitType type, double kg, double price) {

    public static void main(String[] args) {

        for (FruitType fruitType : FruitType.values()) {
            switch (fruitType) {
                case APPLE -> System.out.println("Apple");
                case ORANGE -> System.out.println("Orange");
                case BANANA -> System.out.println("Banana");
                default -> System.out.println("Other");
            }
        }
    }
}

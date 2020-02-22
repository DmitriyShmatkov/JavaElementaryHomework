package homework4;

import static auxiliary.Functions.*;

public class Main {

    final static double FUEL_PRICE = 28;
//    Distance in kilometers, according to https://della.ua/distance
    final static int ODESSA_KRIVOYE_OZERO = 179;
    final static int KRIVOYE_OZERO_ZHASHKOV = 155;
    final static int ZHASHKOV_KIEV = 150;

    public static void main(String[] args) {

        double fuelTankVolume;
        double fuelRemaining;
        double fuelConsumptionPer100km;

        System.out.println("\nEnter fuel tank volume");
        fuelTankVolume = enterPositiveNumber();

        while (true) {
            System.out.println("Enter remaining amount of fuel");
            fuelRemaining = enterNumber();
            if (fuelRemaining < 0) {
                System.err.println("Please, enter non-negative value");
                continue;
            }
            if (fuelTankVolume < fuelRemaining) {
                System.err.println("Remaining fuel amount is greater than fuel tank volume");
                System.err.println("Please, try again");
                continue;
            }
            break;
        }
        System.out.println("Enter fuel consumption per 100 km");
        fuelConsumptionPer100km = enterPositiveNumber();

        Car car = new Car(fuelTankVolume, fuelRemaining, fuelConsumptionPer100km);

        double fuelExpended = 0;
        double fuelExpendedTotal = 0;
        double fuelBought = 0;

        System.out.println("\n\tOdessa - Krivoye Ozero");
        try {
            fuelExpendedTotal = tryToGo(car, ODESSA_KRIVOYE_OZERO, fuelExpendedTotal);
        } catch (NegativeFuelRemainingException e) {
            System.err.println("Error: can't reach destination");
        }

        System.out.println("\n\tKrivoye Ozero - Zhashkov");
        try {
            fuelExpendedTotal = tryToGo(car, KRIVOYE_OZERO_ZHASHKOV, fuelExpendedTotal);
        } catch (NegativeFuelRemainingException e) {
            System.err.println("Error: can't reach destination");
        }

        System.out.println("\n\tZhashkov - Kiev");
        try {
            fuelExpendedTotal = tryToGo(car, ZHASHKOV_KIEV, fuelExpendedTotal);
        } catch (NegativeFuelRemainingException e) {
            System.err.println("Error: can't reach destination");
        }

        System.out.println("\nFuel expended total: " + setPrecision(fuelExpendedTotal, 2) + " L");
        System.out.println("Trip price: " + setPrecision(fuelExpendedTotal * FUEL_PRICE, 2) + " UAH");
        System.out.println("Fuel left: " + setPrecision(car.getFuelRemaining(), 2) + " L");
    }

    public static double tryToGo(Car car, double km, double fuelExpendedTotal) {
        double fuelExpended = 0;
        double fuelBought = 0;

        if (car.calculateMissingFuel(km) == 0) {
            fuelExpended += car.go(km);
        } else {
            fuelBought = car.fillFuelTank();
            fuelExpended = car.go(km);
        }
        fuelExpendedTotal += fuelExpended;

        System.out.println("Fuel expended: " + setPrecision(fuelExpended, 2) + " L");
        System.out.println("Fuel bought: " + setPrecision(fuelBought, 2) + " L");
        System.out.println("Money spent: " + setPrecision(fuelBought * FUEL_PRICE, 2) + " UAH");
        System.out.println("Fuel remaining: " + setPrecision(car.getFuelRemaining(), 2) + " L");

        return fuelExpendedTotal;
    }
}

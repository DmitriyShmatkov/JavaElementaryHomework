package homework4;

import java.math.BigDecimal;

public class Car {

    private double fuelTankVolume;
    private double fuelRemaining;
    private double fuelConsumptionPer100km;

    public Car(double fuelTankVolume, double fuelRemaining, double fuelConsumptionPer100km) {
        if (fuelTankVolume <= 0) {
            throw new IllegalArgumentException("Non-positive fuelTankVolume value");
        }
        if (fuelRemaining < 0) {
            throw new NegativeFuelRemainingException();
        } else if (fuelRemaining > fuelTankVolume) {
            throw new IllegalArgumentException("fuelRemaining value is greater than fuelTankVolume value");
        }
        if (fuelConsumptionPer100km <= 0) {
            throw new IllegalArgumentException("Non-positive fuelConsumptionPer100km value");
        }
        this.fuelTankVolume = fuelTankVolume;
        this.fuelRemaining = fuelRemaining;
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
    }

    public double getFuelTankVolume() {
        return fuelTankVolume;
    }

    public void setFuelTankVolume(double fuelTankVolume) {
        this.fuelTankVolume = fuelTankVolume;
    }

    public double getFuelRemaining() {
        return fuelRemaining;
    }

    public void setFuelRemaining(double fuelRemaining) {
        this.fuelRemaining = fuelRemaining;
    }

    public double getFuelConsumptionPer100km() {
        return fuelConsumptionPer100km;
    }

    public void setFuelConsumptionPer100km(double fuelConsumptionPer100km) {
        this.fuelConsumptionPer100km = fuelConsumptionPer100km;
    }

    public double fillFuelTank() {
        if (fuelRemaining == 0) {
            fuelRemaining = fuelTankVolume;
            return fuelTankVolume;
        }
        if (fuelRemaining == fuelTankVolume) {
            return 0;
        }
        double neededFuel = fuelTankVolume - fuelRemaining;
        fuelRemaining = fuelTankVolume;
        return neededFuel;
    }

    public double calculateRemaining(double km) {
        if (km < 0) {
            throw new IllegalArgumentException("Negative distance value");
        }
        if (km == 0) {
            return fuelRemaining;
        }
        double newFuelRemaining = fuelRemaining - fuelConsumptionPer100km / 100 * km;
        if (newFuelRemaining < 0) {
            throw new NegativeFuelRemainingException("Isn't enough fuel to cover the distance");
        }
        return newFuelRemaining;
    }

    public double calculateMissingFuel(double km) {
        try {
            return calculateRemaining(km) * 0; // If method returns a result, it means that fuel is enough
        } catch (NegativeFuelRemainingException e) {
            return fuelConsumptionPer100km / 100 * km - fuelRemaining; // If fuel isn't enough, then calculate missing
        }
    }

    public double go(double km) {
        double newFuelRemaining = calculateRemaining(km);
        double fuelExpended = fuelRemaining - newFuelRemaining;
        fuelRemaining = newFuelRemaining;
        return fuelExpended;
    }
}

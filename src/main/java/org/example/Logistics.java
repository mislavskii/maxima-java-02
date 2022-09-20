package org.example;

public class Logistics {
    private Transport[] vehicles;

    public Logistics(Transport... vehicles) {
        this.vehicles = vehicles;
    }

    public Transport[] getVehicles() {
        return vehicles;
    }

    public Transport getShipping (City city, int weight, int hours) {
        Transport bestVehicle = null;
        float bestPrice = 0;
        int startIndex = 0;
        for (int i=0; i < vehicles.length; i++) {
            float totalPrice = getTotalPrice(vehicles[i], city, weight, hours);
            if (totalPrice > 0) {
                bestPrice = totalPrice;
                bestVehicle = vehicles[i];
                startIndex = i + 1;
                break;
            }
        }
        if (startIndex < vehicles.length - 1) {
            for (Transport vehicle : java.util.Arrays.copyOfRange(vehicles, startIndex, vehicles.length - 1)) {
                float totalPrice = getTotalPrice(vehicle, city, weight, hours);
                if (totalPrice > 0 && totalPrice < bestPrice) {
                    bestPrice = totalPrice;
                    bestVehicle = vehicle;
                }
            }
        }
        return bestVehicle;
    }

    public float getTotalPrice (Transport vehicle, City city, int weight, int hours) {
        float pricePerRun = vehicle.getPrice(city);
        if (pricePerRun == 0) { return 0; }
        int runs = divide(weight, vehicle.getCapacity());
        int totalDistance = runs * city.getDistanceKm();
        int requiredTime = divide(totalDistance, vehicle.getSpeed());
        if (requiredTime <= hours) {
            return pricePerRun * runs;
        }
        return 0;
    }

    int divide (int a, int b) {
        int result = a / b;
        if (a % b > 0) {result += 1;}
        return result;
    }

}

package org.example;

public class TransportFactory {
    private String TRUCK_NAME = "Globetrotter";
    private float TRUCK_COST_OF_KM = 23;
    private String SHIP_NAME = "Maelstrom";
    private float SHIP_COST_OF_KM = 420;
    private String PLANE_NAME = "Thunderbolt";
    private float PLANE_COST_OF_KM = 5400;

    public Transport getTransport(City city, int weight, int hours) {
        int requiredSpeed = city.getDistanceKm() / hours;
        System.out.println(requiredSpeed);
        int transportSpeed;
        if (requiredSpeed % 10 != 0) {
            transportSpeed = requiredSpeed / 10 * 10 + 10;
        } else {
            transportSpeed = requiredSpeed;
        }
        int transportCapacity;
        if (weight % 500 != 0) {
            transportCapacity = weight / 500 * 500 + 500;
        } else {
            transportCapacity = weight;
        }
        if (requiredSpeed < 40 && city.isOnWater()) {
            return new Ship (SHIP_NAME, transportCapacity, transportSpeed, SHIP_COST_OF_KM);
        } else if (requiredSpeed > 120 && city.hasAirport()) {
            return new Plane(PLANE_NAME, transportCapacity, transportSpeed, PLANE_COST_OF_KM);
        } else {
            return new Truck(TRUCK_NAME, transportCapacity, transportSpeed, TRUCK_COST_OF_KM);
        }
    }

}

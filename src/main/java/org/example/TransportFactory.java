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
        if (requiredSpeed % 10 != 0) {
            requiredSpeed = requiredSpeed / 10 + 10;
        }
        int requiredCapacity;
        if (weight % 500 != 0) {
            requiredCapacity = weight / 500 + 500;
        } else {
            requiredCapacity = weight;
        }
        if (requiredSpeed < 40 && city.isOnWater()) {
            return new Ship (SHIP_NAME, requiredCapacity, requiredSpeed, SHIP_COST_OF_KM);
        } else if (requiredSpeed > 120 && city.hasAirport()) {
            return new Plane(PLANE_NAME, requiredCapacity, requiredSpeed, PLANE_COST_OF_KM);
        } else {
            return new Truck(TRUCK_NAME, requiredCapacity, requiredSpeed, TRUCK_COST_OF_KM);
        }
    }

}

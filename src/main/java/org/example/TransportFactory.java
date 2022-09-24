package org.example;

public class TransportFactory {
    private static String TRUCK_NAME = "Globetrotter";
    private static float TRUCK_COST_OF_KM = 23;
    private static String SHIP_NAME = "Maelstrom";
    private static float SHIP_COST_OF_KM = 420;
    private static String PLANE_NAME = "Thunderbolt";
    private static float PLANE_COST_OF_KM = 5400;

    public static Transport getTransport(City city, int weight, int hours) {
        float requiredSpeed = (float) city.getDistanceKm() / hours;
        int transportSpeed = requiredSpeed % 10 == 0 ? (int) requiredSpeed : (int) requiredSpeed / 10 * 10 + 10;
        int transportCapacity = weight % 500 == 0 ? weight : weight / 500 * 500 + 500;
        if (requiredSpeed < 40 && city.isOnWater()) {
            return new Ship(SHIP_NAME, transportCapacity, transportSpeed, SHIP_COST_OF_KM);
        }
        if (requiredSpeed > 120 && city.hasAirport()) {
            return new Plane(PLANE_NAME, transportCapacity, transportSpeed, PLANE_COST_OF_KM);
        }
        return new Truck(TRUCK_NAME, transportCapacity, transportSpeed, TRUCK_COST_OF_KM);
    }

}

package org.example;

public class Plane extends Transport{
    public Plane(String name, int capacity, int speed, float costOfKm) {
        super(name, capacity, speed, costOfKm);
    }

    public float getPrice(City city) {
        if (!city.hasAirport()) {
            return 0;
        }
        return city.getDistanceKm() * this.getCostOfKm();
    }
}

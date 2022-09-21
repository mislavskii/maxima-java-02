package org.example;

public abstract class Transport implements Repairable {
    private String name;
    private int capacity;
    private int speed;
    private float costOfKm;
    private boolean isRepairing;

    public Transport (String name, int capacity,
                     int speed, float costOfKm) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.costOfKm = costOfKm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getCostOfKm() {
        return costOfKm;
    }

    public void setCostOfKm(float costOfKm) {
        this.costOfKm = costOfKm;
    }

    public abstract float getPrice(City city);

    public float getTime(City city) {
        if ( this.getPrice(city) != 0 ) { return  (float) city.getDistanceKm() / this.getSpeed(); }
        return 0;
    }

    @Override
    public boolean isRepairing() { return isRepairing; }

    public void startRepair() { this.isRepairing = true; }

    public void finishRepair() { this.isRepairing = false; }

}

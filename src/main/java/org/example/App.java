package org.example;

public class App {
    public static void main( String[] args ) {

        City barnaul = new City("Барнаул", 258);
        City ulgiy = new City("Улгий", 630);
        City n_kuznetsk = new City("Новокузнецк", 360);

        City[] cities = {barnaul, ulgiy, n_kuznetsk};

        for (City city : cities) {
            System.out.println(city.getName()
                    + ": " + city.getDistanceKm() + " км");
        }
        System.out.println();

        Transport gazelle = new Transport(
                "Газель", 2, 130, 15
        );
        Transport bychok = new Transport(
                "Бычок", 3, 110, 18
        );
        Transport kamaz = new Transport(
                "Камаз", 10, 90, 27
        );

        Transport[] transports = {gazelle, bychok, kamaz};

        for (Transport transport : transports) {
            System.out.println(transport.getName() + ": " +
                    transport.getCapacity() + " т; " +
                    transport.getSpeed() + " км/ч; " +
                    transport.getCostOfKm() + " руб/км."
            );
        }
    }
}

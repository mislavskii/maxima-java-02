package org.example;

public class App {
    public static void main( String[] args ) {

        City barnaul = new City("<fhyfek", 258);
        City ulgiy = new City("Улгий", 630, true, false);
        City n_kuznetsk = new City("Новокузнецк", 360);

        barnaul.setName("Барнаул");
        barnaul.setDistanceKm(260);

        n_kuznetsk.setHasAirport(true);
        n_kuznetsk.setOnWater(false);

        Ship barge = new Ship("Баржа", 35, 10, 350);
        Plane antei = new Plane("Антей", 77, 770, 4200);

        City[] cities = {barnaul, ulgiy, n_kuznetsk};

        for (City city : cities) {
            System.out.println(city.getName() + ": " + "аэропорт - " + city.hasAirport() + ", "
            + "на воде - " + city.isOnWater() + ".");
            System.out.println(barge.getName() + " to " + city.getName() + " = "
            + barge.getPrice(city) + " р.");
            System.out.println(antei.getName() + " to " + city.getName() + " = "
                    + antei.getPrice(city) + " р.");
            System.out.println();
        }
        System.out.println();

        Truck gazelle = new Truck("Ufptkm", 2, 130, 15);
        Truck bychok = new Truck("Бычок", 3, 110, 18);
        Truck kamaz = new Truck("Камаз", 10, 90, 27);

        Truck[] trucks = {gazelle, bychok, kamaz};

        gazelle.setName("Газель");
        kamaz.setCapacity(11);
        kamaz.setSpeed(80);
        kamaz.setCostOfKm(kamaz.getCostOfKm() - 1);


        for (Truck transport : trucks) {
            System.out.println(
                    transport.getName() + ": " + transport.getCapacity() + " т; "
                    + transport.getSpeed() + " км/ч; " + transport.getCostOfKm() + " руб/км."
            );
        }
        System.out.println();

        for (City city : cities) {
            System.out.println("в " + city.getName() + " (" + city.getDistanceKm() + " км)" + ":");
            for (Truck transport : trucks) {
                System.out.println(transport.getName() + " - " + transport.getPrice(city) + "0 р.");
            }
            System.out.println();
        }
    }
}

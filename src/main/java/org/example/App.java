package org.example;

// TODO:
// + Запретить создание экземпляров класса Transport, метод getPrice сделать абстрактным.
// + Описать класс Logistics, при создании которого мы будем передавать ему некоторое количество
// + объектов класса Transport, заполняя свойство vehicles.
// + Описать методы Transport getShipping(City city, int weight, int time) - найти самое оптимальное
// + по стоимости доставки транспортное средство.
// + Необходимо учесть грузоподъемность и необходимость доставки в указанный срок,
// + для определения возможности перевозки описать метод isShippingAvailable()
// + Описать Интерфейс Repairable с методами void startRepair(), void finishRepair(), boolean isRepairing().
// + Все виды транспорта должны реализовывать этот интерфейс.
// + В классе Logistics учесть состояние транспортного средства при расчете грузоперевозок.

public class App {

    public static void main(String[] args) {

        City barnaul = new City("<fhyfek", 258);
        City ulgiy = new City("Улгий", 630, true, false);
        City n_kuznetsk = new City("Новокузнецк", 360);
        City tokio = new City ("Tokio", 4900, true, true);

        barnaul.setName("Барнаул");
        barnaul.setDistanceKm(260);

        n_kuznetsk.setHasAirport(true);
        n_kuznetsk.setOnWater(false);

        Ship barge = new Ship("Баржа", 35, 10, 350);
        Plane antei = new Plane("Антей", 77, 770, 4200);

        City[] cities = {barnaul, ulgiy, n_kuznetsk, tokio};

        for (City city : cities) {
            System.out.println(city.getName() + ": " + "аэропорт - " + city.hasAirport() + ", "
                    + "на воде - " + city.isOnWater() + ".");
        }
        System.out.println();

        Truck gazelle = new Truck("Ufptkm", 2, 130, 15);
        Truck bychok = new Truck("Бычок", 3, 110, 18);
        Truck kamaz = new Truck("Камаз", 10, 90, 27);

        Transport[] vehicles = {gazelle, bychok, kamaz, barge, antei};

        vehicles[0].setName("Газель");
        kamaz.setCapacity(11);
        kamaz.setSpeed(80);
        kamaz.setCostOfKm(kamaz.getCostOfKm() - 1);

        for (Transport vehicle : vehicles) {
            System.out.println(
                    vehicle.getName() + ": " + vehicle.getCapacity() + " т; "
                            + vehicle.getSpeed() + " км/ч; " + vehicle.getCostOfKm() + " руб/км."
            );
        }
        System.out.println();

        for (City city : cities) {
            System.out.println("в " + city.getName() + " (" + city.getDistanceKm() + " км)" + ":");
            for (Transport transport : vehicles) {
                System.out.println(transport.getName() + " - " + transport.getPrice(city) + "0 р.; "
                + transport.getTime(city) + " ч.");
            }
            System.out.println();
        }

        barge.startRepair();
        barge.finishRepair();

        // failed test recreation
        Ship boat = new Ship("Boat", 15000, 30, 25F);
        Plane zeppelin = new Plane("Zeppelin", 5000, 250, 200F);
        Truck wagon = new Truck("Wagon", 3500, 90, 55.5F);
        Logistics logistics = new Logistics(boat, zeppelin, wagon);
        Transport bestVehicle = logistics.getShipping(tokio, 2000, 350);
        if (bestVehicle != null) {
            System.out.println("Отправляем " + bestVehicle.getName());
        } else {
            System.out.println("Перевозка невозможна");
        }


    }

}

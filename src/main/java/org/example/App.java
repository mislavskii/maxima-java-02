package org.example;

// TODO:
// Реализация паттерна Фабрика
// Задача:
// Описать класс TransportFactory с методом Transport getTransport(City city, int weight, int hours)
// который будет в зависимости от города, веса и срока доставки конструировать нам транспортное средство по следующим правилам:
// Название и стоимость — для самолета, корабля и грузовика различные константы, выберите из сами, задайте их в начале метода.
// Если скорость, необходимая для выполнения заказа до 40 км/ч и город на воде, то корабль.
// Если нужна скорость выше 120 км/ч, и есть аэропорт, то самолет. В остальных случаях — грузовик.
// Грузоподъемность должна равняться весу груза, округленного вверх до числа кратного 500.
// Скорость должна равняться скорости, необходимой для прибытия в срок, округленной вверх до ближайшего десятка.
// Если вес или скорость кратны 500 и 10, то округлять не нужно.
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

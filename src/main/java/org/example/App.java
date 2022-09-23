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

        City barnaul = new City("Барнаул", 220);
        City ulgiy = new City("Улгий", 630, false, false);
        City n_kuznetsk = new City("Новокузнецк", 360, true, false);
        City tokio = new City ("Tokio", 4900, true, true);

        City[] cities = {barnaul, ulgiy, n_kuznetsk, tokio};

        int weight = 4350;
        int hours = 480;

        TransportFactory factory = new TransportFactory();

        for (City city : cities) {
            Transport transport = factory.getTransport(city, weight, hours);
            System.out.println(city.getName() + " (" + city.getDistanceKm() + ", air = " + city.hasAirport()
                    + ", water = " + city.isOnWater() + "): sending " + transport.getName()
                    + ", " + transport.getCapacity() + " kg, " + transport.getSpeed() + " km/h.");
        }


    }

}

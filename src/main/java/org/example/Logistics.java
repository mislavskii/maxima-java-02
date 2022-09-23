package org.example;

public class Logistics {
    private Transport[] vehicles;

    public Logistics(Transport... vehicles) {
        this.vehicles = vehicles;
    }

    public Transport getShipping (City city, int weight, int hours) {
        Transport bestVehicle = null;
        int startIndex = 0;
        for (int i=0; i < vehicles.length; i++) {  // находим первый доступный транспорт, если есть
            if ( isShippingAvailable(vehicles[i], city, weight, hours) ) {
                bestVehicle = vehicles[i];  // и устанавливаем его как отправную точку для дальнейшего сравнения
                startIndex = i + 1;  // запомнив, где остановились
                break;
            }
        }
        // обходим оставшуюся часть массива (если есть), начиная, где остановились, и находим самый дешевый вариант
        if (startIndex < vehicles.length) {  // при отсутствии доступных вариантов - этот блок не исполняется
            for (Transport vehicle : java.util.Arrays.copyOfRange(vehicles, startIndex, vehicles.length)) {
                if ( isShippingAvailable (vehicle, city, weight, hours) ) {
                    if (vehicle.getCostOfKm() < bestVehicle.getCostOfKm()) {
                        bestVehicle = vehicle;
                    }
                }
            }
        }
        return bestVehicle;
    }

    private boolean isShippingAvailable (Transport vehicle, City city, int weight, int hours) {
        return  vehicle.getCapacity() >= weight
                && ( (float) city.getDistanceKm() ) / vehicle.getSpeed() <= hours
                && vehicle.getPrice(city) != 0  // добавил проверку цены
                && !vehicle.isRepairing();
    }

    private boolean isShippingAvailableX(Transport vehicle, City city, int weight, int hours){
        boolean isReachable = vehicle.getPrice(city)>0;
        boolean isNotOverloaded = vehicle.getCapacity()>=weight;
        boolean canShipInTime = city.getDistanceKm() / vehicle.getSpeed() <= hours;
        return isReachable && isNotOverloaded && canShipInTime && !vehicle.isRepairing(); }

// Before Null-object
    public Transport getShippingX(City city, int weight, int hours){
        Transport result = null;
        for (Transport vehicle : vehicles){
            if(isShippingAvailable(vehicle, city, weight, hours)){
                if (result == null) {
                    result = vehicle;
                } else {
                    if (vehicle.getPrice(city) < result.getPrice(city)) {
                        result = vehicle;
                    }
                }
            }
        } return result;
    }

}

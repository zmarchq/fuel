package quru.qa.repo;

import quru.qa.domain.Car;
import quru.qa.domain.Ferrari;
import quru.qa.domain.Mercedes;

import java.util.Map;

public class CarStore {

    private final Map<String, Car> store = Map.of(
            "Ferrari", new Ferrari(),
            "Mercedes", new Mercedes()
    );

    public String[] getCarName() {
        return store.keySet().toArray(String[]::new);
    }

    public Car lookup(String carName) {
        for (String key : store.keySet()) {
            if (key.equalsIgnoreCase(carName)) {
                return store.get(key);
            }
        }
        throw new IllegalArgumentException("Car not found for given argument: " + carName);
    }
}

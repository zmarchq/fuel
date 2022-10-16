package quru.qa.repo;

import quru.qa.domain.*;

import java.util.Map;

public class TrackStore {
    private final Map<String, Track> store = Map.of(
            "Nurburgring", new Nurburgring(),
            "Spa", new Spa()
    );

    public String[] getTrackName() {
        return store.keySet().toArray(String[]::new);
    }

    public Track lookup(String carName) {
        for (String key : store.keySet()) {
            if (key.equalsIgnoreCase(carName)) {
                return store.get(key);
            }
        }
        throw new IllegalArgumentException("Car not found for given argument: " + carName);
    }
}

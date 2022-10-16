package quru.qa.domain;

public abstract class Car {
    private static final int FUEL_CAPACITY = 100;
    private int maxLapsForTrack;


    public abstract double getFuelEconomy();

    public int fuelCapacity() {
        return FUEL_CAPACITY;
    }

    public void maxLapsForTrack(Track track) {
        int lapDistance = track.lapDistance();

        double fuelEconomy = getFuelEconomy();
        int fuelCapacity = fuelCapacity();

        double maxDistanceForCar = fuelCapacity * 100 / fuelEconomy;
        this.maxLapsForTrack = (int) ((maxDistanceForCar * 1000) / lapDistance);
    }

    public int getMaxLapsForTrack() {
        return this.maxLapsForTrack;
    }

    public boolean isPitstopNeeded(Track track) {
        maxLapsForTrack(track);
        return maxLapsForTrack < track.laps();
    }
}

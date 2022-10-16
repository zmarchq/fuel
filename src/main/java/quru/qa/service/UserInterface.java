package quru.qa.service;

import quru.qa.domain.Car;
import quru.qa.domain.Track;
import quru.qa.repo.CarStore;
import quru.qa.repo.TrackStore;

import javax.swing.*;

public class UserInterface {
    private final CarStore carStore;
    private final TrackStore trackStore;

    public UserInterface(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }



    public Car chooseCarInGui() {
        String desiredCar = (String) JOptionPane.showInputDialog(
                null,
                "Choose your car",
                null,
                JOptionPane.QUESTION_MESSAGE,
                null,
                carStore.getCarName(),
                null);
        return carStore.lookup(desiredCar);
    }

    public Track chooseTrackInGui() {
        String desiredTrack = (String) JOptionPane.showInputDialog(
                null,
                "Choose your track",
                null,
                JOptionPane.QUESTION_MESSAGE,
                null,
                trackStore.getTrackName(),
                null);
        return trackStore.lookup(desiredTrack);
    }

    public void showResult(Car car, Track track) {
        if (car.isPitstopNeeded(track)) {
            JOptionPane.showMessageDialog(null,
                    "Pit-stop needed in " + car.getMaxLapsForTrack(),
                    "Result",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Pit-stop is not needed",
                    "Result",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}

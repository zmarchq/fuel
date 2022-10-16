package quru.qa;

import quru.qa.repo.CarStore;
import quru.qa.repo.TrackStore;
import quru.qa.service.UserInterface;

public class Main {
    public static void main(String[] args) {
        new Application(new UserInterface(
                new CarStore(),
                new TrackStore()
        )).run();
    }
}

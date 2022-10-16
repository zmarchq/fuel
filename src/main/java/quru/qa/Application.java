package quru.qa;

import quru.qa.domain.Car;
import quru.qa.domain.Track;
import quru.qa.service.UserInterface;

public class Application {
    private final UserInterface userInterface;

    public Application(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    void run() {
        Car car = userInterface.chooseCarInGui();
        Track track = userInterface.chooseTrackInGui();
        userInterface.showResult(car, track);
    }
}

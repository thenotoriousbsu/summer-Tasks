package action;

import entity.Auto;

import java.util.List;

public class SetAutoTime {
    public static void setTime(List<Auto> autos, int length) {
        for (Auto auto: autos) {
            auto.setTime((length - auto.getCurrentPosition()) / auto.getVelocity());
        }
    }
}

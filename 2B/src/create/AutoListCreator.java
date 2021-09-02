package create;

import entity.Auto;

import java.util.LinkedList;
import java.util.List;

public class AutoListCreator {
    public static List<Auto> create(int n) {
        List<Auto> autos = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            autos.add(new Auto("Auto" + i));
        }

        return autos;
    }
}

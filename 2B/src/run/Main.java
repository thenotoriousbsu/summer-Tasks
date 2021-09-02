package run;

/*
    18. На прямой гоночной трассе стоит N автомобилей,
        для каждого из которых известны начальное положение и скорость.
        Определить, сколько произойдет обгонов.
 */

import action.SetAutoTime;
import create.AutoListCreator;
import entity.Auto;
import task.Task;

import java.util.List;
import java.util.Random;

public class Main {
    static final int LENGHT = new Random().nextInt(100) + 100;
    static final int n = 5;

    public static void main(String[] args) {
        List<Auto> autos = AutoListCreator.create(n);

        SetAutoTime.setTime(autos, LENGHT);

        int result = Task.task(autos);

        System.out.println("Road lenght: " + LENGHT);
        for (Auto auto: autos) {
            System.out.println(auto);
        }
        System.out.println("Result: " + result);
    }
}
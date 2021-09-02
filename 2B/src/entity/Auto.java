package entity;

import java.util.Random;

public class Auto {
    String name;
    int velocity;
    int currentPosition;
    double time;

    {
        name = null;
        velocity = 1;
        currentPosition = 0;
    }

    public Auto() {}

    public Auto(String name, int currentPosition, int velocity) {
        this.name = name;
        this.velocity = velocity;
        this.currentPosition = currentPosition;
    }

    public Auto(String name) {
        this.name = name;
        this.currentPosition = new Random().nextInt(20);
        this.velocity = new Random().nextInt(9) + 1;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return name + " {velocity: " + velocity + ", current position:" + currentPosition + ", race time: " + time + '}';
    }
}
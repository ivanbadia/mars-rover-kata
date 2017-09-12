package com.codurance.rover;

public class LockedPoint extends Point {

    private static final char OBSTACLE = 'O';

    LockedPoint(Point point) {
        super(point.coordinate(), point.direction());
    }

    @Override
    public String toString() {
        return OBSTACLE +","+super.toString();
    }
}

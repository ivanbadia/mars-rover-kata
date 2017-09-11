package com.codurance.rover;

import java.text.MessageFormat;

public class Point {
    private final Coordinates coordinates;
    private final Direction direction;

    Point(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    Point rotateLeft(){
        return moveTo(coordinates, direction.rotateLeft());
    }

    Point rotateRight(){
        return moveTo(coordinates, direction.rotateRight());
    }

    Point move(){
        Point newPoint;
        if(direction.isNorth()){
            newPoint = moveToNorth();
        }else if(direction.isSouth()){
            newPoint = moveToSouth();
        }else if(direction.isEast()){
            newPoint = moveToEast();
        }else{
            newPoint = moveToWest();
        }

        return newPoint;
    }

    public String toString(){
        return MessageFormat.format("{0},{1},{2}", coordinates.x(), coordinates.y(), direction.value());
    }

    private Point moveToWest() {
        return moveTo(new Coordinates(coordinates.x() - 1, coordinates.y()), this.direction);
    }

    private Point moveToEast() {
        return moveTo(new Coordinates(coordinates.x() + 1, coordinates.y()), this.direction);
    }

    private Point moveToSouth() {
        return moveTo(new Coordinates(coordinates.x(), coordinates.y() - 1), this.direction);
    }

    private Point moveToNorth() {
        return moveTo(new Coordinates(coordinates.x(), coordinates.y() + 1), this.direction);
    }

    private Point moveTo(Coordinates coordinates, Direction direction) {
        return new Point(coordinates, direction);
    }
}

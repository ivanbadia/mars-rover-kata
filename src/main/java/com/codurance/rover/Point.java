package com.codurance.rover;

import java.text.MessageFormat;

class Point {
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

    int x() {
        return coordinates.x();
    }

    int y() {
        return coordinates.y();
    }

    Direction direction() {
        return this.direction;
    }

    Coordinates coordinate() {
        return this.coordinates;
    }

    Point next(){
        Point nextPoint;
        if(direction.isNorth()){
            nextPoint = moveToNorth();
        }else if(direction.isSouth()){
            nextPoint = moveToSouth();
        }else if(direction.isEast()){
            nextPoint = moveToEast();
        }else{
            nextPoint = moveToWest();
        }

        return nextPoint;
    }

    public String toString(){
        return MessageFormat.format("{0},{1},{2}", coordinates.x(), coordinates.y(), direction.value());
    }

    private Point moveToWest() {
        return moveTo(new Coordinates(coordinates.x() -1, coordinates.y()), this.direction);
    }

    private Point moveToEast() {
        return moveTo(new Coordinates(coordinates.x() +1, coordinates.y()), this.direction);
    }

    private Point moveToSouth() {
        return moveTo(new Coordinates(coordinates.x(), coordinates.y()-1), this.direction);
    }

    private Point moveToNorth() {
        return moveTo(new Coordinates(coordinates.x(), coordinates.y()+1), this.direction);
    }

    private Point moveTo(Coordinates coordinates, Direction direction) {
        return new Point(coordinates, direction);
    }

}

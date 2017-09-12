package com.codurance.rover;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final int x;
    private final int y;
    private final List<Coordinates> obstacles;

    public Grid(int x, int y) {
        this(x, y, new ArrayList<>());
    }


    public Grid(int x, int y, List<Coordinates> obstacles) {
        this.x = x;
        this.y = y;
        this.obstacles = obstacles;
    }

    Point next(Point point){
        Point nextPoint = point.next();
        nextPoint = wrapAroundIfItIsOutOfTheLimits(nextPoint);

        if(thereIsAnObstacleIn(nextPoint)){
            nextPoint = new LockedPoint(point);
        }

        return nextPoint;
    }

    private boolean thereIsAnObstacleIn(Point nextPoint) {
        return obstacles.contains(nextPoint.coordinate());
    }

    private Point wrapAroundIfItIsOutOfTheLimits(Point nextPoint) {
        if(nextPoint.x()<0){
            nextPoint = wrapFromLeftToRight(nextPoint);
        } else if(nextPoint.y()<0){
            nextPoint = wrapFromBottomToTop(nextPoint);
        } else if(nextPoint.x()>=x){
            nextPoint = wrapFromRightToLeft(nextPoint);
        } else if(nextPoint.y()>=y){
            nextPoint = wrapFromTopToBottom(nextPoint);
        }
        return nextPoint;
    }

    private Point wrapFromTopToBottom(Point nextPoint) {
        return new Point(coordinate(nextPoint.x(), nextPoint.y()-y), nextPoint.direction());
    }

    private Point wrapFromRightToLeft(Point nextPoint) {
        return new Point(coordinate(nextPoint.x() - x, y + nextPoint.y()), nextPoint.direction());
    }

    private Point wrapFromBottomToTop(Point nextPoint) {
        return new Point(coordinate(nextPoint.x(), y + nextPoint.y()), nextPoint.direction());
    }

    private Point wrapFromLeftToRight(Point nextPoint) {
        return new Point(coordinate(x + nextPoint.x(), nextPoint.y()), nextPoint.direction());
    }

    private Coordinates coordinate(int x, int y){
        return new Coordinates(x, y);
    }


}

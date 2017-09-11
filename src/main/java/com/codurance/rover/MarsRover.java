package com.codurance.rover;

public class MarsRover {
    private static final char ROTATE_LEFT = 'L';
    private static final char ROTATE_RIGHT = 'R';
    private static final char MOVE_ONE_POINT = 'M';
    private Point point;

    public MarsRover() {
        point = new Point(new Coordinates(0, 0), Direction.north());
    }


    public MarsRover(Point point) {
        this.point = point;
    }


    public String execute(String commands) {
       for(char command : commands.toCharArray()){
           if(command==ROTATE_LEFT){
               point = point.rotateLeft();
           }else if(command==ROTATE_RIGHT){
               point = point.rotateRight();
           }else if(command==MOVE_ONE_POINT){
               point = point.move();
           }
       }

       return point.toString();
    }


}

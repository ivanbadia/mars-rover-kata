package com.codurance.rover;

public class MarsRover {
    private static final char ROTATE_LEFT = 'L';
    private static final char ROTATE_RIGHT = 'R';
    private static final char MOVE_ONE_POINT = 'M';
    private final Grid grid;
    private Point point;

    public MarsRover(Grid grid, Point point) {
        this.grid = grid;
        this.point = point;
    }

    public String execute(String commands) {
       for(char command : commands.toCharArray()){
           if(command==ROTATE_LEFT){
               point = point.rotateLeft();
           }else if(command==ROTATE_RIGHT){
               point = point.rotateRight();
           }else if(command==MOVE_ONE_POINT){
               point = grid.next(point);
           }
       }

       return point.toString();
    }


}

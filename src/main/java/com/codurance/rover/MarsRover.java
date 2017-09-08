package com.codurance.rover;

public class MarsRover {
    private static final char ROTATE_LEFT = 'L';
    private static final char ROTATE_RIGHT = 'R';
    private Direction direction;

    public MarsRover() {
        this.direction = Direction.NORTH;
    }

    public String execute(String commands) {
       for(char command : commands.toCharArray()){
           if(command== ROTATE_LEFT){
               direction = direction.rotateLeft();
           }else if(command== ROTATE_RIGHT){
               direction = direction.rotateRight();
           }
       }

       return "0,0,"+direction.value();
    }


}

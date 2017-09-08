package com.codurance.rover;

public class MarsRover {
    private static final char ROTATE_LEFT = 'L';
    private char direction = 'N';

    public String execute(String commands) {
       for(char command : commands.toCharArray()){
           if(command== ROTATE_LEFT){
               rotateLeft();
           }
       }

       return "0,0,"+direction;

    }

    private void rotateLeft() {
        if(direction=='N'){
            direction = 'W';
        }else if(direction=='W'){
            direction = 'S';
        }else if(direction=='S'){
            direction = 'E';
        }else if(direction=='E'){
            direction = 'N';
        }
    }
}

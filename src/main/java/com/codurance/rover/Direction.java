package com.codurance.rover;

class Direction {
    public static final char EAST = 'E';
    public static final char NORTH = 'N';
    public static final char WEST = 'W';
    public static final char SOUTH = 'S';
    private char value = 'N';

    public char value(){
        return value;
    }

    public void rotateRight() {
        if(value == NORTH){
            value = EAST;
        }else if(value == EAST){
            value = SOUTH;
        }else if(value == SOUTH){
            value = WEST;
        }else if(value == WEST){
            value = NORTH;
        }
    }

    public void rotateLeft() {
        if(value ==NORTH){
            value = WEST;
        }else if(value == WEST){
            value = SOUTH;
        }else if(value == SOUTH){
            value = EAST;
        }else if(value == EAST){
            value = NORTH;
        }
    }

}

package com.codurance.rover;

import java.util.Arrays;

enum Direction {
    EAST('E', 'N', 'S'),
    NORTH('N', 'W', 'E'),
    WEST('W', 'S', 'N'),
    SOUTH('S', 'E', 'W');

    private char value;
    private char left;
    private char right;

    Direction(char value, char left, char right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public char value(){
        return value;
    }

    public Direction rotateRight() {
        return find(this.right);
    }

    public Direction rotateLeft() {
        return find(this.left);
    }

    private Direction find(char value) {
        return Arrays.asList(values()).stream()
                .filter(direction -> direction.value==value)
                .findFirst()
                .orElse(null);
    }



}

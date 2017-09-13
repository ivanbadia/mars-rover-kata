package com.codurance.rover;

public enum Direction {

    NORTH('N') {
        @Override
        Direction rotateLeft() {
            return WEST;
        }

        @Override
        Direction rotateRight() {
            return EAST;
        }
    },
    EAST('E') {
        @Override
        Direction rotateLeft() {
            return NORTH;
        }

        @Override
        Direction rotateRight() {
            return SOUTH;
        }
    },
    SOUTH('S') {
        @Override
        Direction rotateLeft() {
            return EAST;
        }

        @Override
        Direction rotateRight() {
            return WEST;
        }
    },
    WEST('W') {
        @Override
        Direction rotateLeft() {
            return SOUTH;
        }

        @Override
        Direction rotateRight() {
            return NORTH;
        }
    };

    private final char value;

    Direction(char value) {
        this.value = value;
    }

    abstract Direction rotateLeft();

    abstract Direction rotateRight();

    public char value() {
        return value;
    }
}
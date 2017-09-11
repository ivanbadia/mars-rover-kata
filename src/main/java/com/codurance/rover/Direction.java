package com.codurance.rover;

public abstract class Direction {

    private static final char NORTH = 'N';
    private static final char WEST = 'W';
    private static final char EAST = 'E';
    private static final char SOUTH = 'S';
    private final char value;

    Direction(char value) {
        this.value = value;
    }

    public abstract Direction rotateRight();

    public abstract Direction rotateLeft();

    char value(){
        return value;
    }

    static North north(){
        return new North();
    }

    static South south(){
        return new South();
    }

    static Direction east() {
        return new East();
    }

    static Direction west() {
        return new West();
    }

    boolean isNorth() {
        return value == NORTH;
    }

    boolean isSouth() {
        return value == SOUTH;
    }

    boolean isEast() {
        return value == EAST;
    }


    private static class North extends Direction {
        North() {
            super(NORTH);
        }

        @Override
        public Direction rotateRight() {
            return new East();
        }

        @Override
        public Direction rotateLeft() {
            return new West();
        }
    }


    private static class West extends Direction {
        West() {
            super(WEST);
        }

        @Override
        public Direction rotateRight() {
            return new North();
        }

        @Override
        public Direction rotateLeft() {
            return new South();
        }
    }

    private static class East extends Direction {
        East() {
            super(EAST);
        }

        @Override
        public Direction rotateRight() {
            return new South();
        }

        @Override
        public Direction rotateLeft() {
            return new North();
        }
    }

    private static class South extends Direction {
        South() {
            super(SOUTH);
        }

        @Override
        public Direction rotateRight() {
            return new West();
        }

        @Override
        public Direction rotateLeft() {
            return new East();
        }
    }
}

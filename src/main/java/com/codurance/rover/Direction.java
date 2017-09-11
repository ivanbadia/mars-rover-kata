package com.codurance.rover;

public abstract class Direction {

    private final char value;

    Direction(char value) {
        this.value = value;
    }

    public abstract Direction rotateRight();

    public abstract Direction rotateLeft();

    public char value(){
        return value;
    }

    public static North north(){
        return new North();
    }

    private static class North extends Direction {
        North() {
            super('N');
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
            super('W');
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
            super('E');
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
            super('S');
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

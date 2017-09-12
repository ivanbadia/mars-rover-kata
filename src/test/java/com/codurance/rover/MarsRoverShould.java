package com.codurance.rover;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverShould {

    private static final String COMMANDS_AND_FINISHING_POSITION = "commands=''{0}'', finishingPosition={1}";
    private static final Grid GRID = new Grid(10, 10);
    private static final Coordinates OBSTACLE_ON_0_2 = new Coordinates(0, 2);

    @DisplayName("rotate left")
    @ParameterizedTest(name = COMMANDS_AND_FINISHING_POSITION)
    @CsvSource({"L, '0,0,W'",
                "LL, '0,0,S'",
                "LLL, '0,0,E'",
                "LLLL, '0,0,N'"})

    public void rotate_left(String commands, String finishingPoint){

        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(0, 0), Direction.north()));

        assertThat(marsRover.execute(commands)).isEqualTo(finishingPoint);
    }

    @DisplayName("rotate right")
    @ParameterizedTest(name = COMMANDS_AND_FINISHING_POSITION)
    @CsvSource({"R, '0,0,E'",
                "RR, '0,0,S'",
                "RRR, '0,0,W'",
                "RRRR, '0,0,N'"})
    public void rotate_right(String commands, String finishingPoint){

        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(0, 0), Direction.north()));

        assertThat(marsRover.execute(commands)).isEqualTo(finishingPoint);
    }

    @DisplayName("move to the north")
    @Test
    public void move_to_the_north(){
        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(0, 0), Direction.north()));

        assertThat(marsRover.execute("MM")).isEqualTo("0,2,N");
    }

    @DisplayName("move to the south")
    @Test
    public void move_to_the_south(){

        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(0, 10), Direction.south()));

        assertThat(marsRover.execute("MM")).isEqualTo("0,8,S");
    }

    @DisplayName("move to the east")
    @Test
    public void move_to_the_east(){
        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(0, 0), Direction.east()));

        assertThat(marsRover.execute("MM")).isEqualTo("2,0,E");
    }

    @DisplayName("move to the west")
    @Test
    public void move_to_the_west(){

        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(2, 0), Direction.west()));

        assertThat(marsRover.execute("MM")).isEqualTo("0,0,W");
    }

    @DisplayName("wrap around if it reaches the end of the grid on the left")
    @Test
    public void wrap_around_if_it_reaches_the_end_of_the_grid_on_the_left(){

        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(0, 0), Direction.west()));

        assertThat(marsRover.execute("MM")).isEqualTo("8,0,W");
    }

    @DisplayName("wrap around if it reaches the end of the grid on the right")
    @Test
    public void wrap_around_if_it_reaches_the_end_of_the_grid_on_the_right(){

        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(9, 0), Direction.east()));

        assertThat(marsRover.execute("MM")).isEqualTo("1,0,E");
    }

    @DisplayName("wrap around if it reaches the end of the grid at the top")
    @Test
    public void wrap_around_if_it_reaches_the_end_of_the_grid_at_the_top(){

        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(0, 9), Direction.north()));

        assertThat(marsRover.execute("MM")).isEqualTo("0,1,N");
    }

    @DisplayName("wrap around if it reaches the end of the grid at the bottom")
    @Test
    public void wrap_around_if_it_reaches_the_end_of_the_grid_at_the_bottom(){

        MarsRover marsRover = new MarsRover(GRID, new Point(coordinates(0, 9), Direction.south()));

        assertThat(marsRover.execute("MM")).isEqualTo("0,7,S");
    }

    @DisplayName("move up to the last possible point and report the obstacle")
    @Test
    public void move_up_to_the_last_possible_point_and_reports_the_obstacle(){

        Grid grid = new Grid(10, 10, singletonList(OBSTACLE_ON_0_2));
        MarsRover marsRover = new MarsRover(grid, new Point(coordinates(0, 0), Direction.north()));

        assertThat(marsRover.execute("MMM")).isEqualTo("O,0,1,N");
    }

    private Coordinates coordinates(int x, int y) {
        return new Coordinates(x, y);
    }

}

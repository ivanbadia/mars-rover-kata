package com.codurance.rover;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverShould {

    private static final String COMMANDS_AND_FINISHING_POSITION = "commands=''{0}'', finishingPosition={1}";

    @DisplayName("rotate left")
    @ParameterizedTest(name = COMMANDS_AND_FINISHING_POSITION)
    @CsvSource({"L, '0,0,W'",
                "LL, '0,0,S'",
                "LLL, '0,0,E'",
                "LLLL, '0,0,N'"})

    public void rotate_left(String commands, String finishingPoint){
        assertThat(new MarsRover().execute(commands)).isEqualTo(finishingPoint);
    }

    @DisplayName("rotate right")
    @ParameterizedTest(name = COMMANDS_AND_FINISHING_POSITION)
    @CsvSource({"R, '0,0,E'",
                "RR, '0,0,S'",
                "RRR, '0,0,W'",
                "RRRR, '0,0,N'"})
    public void rotate_right(String commands, String finishingPoint){
        assertThat(new MarsRover().execute(commands)).isEqualTo(finishingPoint);
    }


    @Test
    public void move_one_point_to_north(){
        assertThat(new MarsRover().execute("MM")).isEqualTo("0,2,N");
    }

    @Test
    public void move_one_point_to_south(){
        assertThat(new MarsRover(new Point(new Coordinates(0, 10), Direction.south())).execute("MM")).isEqualTo("0,8,S");
    }

    @Test
    public void move_one_point_to_east(){
        assertThat(new MarsRover(new Point(new Coordinates(0, 0), Direction.east())).execute("MM")).isEqualTo("2,0,E");
    }


    @Test
    public void move_one_point_to_west(){
        assertThat(new MarsRover(new Point(new Coordinates(2, 0), Direction.west())).execute("MM")).isEqualTo("0,0,W");
    }



}

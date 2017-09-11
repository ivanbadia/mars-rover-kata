package com.codurance.rover;

import org.junit.jupiter.api.DisplayName;
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

    public void move_onew_point(){

    }
}

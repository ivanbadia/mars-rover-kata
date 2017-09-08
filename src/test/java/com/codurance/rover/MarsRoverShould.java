package com.codurance.rover;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverShould {

    @ParameterizedTest
    @CsvSource({"L, '0,0,W'",
                "LL, '0,0,S'",
                "LLL, '0,0,E'",
                "LLLL, '0,0,N'"})
    public void rotate_left(String commands, String finishingPoint){
        assertThat(new MarsRover().execute(commands)).isEqualTo(finishingPoint);
    }

}

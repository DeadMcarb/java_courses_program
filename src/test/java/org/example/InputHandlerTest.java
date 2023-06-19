package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    InputHandler inputHandler;
    double EPS = 0.000001;
    @BeforeEach
    void setUp() {
        inputHandler = new InputHandler();
    }


    @ParameterizedTest
    @CsvSource({"false, (1 = -",
            "false, (x = )",
            "false, 123 = 1)",
            "false, (1+3) = 1)",
            "true, (1+3) = 1",
    })
    void testCheckBrackets(boolean expected, String str) {
        assertEquals(expected, inputHandler.checkBrackets(str));
    }


    @ParameterizedTest
    @CsvSource({"false, 2*((x+5)+x+6)=10cvbnmjk,l.",
            "true, -1.3*+5/x=1.2",
            "false, 123 = 1y",
    })
    void testCheckTrash(boolean expected, String str) {
        assertEquals(expected, inputHandler.checkTrash(str));
    }

    @ParameterizedTest
    @CsvSource({"true, 2*-x+5=17",
            "false, -1.3*+5/x=1.2",
            "false, 2-+x=10",
            "true, 17=2*x+5",
    })
    void testCheckTwoMathActionsSequence(boolean expected, String str) {
        assertEquals(expected, inputHandler.checkTwoMathActionsSequence(str));
    }

    @ParameterizedTest
    @CsvSource({"3, 2*-x+5=17",
            "3, -1.3*+5/x=1.2",
            "4, 2456789.567890*-x+5+10=17.0",
    })
    void testHowManyNumbersAreInTheEquation(int expected, String str) {
        assertEquals(expected, inputHandler.howManyNumbersAreInTheEquation(str));
    }

}
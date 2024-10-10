package com.calculate.calculate;

import com.calculate.calculate.exeptions.ZeroDivideArgument;
import com.calculate.calculate.service.CalculateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculateServiceImplTest {
    private CalculateServiceImpl calculateService;

    @BeforeEach
    public void setUp(){
        calculateService = new CalculateServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("paramForTestPlus")
    void TestCalculateServicePlus(String num1, String num2, String answer){
        Assertions.assertEquals(calculateService.plus(num1, num2), answer);
    }

    @ParameterizedTest
    @MethodSource("paramForTestMinus")
    void TestCalculateServiceMinus(String num1, String num2, String answer){
        Assertions.assertEquals(calculateService.minus(num1, num2), answer);
    }

    @ParameterizedTest
    @MethodSource("paramForTestMultiply")
    void TestCalculateServiceMultiply(String num1, String num2, String answer){
        Assertions.assertEquals(calculateService.multiply(num1, num2), answer);
    }

    @ParameterizedTest
    @MethodSource("paramForTestDivide")
    void TestCalculateServiceDivide(String num1, String num2, String answer){
        Assertions.assertEquals(calculateService.divide(num1, num2), answer);
    }

    @Test
    void TestCalculateServiceDivideError(){
        Assertions.assertThrows(ZeroDivideArgument.class, () -> calculateService.divide("1", "0"));
    }

    public static Stream<Arguments> paramForTestPlus(){
        return Stream.of(
                Arguments.of("2", "2", "2 + 2 = 4"),
                Arguments.of("2", "3", "2 + 3 = 5"),
                Arguments.of("2", "4", "2 + 4 = 6"),
                Arguments.of("2", "-1", "2 + -1 = 1")
        );
    }

    public static Stream<Arguments> paramForTestMinus(){
        return Stream.of(
                Arguments.of("2", "2", "2 - 2 = 0"),
                Arguments.of("2", "3", "2 - 3 = -1"),
                Arguments.of("2", "4", "2 - 4 = -2"),
                Arguments.of("2", "-1", "2 - -1 = 3")
        );
    }

    public static Stream<Arguments> paramForTestMultiply(){
        return Stream.of(
                Arguments.of("2", "2", "2 * 2 = 4"),
                Arguments.of("2", "3", "2 * 3 = 6"),
                Arguments.of("2", "4", "2 * 4 = 8"),
                Arguments.of("2", "-1", "2 * -1 = -2")
        );
    }

    public static Stream<Arguments> paramForTestDivide(){
        return Stream.of(
                Arguments.of("2", "2", "2 / 2 = 1"),
                Arguments.of("2", "3", "2 / 3 = 0"),
                Arguments.of("2", "4", "2 / 4 = 0")
        );
    }
}

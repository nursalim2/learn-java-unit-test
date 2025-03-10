package com.nursalim.unittest;

import com.nursalim.unittest.resolver.RandomParameterResolver;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

//@Extensions(value = {@ExtendWith(RandomParameterResolver.class)})
public class RandomCalculatorTest extends ParentCalculatorTest {
    @DisplayName("Test calculator random")
    @RepeatedTest(
            value = 10//,
//            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    public void testRandom(Random random, TestInfo info, RepetitionInfo repetitionInfo) {
        var a = random.nextInt();
        var b = random.nextInt();

        System.out.println("ke " + repetitionInfo.getCurrentRepetition());
        System.out.println("dari " + repetitionInfo.getTotalRepetitions());

        assertEquals(a + b, calculator.add(a, b));
    }

    public static List<Integer> parameterSource() {
        return List.of(1, 2, 3, 4, 5);
    }

    @DisplayName("Test calculator with parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
//    @ValueSource(ints = {1, 2, 3, 4, 5})
    @MethodSource(value = {"parameterSource"})
    public void testWithParameter(int value) {
        var result = value + value;
        assertEquals(result, calculator.add(value, value));
    }
}

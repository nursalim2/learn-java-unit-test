package com.nursalim.unittest;

import com.nursalim.unittest.resolver.RandomParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

@Extensions(value = {@ExtendWith(RandomParameterResolver.class)})
public class ParentCalculatorTest {
    protected Calculator calculator = new Calculator();

    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }
}

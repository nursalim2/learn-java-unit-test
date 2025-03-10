package com.nursalim.unittest;

import com.nursalim.unittest.generator.SimpleDisplayNameGenerator;
import jdk.jfr.Enabled;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


//@DisplayName("Test calculator")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All test");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After all test");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before unit test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After unit test");
    }

    @Test
//    @DisplayName("Test function Calculator.add(Integer, Integer)")
    public void testAddSuccess() {
        var result = calculator.add(10, 10);
        assertEquals(20, result);
    }

    @Test
    public void testDivideSuccess() {
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(100, 0));
    }

    @Test
    @Disabled
    public void testComingSoon() {
    }

    @Test
    @Disabled
    public void testAborted() {
        var profile = System.getenv("PROFILE");
        if (!profile.equals("DEV")) {
           throw new TestAbortedException();
        }
    }

    @Test
    public void testAssumption() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
}

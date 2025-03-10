package com.nursalim.unittest;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // default per method
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    private int counter = 0;

    @BeforeAll
    void setUp() {
    }

    @AfterAll
    void tearDown() {

    }

    @Test
    @Order(1)
    public void test3() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    public void test2() {
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    public void test1() {
        counter++;
        System.out.println(counter);
    }
}

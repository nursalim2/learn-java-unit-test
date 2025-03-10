package com.nursalim.unittest;

import org.junit.jupiter.api.Test;

public class LifeCycleTest {
    private String temp;

    @Test
    public void testA() {
        temp = "Nursalim";
    }

    @Test
    public void testB() {
        System.out.println(temp);
    }
}

package com.nursalim.unittest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("integration-test")
public class SampleIntegrationTest {
    // running: mvn test -Dgroups=integration-test

    @Test
    public void integrationTest1() {
        System.out.println("Integration Test 1");
    }

    @Test
    public void integrationTest2() {
        System.out.println("Integration Test 2");
    }
}

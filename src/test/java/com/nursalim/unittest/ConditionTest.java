package com.nursalim.unittest;

import com.nursalim.unittest.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class ConditionTest {
    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void onlyRunOnWindows() {
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    public void disableRunOnWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void testEnabledOnJava8(){

    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    public void testDisabledOnJava8(){
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_21)
    public void testEnabledOnJava11To21(){ {

    }}

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_15)
    public void testDisabledOnJava8To15(){
    }

    @Test
    public void testSystemProperties() {
        System.out.println(System.getProperties());
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void enabledOnOracle() {

    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void disabledOnOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void enabledOnProfileDev() {

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void disabledOnProfileDev() {

    }

}

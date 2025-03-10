package com.nursalim.unittest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    public void testMock() {
        List<String> list = Mockito.mock(List.class);
        Mockito.when(list.get(0)).thenReturn("Nursalim");
        Mockito.when(list.get(100)).thenReturn("Milasrun");

        System.out.println(list.get(0));
        System.out.println(list.get(100));

        Mockito.verify(list, Mockito.times(1)).get(0);
    }
}

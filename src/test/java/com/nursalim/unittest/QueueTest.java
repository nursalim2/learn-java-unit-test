package com.nursalim.unittest;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {
    private Queue<String> queue;

    @Nested
    @DisplayName("When New")
    public class WhenNew {

        @BeforeEach
        public void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer, size must be 1")
        void offerNewData() {
            queue.offer("Nursalim");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer 2 data, size must be 2")
        void offerMoreData() {
            queue.offer("Nursalim");
            queue.offer("Milasrun");
            Assertions.assertEquals(2, queue.size());
        }
    }
}

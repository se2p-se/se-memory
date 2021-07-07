package de.uni_passau.fim.se.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestView {
        private TestView test;

        @BeforeEach
        void setUp () {
            test = new TestView();
        }

        @Test
        void stringExtend () {
                assertEquals(1, 1);
        }

}

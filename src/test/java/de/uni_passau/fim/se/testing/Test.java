package de.uni_passau.fim.se.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Test1 {
        private Test1 test;

        @BeforeEach
        void setUp () {
            test = new Test1();
        }

        @Test
        void testTest () {
                assertEquals (1, 1);
        }

}

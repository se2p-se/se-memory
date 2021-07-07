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
        void testTest () {
                assertEquals (1, 1);
        }


        /**
         * #297
         */
        @Test
        void testMain () {
                // is not working yet
        }

        /**
         * #298
         */
        @Test
        void testOutputStream () {

        }


        /**
         * #299
         */
        @Test
        void testOutputStreamGameModeBot () {

        }


        /**
         * #300
         */
        @Test
        void testOutputStreamGameModeTime () {

        }

        /**
         * #301
         */
        @Test
        void testOutputStreamMainMenu () {

        }

}

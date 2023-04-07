package Tests;

import aufgabe3.Boxer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBoxer {

        Boxer b1, b2, b3, b4;

        @BeforeEach
        void setup() {
            b1 = new Boxer("Max", "Mustermann", 90);
            b2 = new Boxer("Max", "Mustermann", 90);
            b3 = new Boxer("Max", "Mustermann", 90);
            b4 = null;
        }

        @AfterEach
        void teardown() {
            b1 = null;
            b2 = null;
            b3 = null;
            b4 = null;
        }

        @Test
        void testReflexivitaet() {

            assertTrue(b1.equals(b1),"no reflexivität");
        }

        @Test
        void testSymmetrie() {
            assertTrue(b1.equals(b2), "no symmetrie");
            assertTrue(b2.equals(b1), "no symmetrie");
        }

        @Test
        void testTransitivitaet() {
            assertTrue(b1.equals(b2), "no transitivitaet: x!=y");
            assertTrue(b2.equals(b3), "no transitivitaet: y!=z");
            assertTrue(b1.equals(b3), "no transitivitaet: x!=z");
        }

        @Test
        void testKonsistenz() {
            b4 = new Boxer("Angela", "Merkel", 69);
            for(int i = 0; i < 100; i++) {
                assertTrue(b1.equals(b2), "no konsistenz");
            }
            for(int i = 0; i < 100; i++) {
                assertFalse(b1.equals(b4), "no konsistenz");
            }

        }

        @Test
        void testNullVerschiedenheit() {
            b1 = new Boxer("herbert", "maria", 420);
            assertFalse(b1.equals(null), "no difference to null");
            assertFalse(b2.equals(null), "no difference to null");
        }


}

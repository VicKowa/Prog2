package Tests;

import aufgabe2.SchlangeMitArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SchlangeMitArrayTest {

        SchlangeMitArray s;
         static int[] ar = {1, 2, 3, 4, 5};


        @BeforeEach
        void setup() {
                s = new SchlangeMitArray(5);

        }

        @AfterEach
        void teardown() {
                s = null;
        }

        @Test
        void testInsertRemove() {
                assertThrows(NoSuchElementException.class, () -> s.remove(), "No remove");

                for(int i = 0; i < s.capacity(); i++) {
                        s.insert(ar[i]);
                }

                assertThrows(IllegalStateException.class, () -> s.insert(1), "No insert 1234");

                for (int j : ar) {
                        assertEquals(j, s.remove());
                }


        }

        @Test
        void testCapacity() {
                assertEquals(s.capacity(), ar.length);
        }

        @Test
        void testSize() {
                assertEquals(0, s.size(), "size falsch");

                s.insert(2);
                assertEquals(1,s.size(), "size falsch");
        }

        @Test
        void testIsEmpty() {
                assertTrue(s.isEmpty());
                s.insert(1);
                assertFalse(s.isEmpty());
        }

        @Test
        void testFront() {

                assertThrows(NoSuchElementException.class, () -> s.front(), "es solle kein front geben");
                for (int j : ar) {

                        s.insert(j);
                        assertEquals(s.front(), ar[0]);
                }

        }
}

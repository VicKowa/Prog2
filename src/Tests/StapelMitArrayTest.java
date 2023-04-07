package Tests;

import aufgabe2.StapelMitArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StapelMitArrayTest {

    StapelMitArray stapel;
    static int[] ar = {1, 2, 3, 4, 5};


    @BeforeEach
    void setup() {
        stapel = new StapelMitArray(5);

    }

    @AfterEach
    void teardown() {
        stapel = null;
    }

    @Test
    void testInsertRemove() {
        assertThrows(NoSuchElementException.class, () -> stapel.remove(), "No remove");

        fill();

        assertThrows(IllegalStateException.class, () -> stapel.insert(1), "No insert");

        for(int i = ar.length - 1; i >= 0; i--) {
            assertEquals(ar[i], stapel.remove());
        }


    }

    @Test
    void testCapacity() {
        assertEquals(stapel.capacity(), ar.length);
    }

    @Test
    void testSize() {
        assertEquals(0, stapel.size(), "size falsch");

        stapel.insert(2);
        assertEquals(1,stapel.size(), "size falsch");
    }

    @Test
    void testIsEmpty() {
        assertTrue(stapel.isEmpty());
        stapel.insert(1);
        assertFalse(stapel.isEmpty());
    }

    @Test
    void testTop() {

        assertThrows(NoSuchElementException.class, () -> stapel.top(), "es solle kein top geben");

            stapel.insert(1);
            assertEquals(1, stapel.top());


    }

    void fill() {
        for(int i = 0; i < stapel.capacity(); i++) {
            stapel.insert(ar[i]);
        }
    }

    @Test
    void testApplytoAll() {

        fill();

        stapel.applyToAll((value) ->  value * 2);

        for (int i = ar.length-1; i >= 0; i--) {
            assertEquals(ar[i]* 2, stapel.remove());
        }

        fill();

        stapel.applyToAll((value) ->  value * value);

        for (int i = ar.length-1; i >= 0; i--) {
            assertEquals(ar[i] * ar[i], stapel.remove());
        }

    }

}

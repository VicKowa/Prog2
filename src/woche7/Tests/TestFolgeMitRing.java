package woche7.Tests;

import Woche5.NoCapacityInArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woche7.FolgeMitRing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFolgeMitRing {

    FolgeMitRing<Integer> f;
    int[] ar = {1,2,3,4,5};

    @BeforeEach
    void setup() {
        f = new FolgeMitRing<>(5);
    }

    @AfterEach
    void teardown() {
        f = null;
    }

    @Test
    void testRemovePos() {
        for (int j: ar) {
            f.insert(j);
        }

        for (int i = 1; i < ar.length; i++) {
            assertEquals(ar[i], f.remove(2));
        }

    }

    @Test
    void testGet() {
        for (int j: ar) {
            f.insert(j);
        }
        for (int i = 1; i <= ar.length; i++) {
            assertEquals(i, f.get(i));
        }


    }

    @Test
    void testSet() {
        for (int j: ar) {
            f.insert(j);
        }
        for (int i = 1; i <= ar.length ; i++) {
            assertEquals(i, f.set(i, i));
        }
    }

    @Test
    void testInsertPos() {
        for (int i = 0; i < ar.length-1; i++) {
            f.insert(ar[i]);
        }

        f.insert(1, 1);

        assertThrows(NoCapacityInArray.class,() -> f.insert(1, 20));
        assertEquals(1, f.get(1));
    }
}

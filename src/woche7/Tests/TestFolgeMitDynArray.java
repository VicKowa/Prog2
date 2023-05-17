package woche7.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woche7.FolgeMitDynArray;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFolgeMitDynArray {

    int[] ar = {1,2,3,4,5};
    FolgeMitDynArray<Integer> f;

    @BeforeEach
    void setup() {
        f = new FolgeMitDynArray<>();
    }

    @AfterEach
    void teardown() {
        f = null;
    }

    @Test
    void testInsertPos() {
        for (int j: ar) {
            f.insert(j);
        }
        f.insert(0,1);
        f.insert(5,232);
        assertThrows(IndexOutOfBoundsException.class,() -> f.insert(9, 20));
        assertEquals(1, f.get(1));
        assertEquals(232,f.get(6));
    }

    @Test
    void testRemovePos() {
        for (int j: ar) {
            f.insert(j);
        }
        f.insert(1, 1);

        assertThrows(IndexOutOfBoundsException.class,() -> f.insert(8, 20));
        assertEquals(1, f.get(1));

    }
}

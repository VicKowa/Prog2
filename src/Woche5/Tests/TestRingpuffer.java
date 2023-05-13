package Woche5.Tests;

import Woche5.NoCapacityInArray;
import Woche5.Ringpuffer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRingpuffer {
    
    Ringpuffer<Integer> ring;
    int ar[] = {1,2,3,4,5};
    @BeforeEach
    void setup() {
        ring = new Ringpuffer<>(5);
    }
    
    @Test
    void testAddFirst() {
        int z = 5;
        for (int j : ar) {
            ring.addFirst(j);
        }
        assertThrows(NoCapacityInArray.class, () -> ring.addFirst(2));
        for (int i = 0; i < ar.length; i++) {
            assertEquals(ar[i],ring.get(z));
            z--;
        }
    }

    @Test
    void testAddLast() {
        for (int j : ar) {
            ring.addLast(j);
        }
        assertThrows(NoCapacityInArray.class, () -> ring.addLast(2));
        for (int i = 0; i < ar.length; i++) {
            assertEquals(ar[i],ring.get(i+1));
        }
    }

    @Test
    void testRemoveLast() {
        for (int j : ar) {
            ring.addLast(j);
        }

        for (int i = ar.length-1; i >= 0 ; i--) {
            assertEquals(ar[i], ring.removeLast());
        }
    }

    @Test
    void testRemoveFirst() {
        for (int j : ar) {
            ring.addLast(j);
        }
        for (int i = 0; i < ar.length ; i++) {
            assertEquals(ar[i], ring.removeFirst());
        }
    }

    @Test
    void testSize() {
        assertEquals(0, ring.size());
        ring.addLast(1);
        assertEquals(1, ring.size());
    }

    @Test
    void testGet() {
        ring.addLast(1);
        assertEquals(1,ring.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> ring.get(2));
    }

    @Test
    void testSet() {
        ring.addLast(1);
        assertEquals(1,ring.set(1,2));
        assertEquals(2, ring.get(1));
        assertThrows(NullPointerException.class, () -> ring.set(2, 2));
    }

    @AfterEach
    void teardown() {
        ring = null;
    }


}

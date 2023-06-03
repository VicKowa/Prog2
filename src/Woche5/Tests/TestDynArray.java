package Woche5.Tests;

import Woche5.DynArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDynArray {
    DynArray<Integer> dynArray;
    int[] ar = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @BeforeEach
    void setup() {
        dynArray = new DynArray<>();
    }

    @AfterEach
    void teardown() {
        dynArray = null;
    }

    @Test
    void testSize() {
         assertEquals(0, dynArray.size());
    }

    @Test
    void testCapacity() {
        assertEquals(1, dynArray.capacity());
    }

    @Test
    void testGet() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.get(-1000));
        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.get(0));

    }

    @Test
    void testSet() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.set(-100,2));
        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.set(0,2));
    }

    @Test
    void testAddFirst() {
        assertNull(dynArray.toString());//prüft ob Array null

        //testet das Einfügen von Integers
        for (int i = 0; i < ar.length; i++) {
            dynArray.addFirst(ar[i]);
            assertEquals(ar[i], dynArray.get(0));
        }

        assertEquals(16, dynArray.capacity());// schaut ob Capacity sich verdoppelt hat

    }

    @Test
    void testAddLast() {
        assertNull(dynArray.toString());//prüft ob Array null

        //testet das Einfügen von Integers

       /* for (int i = 0; i < ar.length; i++) {
            dynArray.addLast(ar[i]);
            assertEquals(ar[i],dynArray.get(i));
        }

        */
        dynArray.addLast(ar[0]);
        assertEquals(ar[0],dynArray.get(0));
        dynArray.addLast(ar[1]);
        assertEquals(ar[1],dynArray.get(1));

//        assertEquals(16, dynArray.capacity());// schaut ob Capacity sich verdoppelt hat
    }

    @Test
    void testRemoveFirst() {
        for (int j : ar) {
            dynArray.addFirst(j);
        }
        for (int i = ar.length - 1; i >= 0; i--) {
            assertEquals(ar[i], dynArray.removeFirst());
        }

    }

    @Test
    void testRemoveLast() {
        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.removeLast());
        for (int j : ar) {
            dynArray.addLast(j);
        }
        for (int i = ar.length - 1; i >= 0; i--) {
            assertEquals(ar[i], dynArray.removeLast());
        }
    }


}
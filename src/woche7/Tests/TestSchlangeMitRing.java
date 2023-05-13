package woche7.Tests;

import Woche5.NoCapacityInArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woche7.SchlangeMitRing;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestSchlangeMitRing {
    SchlangeMitRing<Integer> s;
    SchlangeMitRing<String> s2;
    SchlangeMitRing<Boolean> s3;
    static int[] ar = {1, 2, 3, 4, 5};
    static String[] stAr = {"a","b","c","d","e"};
    static Boolean[] boAr = {true, false, false, true, true};


    @BeforeEach
    void setup() {
        s = new SchlangeMitRing<>(5);
        s2 = new SchlangeMitRing<>(5);
        s3 = new SchlangeMitRing<>(5);
    }

    @AfterEach
    void teardown() {
        s = null;
        s2 = null;
        s3 = null;
    }

    @Test
    void testInsertRemove() {
        assertThrows(NoSuchElementException.class, () -> s.remove(), "No remove");
        assertThrows(NoSuchElementException.class, () -> s2.remove(), "No remove");
        assertThrows(NoSuchElementException.class, () -> s3.remove(), "No remove");

        for(int i = 0; i < s.capacity(); i++) {
            s.insert(ar[i]);
            s2.insert(stAr[i]);
            s3.insert(boAr[i]);
        }

        assertThrows(NoCapacityInArray.class, () -> s.insert(1), "No insert ");
        assertThrows(NoCapacityInArray.class, () -> s2.insert("g"), "No insert ");
        assertThrows(NoCapacityInArray.class, () -> s3.insert(true), "No insert ");

        for (int j : ar) {
            assertEquals(j, s.remove());

        }
        for (boolean j : boAr) {
            assertEquals(j, s3.remove());
        }
        for (String j : stAr) {
            assertEquals(j, s2.remove());
        }


    }

    @Test
    void testCapacity() {
        assertEquals(s.capacity(), ar.length);
        assertEquals(s2.capacity(), stAr.length);
        assertEquals(s3.capacity(), boAr.length);
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
        assertTrue(s2.isEmpty());
        assertTrue(s3.isEmpty());

        s.insert(1);
        s2.insert("s");
        s3.insert(true);

        assertFalse(s.isEmpty());
        assertFalse(s2.isEmpty());
        assertFalse(s3.isEmpty());
    }

    @Test
    void testFront() {

        assertThrows(NoSuchElementException.class, () -> s.front(), "es solle kein front geben");
        assertThrows(NoSuchElementException.class, () -> s2.front(), "es solle kein front geben");
        assertThrows(NoSuchElementException.class, () -> s3.front(), "es solle kein front geben");

        for (int j : ar) {

            s.insert(j);
            assertEquals(s.front(), ar[0]);
        }
        for (String j : stAr) {

            s2.insert(j);
            assertEquals(s2.front(), stAr[0]);
        }
        for (Boolean j : boAr) {

            s3.insert(j);
            assertEquals(s3.front(), boAr[0]);
        }

    }
}

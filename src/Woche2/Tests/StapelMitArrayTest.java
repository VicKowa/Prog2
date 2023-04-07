package Woche2.Tests;

import Woche2.aufgabe3.StapelMitArray;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StapelMitArrayTest {

    StapelMitArray<Integer> stapel;
    StapelMitArray<String> st2;
    StapelMitArray<Boolean> st3;
    static int[] ar = {1, 2, 3, 4, 5};
    static String[] stAr = {"a", "b", "c", "d", "e"};
    static Boolean[] boAr = {true, false, false, true, true};


    @BeforeEach
    void setup() {
        stapel = new StapelMitArray<>(5);
        st2 = new StapelMitArray<>(5);
        st3 = new StapelMitArray<>(5);
    }

    @AfterEach
    void teardown() {
        stapel = null;
        st2 = null;
        st3 = null;
    }

    @Test
    void testInsertRemove() {
        assertThrows(NoSuchElementException.class, () -> stapel.remove(), "No remove");
        assertThrows(NoSuchElementException.class, () -> st2.remove(), "No remove");
        assertThrows(NoSuchElementException.class, () -> st3.remove(), "No remove");

        fill();

        assertThrows(IllegalStateException.class, () -> stapel.insert(1), "No insert");
        assertThrows(IllegalStateException.class, () -> st2.insert("s"), "No insert");
        assertThrows(IllegalStateException.class, () -> st3.insert(true), "No insert");

        for (int i = ar.length - 1; i >= 0; i--) {
            assertEquals(ar[i], stapel.remove());
            assertEquals(stAr[i], st2.remove());
            assertEquals(boAr[i], st3.remove());
        }


    }

    @Test
    void testCapacity() {
        assertEquals(stapel.capacity(), ar.length);
        assertEquals(st2.capacity(), stAr.length);
        assertEquals(st3.capacity(), boAr.length);
    }

    @Test
    void testSize() {
        assertEquals(0, stapel.size(), "size falsch");
        assertEquals(0, st2.size(), "size falsch");
        assertEquals(0, st3.size(), "size falsch");

        stapel.insert(2);
        st2.insert("s");
        st3.insert(true);

        assertEquals(1, stapel.size(), "size falsch");
        assertEquals(1, st2.size(), "size falsch");
        assertEquals(1, st3.size(), "size falsch");
    }

    @Test
    void testIsEmpty() {

        assertTrue(stapel.isEmpty());
        assertTrue(st2.isEmpty());
        assertTrue(st3.isEmpty());

        stapel.insert(1);
        st2.insert("s");
        st3.insert(true);

        assertFalse(stapel.isEmpty());
        assertFalse(st2.isEmpty());
        assertFalse(st3.isEmpty());

    }

    @Test
    void testTop() {

        assertThrows(NoSuchElementException.class, () -> stapel.top(), "es solle kein top geben");
        assertThrows(NoSuchElementException.class, () -> st2.top(), "es solle kein front geben");
        assertThrows(NoSuchElementException.class, () -> st3.top(), "es solle kein front geben");

        stapel.insert(1);
        st2.insert("s");
        st3.insert(true);
        assertEquals(1, stapel.top());
        assertEquals("s", st2.top());
        assertEquals(true, st3.top());


    }

    void fill() {
        for (int i = 0; i < stapel.capacity(); i++) {
            stapel.insert(ar[i]);
            st2.insert(stAr[i]);
            st3.insert(boAr[i]);
        }
    }

  /*  @Test
    void testApplytoAll() {

        fill();

        stapel.applyToAll((value) -> value * 2);

        for (int i = ar.length - 1; i >= 0; i--) {
            assertEquals(ar[i] * 2, stapel.remove());
        }

        fill();

        stapel.applyToAll((value) -> value * value);

        for (int i = ar.length - 1; i >= 0; i--) {
            assertEquals(ar[i] * ar[i], stapel.remove());
        }

    }


   */
}

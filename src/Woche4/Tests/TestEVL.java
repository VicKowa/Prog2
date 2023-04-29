package Woche4.Tests;

import Woche4.EVL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestEVL {

    EVL<String> evlst = new EVL<>();
    EVL<Integer> evlint = new EVL<>();
    EVL<Integer> evl2 = new EVL<>();
    EVL<Integer> evl = new EVL<>();
    EVL<Integer> evl3 = new EVL<>();
    EVL<Integer> evl4 = new EVL<>();
    String[] ar = {"Peter", "Maria" ,"Joseph", "Jona"};
    int[] feld = {1,2,3,4,5,6,7,8,9};
    int[] a1 = {4,1,7};
    int[] a2 = {3,5,2,8,6};

    @BeforeEach
    void setup() {
        for (int i = 0; i < feld.length; i++) {
            evlint.addLast(feld[i]);
        }
        for (int i = 0; i < ar.length; i++) {
            evlst.addLast(ar[i]);
        }

        for (int i = 0; i < a1.length; i++) {
            evl.addLast(a1[i]);
            evl4.addLast(a1[i]);
        }
        for (int i = 0; i < a2.length; i++) {
            evl2.addLast(a2[i]);
        }


    }
    @AfterEach
    void teardown() {
        evlint = null;
        evlst = null;
    }

    @Test
    void testGetFirst() {
        assertEquals("Peter", evlst.getFirst());
        assertEquals(1, evlint.getFirst());
    }

    @Test
    void testGetLast() {
        assertEquals(evlst.getLast(),"Jona");
        assertEquals(evlint.getLast(), 9);
    }

    @Test
    void testZip() {

        evl.zip(evl2);
        evl3.zip(evl4);
        assertEquals("4-1-7", evl3.toString());
        assertEquals("4-3-1-5-7-2-8-6",evl.toString() );

    }

    @Test
    void testRemoveLast() {

        for (int i = ar.length-1; i >= 0; i--) {
            assertEquals(evlst.removeLast(), ar[i]);
        }
        for (int i = feld.length-1; i >= 0; i--) {
            assertEquals(evlint.removeLast(), feld[i]);
        }

        assertThrows(NoSuchElementException.class, () -> evlst.removeLast());
        assertThrows(NoSuchElementException.class, () -> evlint.removeLast());


    }

    @Test
    void testContains() {
        assertFalse(evlint.contains(69));
        assertFalse(evlst.contains("hallo"));
        assertTrue(evlint.contains(5));
        assertTrue(evlst.contains("Maria"));
    }

    @Test
    void testSize() {
        assertEquals(evlst.size(), ar.length);
        assertEquals(evlint.size(), feld.length);
    }

    @Test
    void testToString() {
        assertEquals( "1-2-3-4-5-6-7-8-9", evlint.toString());
        assertEquals("Peter-Maria-Joseph-Jona", evlst.toString());
    }
}

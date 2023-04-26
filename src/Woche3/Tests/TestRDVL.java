package Woche3.Tests;

import Woche3.RDVL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestRDVL {

    int[] ar = {1,2,3,4,5};
    RDVL<Integer> rdvl;

    @BeforeEach
    void setUp() {
        rdvl = new RDVL<>();
    }
    @AfterEach
    void teardown() {
        rdvl = null;
    }

    @Test
    void testInsertRemove() {
        assertThrows(NoSuchElementException.class, () -> rdvl.remove());
        for (int i = 0; i < ar.length; i++) {
            rdvl.add(ar[i]);
        }
        //System.out.println(rdvl);
        assertEquals(1, rdvl.remove());
        assertEquals(5, rdvl.remove());
        assertEquals(4, rdvl.remove());
        assertEquals(3, rdvl.remove());
        assertEquals(2, rdvl.remove());
    }
    @Test
    void testElement() {
        assertNull(rdvl.element());
        rdvl.add(1);
        assertEquals(1, rdvl.element());
        rdvl.add(2);
        assertEquals(1, rdvl.element());
    }
    @Test
    void testPrev() {
        for (int i = 0; i < ar.length; i++) {
            rdvl.add(ar[i]);
        }
        rdvl.prev(5);
        assertEquals(1, rdvl.element());
        rdvl.prev(6);
        assertEquals(2, rdvl.element());

    }
    @Test
    void testNext() {
        for (int i = 0; i < ar.length; i++) {
            rdvl.add(ar[i]);
        }
        rdvl.next(3);
        assertEquals(3, rdvl.element());
        rdvl.next(6);
        assertEquals(2, rdvl.element());
    }
}

package Woche2.Tests;

import Woche2.aufgabe6.Paar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPaar {
    Paar<String, Integer> pair1 , pair2;
    Paar<Integer, String> pair3;
    String st1 = "test1";
    String st2 = "test2";
    int int1 = 1;
    int int2 = 2;

    @BeforeEach
    /**
     * initiiert die Paare
     */
    void setup() {
        pair1 = new Paar<>(st1, int1);
        pair2 = new Paar<>(st2, int2);
        pair3 = new Paar<>(int1, st1);
    }

    /**
     * setzt die Referenzen auf null
     */
    @AfterEach
    void teardown() {
        pair1 = null;
        pair2 = null;
        pair3 = null;
    }

    @Test
    void testGetErstes() {
        assertEquals(pair1.getErstes(), st1);
        assertEquals(pair2.getErstes(), st2);
        assertEquals(pair3.getErstes(), int1);

    }

    @Test
    void testGetZweites() {
        assertEquals(pair1.getZweites(), int1);
        assertEquals(pair2.getZweites(), int2);
        assertEquals(pair3.getZweites(), st1);
    }
    @Test
    void testSetErstes() {
        assertEquals(pair1.setErstes("auto"), st1);
        assertEquals(pair2.setErstes("mercedes"), st2);
        assertEquals(pair3.setErstes(124), int1);

        assertEquals(pair1.getErstes(), "auto");
        assertEquals(pair2.getErstes(), "mercedes");
        assertEquals(pair3.getErstes(), 124);


    }

    @Test
    void testSetZweites() {
        assertEquals(pair1.setZweites(546), int1);
        assertEquals(pair2.setZweites(28903), int2);
        assertEquals(pair3.setZweites("ja"), st1);

        assertEquals(pair1.getZweites(), 546);
        assertEquals(pair2.getZweites(), 28903);
        assertEquals(pair3.getZweites(), "ja");
    }

    @Test
    void testSetBeide() {
        pair1.setBeide("hallo", 999);
        pair2.setBeide("hallo2", 123);
        pair3.setBeide(7, "baum");

        assertEquals(pair1.getErstes(), "hallo");
        assertEquals(pair2.getErstes(), "hallo2");
        assertEquals(pair3.getErstes(), 7);

        assertEquals(pair1.getZweites(), 999);
        assertEquals(pair2.getZweites(), 123);
        assertEquals(pair3.getZweites(), "baum");
    }

    @Test
    void testEquals() {
        assertFalse(pair1.equals(pair2));
        assertFalse(pair2.equals(pair1));
        assertTrue(pair1.equals(pair1));
        assertTrue(pair1.equals(pair1));
    }

    @Test
    void testToString(){
        assertEquals(pair1.toString(),"("+ st1 + "," + int1 + ")");
        assertEquals(pair2.toString(),"("+ st2 + "," + int2 + ")");
        assertEquals(pair3.toString(),"("+ int1 + "," + st1 + ")");
    }
}

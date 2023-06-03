package woche9.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woche7.Folge;
import woche9.Boxer;
import woche9.ComparatorBoxerGewicht;
import woche9.Suchbaum;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSuchbaum {

    Suchbaum<Boxer> boxerSuchbaum ;
    Suchbaum<Boxer> boxerSuchbaum2 ;

    Boxer[] b = {
            new Boxer("Solo", "Han", 90),
            new Boxer("Skywalker", "Anakin", 85),
            new Boxer("Skywalker", "Luke", 85),
            new Boxer("YO", "Da", 30),
            new Boxer("Windu", "Mace", 100)
    };

    @BeforeEach
    void setup() {
        boxerSuchbaum = new Suchbaum<>(new ComparatorBoxerGewicht());
        boxerSuchbaum2 = new Suchbaum<>();
    }

    @AfterEach
    void teardown() {
        boxerSuchbaum = null;
        boxerSuchbaum2 = null;
    }

    @Test
    void testInsertComparator() {
        for (Boxer i: b) {
            boxerSuchbaum.insert(i);
        }
        System.out.println(boxerSuchbaum);
    }

    @Test
    void testInsertComparable() {
        for (Boxer i: b) {
            boxerSuchbaum2.insert(i);
        }
        System.out.println(boxerSuchbaum2);
    }

    @Test
    void testHoehe() {
        for (Boxer i: b) {
            boxerSuchbaum.insert(i);
            boxerSuchbaum2.insert(i);
        }
        assertEquals(3,boxerSuchbaum.hoehe());
        assertEquals(3,boxerSuchbaum2.hoehe());
    }

    @Test
    void testSize() {
        for (Boxer i: b) {
            boxerSuchbaum.insert(i);
            boxerSuchbaum2.insert(i);
        }
        assertEquals(b.length-1,boxerSuchbaum.size());
        assertEquals(b.length,boxerSuchbaum2.size());

    }

    @Test
    void testPreorder() {
        for (Boxer i: b) {
            boxerSuchbaum2.insert(i);
        }
        Folge<Boxer> f = boxerSuchbaum2.preorder();
        System.out.println(f);


    }

}

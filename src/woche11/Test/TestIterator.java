package woche11.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woche11.aufgabe4.DynArray;
import woche11.aufgabe4.EVL;
import woche11.aufgabe4.FolgeMitDynArray;
import woche11.aufgabe4.SchlangeMitEVL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIterator {

    EVL<Integer> evl;
    DynArray<Integer> dynArray;
    FolgeMitDynArray<Integer> folgeMitDynArray;
    SchlangeMitEVL<Integer> schlangeMitEVL;

    int[] ar = {1,2,3,4,5};

    @BeforeEach
    void setup() {
        evl = new EVL<>();
        dynArray = new DynArray<>();
        folgeMitDynArray = new FolgeMitDynArray<>();
        schlangeMitEVL = new SchlangeMitEVL<>();
    }

    @AfterEach
    void teardown() {
        evl = null;
        dynArray = null;
    }

    @Test
    void testEVLIterator() {
        for (int i: ar) {
            evl.addLast(i);
        }
        int i = 0;
        for (int element: evl) {
            assertEquals(ar[i], element);
            i++;
        }
    }

    @Test
    void testDynArrayIterator() {
        for (int i: ar) {
            dynArray.addLast(i);
        }
        int i = 0;
        for (int element: dynArray) {
            assertEquals(ar[i], element);
            i++;
        }
    }

    @Test
    void testSchlangeMitEVLIterator() {
        for (int i: ar) {
            schlangeMitEVL.insert(i);
        }

        int i = 0;
        for (int element: schlangeMitEVL) {
            assertEquals(ar[i], element);
            i++;
        }
    }

    @Test
    void testFolgeMitDynArrayIterator() {
        for (int i: ar) {
            folgeMitDynArray.insert(i);
        }

        int i = 0;
        for (int element: folgeMitDynArray) {
            assertEquals(ar[i], element);
            i++;
        }
    }
}

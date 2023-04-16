package Woche2.Tests;

import org.junit.jupiter.api.Test;

import static Woche2.zusatzaufgabe.ProjektEuler.euler;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProjektEuler {

    @Test
    void testEuler() {
        assertEquals(euler(10), 23);
        assertEquals(euler(1000), 233168);
    }
}

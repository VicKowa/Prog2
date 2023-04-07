package Tests;

import aufgabe3.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStudent {

    Student s1, s2 , s3;

    @BeforeEach
    void setup() {
        s1 = new Student("helene", "magda", 69);
        s2 = new Student("helene", "magda", 69);
        s3 = new Student("helene", "magda", 69);
    }

    @AfterEach
    void teardown() {
        s1 = null;
        s2 = null;
        s3 = null;
    }

    @Test
    void testReflexivitaet() {

        assertTrue(s1.equals(s1),"no reflexivität");
    }

    @Test
    void testSymmetrie() {
        assertTrue(s1.equals(s2), "no symmetrie");
        assertTrue(s2.equals(s1), "no symmetrie");
    }

    @Test
    void testTransitivitaet() {
        assertTrue(s1.equals(s2), "no transitivitaet: x!=y");
        assertTrue(s2.equals(s3), "no transitivitaet: y!=z");
        assertTrue(s1.equals(s3), "no transitivitaet: x!=z");
    }

    @Test
    void testKonsistenz() {
        s3 = new Student("Angela", "Merkel", 69);
        for(int i = 0; i < 100; i++) {
            assertTrue(s1.equals(s2), "no konsistenz");
        }
        for(int i = 0; i < 100; i++) {
            assertFalse(s1.equals(s3), "no konsistenz");
        }

    }

    @Test
    void testNullVerschiedenheit() {
        s3 = new Student("Angela", "Merkel", 69);
        assertFalse(s1.equals(null), "no difference to null");
        assertFalse(s3.equals(null), "no difference to null");
    }


}

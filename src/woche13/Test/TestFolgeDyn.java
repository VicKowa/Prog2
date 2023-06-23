package woche13.Test;


import Woche1.aufgabe3.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woche11.aufgabe4.Puffer;
import woche11.aufgabe4.SchlangeMitEVL;
import woche13.FolgeMitDynArray;
import woche9.Boxer;

public class TestFolgeDyn {

    FolgeMitDynArray<Person> f;
    Puffer<Person> pp;
    Puffer<Boxer> pb;
    FolgeMitDynArray<Boxer> f2;
    @BeforeEach
    void setUp() {

        f2 = new FolgeMitDynArray<>();
        f = new FolgeMitDynArray<>();
        pp = new SchlangeMitEVL<>();
        pb = new SchlangeMitEVL<>();

        f.insert(new Person("Mustermann", "Max"));
        f2.insert(new Boxer("k","l", 23));

        pp.insert(new Person("A", "B"));
        pp.insert(new Person("C", "D"));

        pb.insert(new Boxer("s", "d", 124));
        pb.insert(new Boxer("tg", "f", 125));


    }

    @Test
    void testAddAll() {

        f.addAll(pb);
    }

    @Test
    void testAddAllTo() {
        f2.addAllTo(pp);
    }
}

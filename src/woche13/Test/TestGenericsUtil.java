package woche13.Test;

import Woche1.aufgabe3.Person;
import org.junit.jupiter.api.Test;
import woche11.aufgabe4.Folge;
import woche11.aufgabe4.FolgeMitDynArray;
import woche11.aufgabe4.Puffer;
import woche13.GenericUtil;
import woche9.Boxer;
import woche9.ComparatorPersonVornameName;
import woche9.Student;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Obst implements Comparable<Obst> {
    private int kgPreis;
    public Obst(int kgPreis) {
        this.kgPreis = kgPreis;
    }

    @Override
    public int compareTo(Obst o) {
        return this.kgPreis - o.kgPreis;
    }

    public int getKgPreis() {
        return kgPreis;
    }

}


class Apfel extends Obst {
    public Apfel(int kgPreis) {
        super(kgPreis);
    }
}
class Birne extends Obst {
    public Birne(int kgPreis) {
        super(kgPreis);
    }
}


public class TestGenericsUtil {

    @Test
    void testGetMinimaNaturalOrder() {

        Puffer<Obst> pa = new FolgeMitDynArray<>();
        Puffer<Obst> pb = new FolgeMitDynArray<>();

        pa.insert(new Apfel(2));
        pa.insert(new Apfel(4));
        pa.insert(new Apfel(5));

        pb.insert(new Birne(1));
        pb.insert(new Birne(6));

        Folge<Obst> f = GenericUtil.getMinima(pa, pb);

        int[] sol = {1,4,5};

        for (int i = 0; i < sol.length; i++) {
            Obst el = f.get(i);
            assertEquals(sol[i],el.getKgPreis());
        }
    }

    @Test
    void testNaturalOrderGetMinimaWithTwoApfelPuffer() {
        Puffer<Apfel> p1 = new FolgeMitDynArray<>();
        Puffer<Apfel> p2 = new FolgeMitDynArray<>();

        p1.insert(new Apfel(2));
        p2.insert(new Apfel(1));

        Folge<?> f = GenericUtil.getMinima(p1, p2);
    }

    @Test
    public void testComparatorMethodGetMinima() {

        Puffer<Student> ps = new FolgeMitDynArray<>();
        Puffer<Boxer> pb = new FolgeMitDynArray<>();

        Comparator<Person> comp = new ComparatorPersonVornameName();

        ps.insert(new Student("Apple", "Solo", 123));
        pb.insert(new Boxer("Apples", "Solo", 80));
        ps.insert(new Student("hallo", "X", 234));
        pb.insert(new Boxer("hi","Y", 120));

        Folge<Person> f = GenericUtil.getMinima(ps,pb, comp);
        System.out.println(f);
    }


}

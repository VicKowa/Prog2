package woche7.Tests;

import Woche4.SchlangeMitEVL;
import woche7.FolgeMitDynArray;
import woche7.SchlangeMitRing;

public class TimeTestSchlange {
    public static void main(String[] args) {
        SchlangeMitRing<Integer> ring = new SchlangeMitRing<>(50000);
        SchlangeMitEVL<Integer> evl = new SchlangeMitEVL<>();
        FolgeMitDynArray<Integer> fd = new FolgeMitDynArray<>();
        long start, finish, elapsed;

        for (int i = 0; i < 50000; i++) {
            ring.insert(i);
            evl.insert(i);
            fd.insert(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 50000 ; i++) {
            ring.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;

        System.out.println("Laufzeit Schlange mit Ring: " + elapsed);

        start = System.currentTimeMillis();
        for (int i = 0; i < 50000 ; i++) {
            evl.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;

        System.out.println("Laufzeit für Schlange mit EVL: " + elapsed);

        start = System.currentTimeMillis();
        for (int i = 0; i < 50000 ; i++) {
            fd.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;

        System.out.println("Laufzeit Folge mit DynArray: " + elapsed);
    }
}

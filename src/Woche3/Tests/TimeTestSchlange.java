package Woche3.Tests;

import Woche2.aufgabe3.SchlangeMitArray;
import Woche3.SchlangeMitEVL;

public class TimeTestSchlange {
    public static void main(String[] args) {
        SchlangeMitArray<Integer> ar = new SchlangeMitArray<>(100000);
        SchlangeMitEVL<Integer> evl = new SchlangeMitEVL<>();
        long start, finish, elapsed;

        for (int i = 0; i < 100000; i++) {
            ar.insert(i);
            evl.insert(i);
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++) {
            ar.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;

        System.out.println("Laufzeit Schlange mit Array: " + elapsed);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++) {
            evl.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;

        System.out.println("Laufzeit für Schlange mit EVL: " + elapsed);



    }
}

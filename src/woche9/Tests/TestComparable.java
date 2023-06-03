package woche9.Tests;

import woche9.Boxer;
import woche9.ComparatorBoxerGewicht;
import woche9.ComparatorPersonVornameName;

import java.util.Arrays;

public class TestComparable {
    public static void main(String[] args) {
        ComparatorBoxerGewicht compB;
        ComparatorPersonVornameName compP;

        Boxer[] b = {
                new Boxer("apple", "han", 90),
                new Boxer("apple", "hanooooo", 90),
                new Boxer("Anna", "Dumm", 70)
        };
        Arrays.sort(b);

        for (Boxer i: b) {
            System.out.println(i);
        }
    }
}

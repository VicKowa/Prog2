package woche12;

import woche11.aufgabe4.*;

import java.util.Comparator;
import java.util.Iterator;

public class GenericUtil {

    public static <T> T gambling(T e1, T e2) {
        return (Math.random() > 0.5) ? e1 : e2;
    }

    public static <T> Puffer<T> gambling(Puffer<T> p1, Puffer<T> p2) {
        return (Math.random() > 0.5) ? p1 : p2;
    }

    public static <T> Schlange<T> arrayToSchlange(T[] array) {
        Schlange<T> schlange = new SchlangeMitEVL<>();
        for (T element : array) {
            schlange.insert(element);
        }
        return schlange;
    }

    public static <T> void printAll(Iterable<T> ob) {
        for (T element : ob) {
            System.out.println(element);
        }
    }

    public static <U> void insertInto(Puffer<U> puff, U[] ar) {
        for (U element : ar) {
            puff.insert(element);
        }
    }

    public static <U> void insertInto(Puffer<U> p1, Puffer<U> p2) {

        while (!p2.isEmpty()) {
            U temp = p2.remove();
            p1.insert(temp);
        }
    }

    public static <T extends Comparable<T>> Folge<T> getMinima(Puffer<T> p1, Puffer<T> p2) {

        return getMinima(p1, p2, (e1, e2) -> e1.compareTo(e2));
    }



    public static <T extends Comparable<T>> Folge<T> getMinima(Puffer<T> p1, Puffer<T> p2, Comparator<T> comp) {
        Folge<T> folge = new FolgeMitDynArray<>();
        Iterator<T> temp;
        Iterator<T> it1, it2;

        it1 = p1.iterator();
        it2 = p2.iterator();
        while (it1.hasNext() && it2.hasNext()) {

            T e1 = it1.next();
            T e2 = it2.next();

            if (e1.compareTo(e2) >= 0) {
                folge.insert(e2);
            } else folge.insert(e1);

        }

        if (it1.hasNext()) {
            temp = it1;
        } else temp = it2;

        while (temp.hasNext()) {
            folge.insert(temp.next());
        }

        return folge;
    }


}

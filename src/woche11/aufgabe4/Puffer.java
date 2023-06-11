package woche11.aufgabe4;

import java.util.Iterator;

public interface Puffer<T> extends Iterable<T> {

    boolean isEmpty();
    int size();
    int capacity();
    void insert(T e);
    T remove();
    @Override
    Iterator<T> iterator();
}
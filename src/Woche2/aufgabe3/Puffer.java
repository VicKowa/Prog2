package Woche2.aufgabe3;

public interface Puffer<T> {

    boolean isEmpty();
    int size();
    int capacity();
    void insert(T e);
    T remove();
}

package woche7;

import Woche2.aufgabe3.Puffer;

public interface Folge <T> extends Puffer<T> {

    T get(int pos);
    T set(int pos, T e);
    T remove(int pos);
    void insert(int pos, T e);

}

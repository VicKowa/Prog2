package woche7;

import Woche2.aufgabe3.Schlange;
import Woche5.NoCapacityInArray;
import Woche5.Ringpuffer;

import java.util.NoSuchElementException;

public class SchlangeMitRing<T> implements Schlange<T> {

    Ringpuffer<T> r;

    public SchlangeMitRing(int capacity) {
        r = new Ringpuffer<>(capacity);
    }
    @Override
    public boolean isEmpty() {
        return r.size() <= 0;
    }

    @Override
    public int size() {
        return r.size();
    }

    @Override
    public int capacity() {
        return r.capacity();
    }

    @Override
    public void insert(T e) throws NoCapacityInArray {
        r.addLast(e);
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return r.removeFirst();
    }

    @Override
    public T front() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return r.get(1);
    }
}

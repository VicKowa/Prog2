package Woche2.aufgabe3;

import java.util.NoSuchElementException;

public class SchlangeMitArray<T> implements Schlange<T> {

    private T[] schlange;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public SchlangeMitArray(int maxGroesse) {

        schlange = (T[]) new Object[maxGroesse];
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int capacity() {
        return schlange.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T e) throws IllegalStateException {
        if (size == schlange.length) {
            throw new IllegalStateException();
        } else {
            schlange[size++] = e;
        }
    }

    @Override
    public T remove() throws NoSuchElementException {
        T value;

        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            value = schlange[0];
            for (int i = 0; i < size-1 ; i++) {
                schlange[i] = schlange[i + 1];
            }
        }
        return value;
    }

    @Override
    public T front() throws NoSuchElementException {

        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return schlange[0];
        }

    }
}
package Woche3;

import Woche2.aufgabe3.Schlange;

import java.util.NoSuchElementException;

public class SchlangeMitEVL<T> implements Schlange<T> {

    private EVL<T> schlange;

    public SchlangeMitEVL() {
        schlange = new EVL<>();

    }

    @Override
    public boolean isEmpty() {
        return size() <= 0;
    }

    @Override
    public T front() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return schlange.getFirst();
        }
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int size() {
        return schlange.size();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            T[] memory = (T[]) new Object[schlange.size()];
            T output;
            for (int i = memory.length - 1; i > 0; i--) {
                memory[i] = schlange.removeLast();
            }
            output = schlange.removeLast();
            for (int i = 1; i < memory.length; i++) {
                schlange.addLast(memory[i]);
            }
            return output;
        }

    }

    @Override
    public void insert(T e) {
        schlange.addLast(e);
    }
}

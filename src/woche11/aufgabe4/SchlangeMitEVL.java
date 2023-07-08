package woche11.aufgabe4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SchlangeMitEVL<T> implements Schlange<T>, Iterable<T> {

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
    public T remove() throws NoSuchElementException {
        return schlange.removeFirst();
    }

    @Override
    public void insert(T e) {
        schlange.addLast(e);
    }

    @Override
    public Iterator<T> iterator() {
        return schlange.iterator();
    }
}

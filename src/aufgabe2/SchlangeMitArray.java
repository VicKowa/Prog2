package aufgabe2;

import java.util.NoSuchElementException;

public class SchlangeMitArray implements Schlange {

    private int[] schlange;
    private int size = 0;

    public SchlangeMitArray(int maxGroesse) {

        schlange = new int[maxGroesse];
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
    public void insert(int e) throws IllegalStateException {
        if (size == schlange.length) {
            throw new IllegalStateException();
        } else {
            schlange[size++] = e;
        }
    }

    @Override
    public int remove() throws NoSuchElementException {
        int value;

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
    public int front() throws NoSuchElementException {

        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return schlange[0];
        }

    }
}
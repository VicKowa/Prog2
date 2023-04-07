package aufgabe2;

import java.util.NoSuchElementException;

public class StapelMitArray implements Stapel{

    private int[] stack;
    private int currentsize = 0;

    public StapelMitArray(int maxGroesse) {
        this.stack = new int[maxGroesse];
    }

    @Override
    public boolean isEmpty() {
        return currentsize <= 0;
    }

    @Override
    public int capacity() {
        return stack.length;
    }

    @Override
    public int size() {
        return this.currentsize;
    }

    @Override
    public void insert(int e) throws IllegalStateException {
        if (this.currentsize == stack.length) {
            throw new IllegalStateException();
        } else {
            stack[this.currentsize++] = e;
        }
    }

    @Override
    public int remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return stack[--currentsize];
        }

    }

    @Override
    public int top() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return stack[--this.currentsize];
        }

    }
}

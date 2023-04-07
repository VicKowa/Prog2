package Woche1.aufgabe2;

import java.util.NoSuchElementException;

public class StapelMitArray implements Woche1.aufgabe2.Stapel {

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

    public void applyToAll(Funktion func) {

        int[] inArray = new int[capacity()]; //internes Array
        for (int i = stack.length - 1; i >= 0; i--) {

            inArray[i] = func.auswerten(remove());
        }

        for (int j : inArray) {

            insert(j);
        }

    }
}

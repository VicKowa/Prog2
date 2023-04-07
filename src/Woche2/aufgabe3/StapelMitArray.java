package Woche2.aufgabe3;

import java.util.NoSuchElementException;

public class StapelMitArray<T> implements Stapel<T> {

    private T[] stack;
    private int currentsize = 0;
    @SuppressWarnings("unchecked")
    public StapelMitArray(int maxGroesse) {
        this.stack = (T[]) new Object[maxGroesse];
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
    public void insert(T e) throws IllegalStateException {
        if (this.currentsize == stack.length) {
            throw new IllegalStateException();
        } else {
            stack[this.currentsize++] = e;
        }
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return stack[--currentsize];
        }

    }

    @Override
    public T top() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return stack[--this.currentsize];
        }

    }

    /*public void applyToAll(Funktion func) {
        @SuppressWarnings("unchecked")
        T[] inArray = (T[]) new Object[capacity()]; //internes Array
        for (int i = stack.length - 1; i >= 0; i--) {

            inArray[i] = (T) func.auswerten(remove());
        }

        for (T j : inArray) {

            insert(j);
        }

    }

     */


}

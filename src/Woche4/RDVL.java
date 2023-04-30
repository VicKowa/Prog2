package Woche4;

import java.util.NoSuchElementException;

public class RDVL<T> {
    private ListenEL entry;
    private int size;

    private class ListenEL {
        ListenEL next;
        ListenEL previous;
        T data;
        ListenEL(T o) {
            data = o;
            next = null;
            previous = null;
        }
    }

    public Boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }

    public void add(T e) {
        ListenEL temp = new ListenEL(e);
        if(entry == null) {
            entry = temp;
            entry.next = entry;
            entry.previous = entry;
        } else {
            entry.next.previous = temp;
            temp.next = entry.next;
            entry.next = temp;
            temp.previous = entry;

        }
        size++;

    }

    public T remove() throws NoSuchElementException {
        ListenEL rm = null;
        if(entry == null) {
            throw new NoSuchElementException();
        } else if (size == 1) {
            rm = entry;
            entry = null;
        } else {
            ListenEL temp = entry.next;
            ListenEL temp2 = entry.previous;
            rm = entry;
            entry = entry.next;
            temp2.next = temp;
            temp.previous = temp2;

        }
        size--;
        return rm.data;
    }
    public T element() {
        if(entry == null) {
            return null;
        } else return entry.data;
    }

    public void next(int s) throws NoSuchElementException {

        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            for (int i = 0; i < s; i++) {
                entry = entry.next;
            }
        }
    }

    public void prev(int s) throws NoSuchElementException {

        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            for (int i = 0; i < s; i++) {
                entry = entry.previous;
            }
        }
    }
    public T previous() {
        return entry.previous.data;
    }
    public T next() {
        return entry.next.data;
    }

    @Override
    public String toString() {
        ListenEL first = entry;
        ListenEL temp = entry;
        String ausgabe = entry.data.toString();
        while (temp.next != first) {
            ausgabe += ", " + temp.next.data.toString();
            temp = temp.next;
        }
        return ausgabe;
    }
}

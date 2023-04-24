package Woche3;

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
            temp.next = temp;
            temp.previous = temp;
        } else {
            ListenEL temp2 = entry.previous;
            entry.previous = temp;
            temp2.next = temp;
            temp.previous = temp2;


        }

    }

    public T remove() throws NoSuchElementException {

        if(entry == null) {
            throw new NoSuchElementException();
        } else {
            ListenEL rm = entry;
            ListenEL temp = entry.previous;
            ListenEL temp2 = entry.next;

            temp.next = temp2;
            temp2.previous = temp;
            size--;
            return entry.data;
        }
    }
    public T element() {
        return entry.data;
    }

    public void next(int s) throws NoSuchElementException {

        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            ListenEL temp = null;
            for (int i = 0; i < s; i++) {
                temp = entry.next;
            }
            entry = temp;
        }
    }

    public void prev(int s) throws NoSuchElementException {

        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            ListenEL temp = null;
            for (int i = 0; i < s; i++) {
                temp = entry.previous;
            }
            entry = temp;
        }
    }
}

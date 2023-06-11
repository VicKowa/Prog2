package woche11.aufgabe1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray<T> implements Iterator<T> {

    private int i = 0;
    private int end;
    private T[] ar;

    public Iterator1DArray(T[] array) {
        ar = array;
        end = ar.length;
    }

    public Iterator1DArray(T[] array, int start) {
        this(array);
        i = start;
    }

    public Iterator1DArray(T[] array, int start, int ende) {
        this(array, start);
        end = ende;
    }
    @Override
    public boolean hasNext() {
        return i < end;
    }

    @Override
    public T next() throws NoSuchElementException {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }

        return ar[i++];
    }
}

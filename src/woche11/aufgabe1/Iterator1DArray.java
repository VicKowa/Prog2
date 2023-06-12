package woche11.aufgabe1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray<T> implements Iterator<T> {

    private int i;
    private int end;
    private T[] ar;

    public Iterator1DArray(T[] array) {
        this(array, 0, array.length);
    }

    public Iterator1DArray(T[] array, int start) {
        this(array, start, array.length);
    }

    public Iterator1DArray(T[] array, int start, int ende) {
        ar = array;
	    i = start;
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

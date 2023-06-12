package woche11.aufgabe2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SnakeIterator2DArray<T> implements Iterator<T> {
    private int i;
    private int j;
    private T[][] ar;

    public SnakeIterator2DArray(T[][] array) {
        ar = array;
        i = 0;
        j = 0;
    }

    @Override
    public boolean hasNext() {
        return i < ar.length & (j < ar[0].length | j >= 0);
    }

    @Override
    public T next() throws NoSuchElementException {
        T output;

        if (!hasNext()) throw new NoSuchElementException();

        if ((i % 2) != 0) {
            output = ar[i][(ar[0].length - 1) - j];
        } else {
            output = ar[i][j];
        }


        if ((j == ar[0].length - 1) & i < ar.length-1) {
            j = 0;
            i++;
        } else j++;
        return output;
    }
}

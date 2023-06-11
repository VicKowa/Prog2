package woche11.aufgabe4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Klasser für ein dynamisches Array
 * 29.4.23
 *
 * @param <T> Typparameter vom Array
 * @author vkowal2s
 * @version 1.0
 */
public class DynArray<T> implements Iterable<T> {
    private int size;
    private int capacity;
    private T[] darray;

    /**
     * erzeugt ein Objekt der Klasse DynArray setzt die Startspeichergröße auf eins
     */
    @SuppressWarnings("unchecked")
    public DynArray() {
        darray = (T[]) new Object[1];
        capacity = 1;
        size = 0;
    }

    /**
     * @return gibt die aktuelle size zurück
     */
    public int size() {
        return size;
    }

    /**
     * @return gibt die aktuelle capacity zurück
     */
    public int capacity() {
        return capacity;
    }

    /**
     * gibt das element am index pos aus
     *
     * @param pos position, welche ausgegeben werden soll
     * @return gibt den Inhalt des Arrays an pos zurück
     * @throws IndexOutOfBoundsException falls ein nicht erlaubter index übergeben wird
     */
    public T get(int pos) throws IndexOutOfBoundsException {
        exceptionPosCheck(pos);
        return darray[pos];

    }

    /**
     * setzt den Wert e an Postion pos im Array und gibt den alten Wert zurück
     *
     * @param pos position, wo überschrieben werden soll
     * @param e   neuer Wert, welcher eingefügt werden soll
     * @return gibt alten Wert zurück
     * @throws IndexOutOfBoundsException falls ein nicht erlaubter index übergeben wird
     */
    public T set(int pos, T e) throws IndexOutOfBoundsException {
        exceptionPosCheck(pos);
        T temp = darray[pos];
        darray[pos] = e;
        return temp;

    }

    /**
     * fügt einen neuen Wert an der ersten Stelle des Arrays ein,
     * falls Array voll, wird ein neues Array erzeugt mit doppelter Capacity
     *
     * @param e neuer Wert
     */

    public void addFirst(T e) {

        if (size == capacity) {
            increase();
        }
        for (int i = darray.length - 1; i > 0; i--) {
            if (darray[i - 1] != null) {
                darray[i] = darray[i - 1];
            }
        }
        darray[0] = e;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void increase() {
        T[] newArray = (T[]) new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = darray[i];
        }
        darray = newArray;
        capacity *= 2;
    }

    /**
     * fügt den neuen Inhalt hinter dem letzten Wert des Arrays ein
     *
     * @param e Wert der eingefügt werden soll
     */
    @SuppressWarnings("unchecked")
    public void addLast(T e) {
        if (size == capacity) {
            increase();
        }
        darray[size++] = e;
    }

    /**
     * löscht den ersten Wert im Array und gibt den Wert zurück
     *
     * @return Wert der gelöscht wird
     * @throws NoSuchElementException falls das Array leer ist
     */

    public T removeFirst() throws NoSuchElementException {
        T temp = darray[0];
        if (size <= 0) {
            throw new NoSuchElementException();
        } else if (((size - 1.0) / capacity) <= (1.0 / 4.0)) {
            decrease();
        }

        for (int i = 0; i < darray.length - 1; i++) {
            darray[i] = darray[i + 1];
        }
        size--;
        return temp;
    }

    @SuppressWarnings("unchecked")
    private void decrease() {
        T[] newArray = (T[]) new Object[capacity / 2];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = darray[i];
        }
        capacity /= 2;
        darray = newArray;
    }

    public T removeLast() throws IndexOutOfBoundsException {
        T temp = darray[size - 1];
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        } else if (((size - 1.0) / capacity) <= (1.0 / 4.0)) {
            decrease();
        }
        darray[--size] = null;
        return temp;
    }

    public T remove(int pos) throws IndexOutOfBoundsException {
        exceptionPosCheck(pos);
        if (((size - 1.0) / capacity) <= (1.0 / 4.0)) {
            decrease();
        }
        T temp = darray[pos];
        for (int i = pos; i < darray.length-1 ; i++) {
            darray[pos] = darray[pos+1];
        }
        size--;
        return temp;
    }

    public void insert(int pos, T e) throws IndexOutOfBoundsException {
        exceptionPosCheck(pos);
        if (size == capacity) {
            increase();
        }
        for (int i = size-1; i >= pos; i--) {
            darray[i+1] = darray[i];
        }
        darray[pos] = e;
        size++;
    }



    private void exceptionPosCheck(int pos) throws IndexOutOfBoundsException {
        if (pos < 0 | pos >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String toString() {
        if (size == 0) {
            return null;
        } else {
            String aus = "(" + darray[0].toString();
            for (int i = 1; i < darray.length; i++) {
                aus += "," + darray[i];
            }
            return aus + ")";
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DynArrayIterator();
    }

    private class DynArrayIterator implements Iterator<T> {
        private int i;

        public DynArrayIterator() {
            i = 0;
        }
        public T next() throws NoSuchElementException {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return darray[i++];
        }

        public boolean hasNext() {
            return i < size;
        }
    }
}

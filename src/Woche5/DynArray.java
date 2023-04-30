package Woche5;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

/**
 * Klasser für ein dynamisches Array
 * 29.4.23
 *
 * @param <T> Typparameter vom Array
 * @author vkowal2s
 * @version 1.0
 */
public class DynArray<T> {
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
     * @throws InvalidParameterException falls ein nicht erlaubter index übergeben wird
     * @throws NullPointerException      falls die Position leer ist
     */
    public T get(int pos) throws InvalidParameterException, NullPointerException {
        if (pos < 0 | pos >= capacity) {
            throw new InvalidParameterException();
        } else if (darray[pos] == null) {
            throw new NullPointerException();
        } else {
            return darray[pos];
        }
    }

    /**
     * setzt den Wert e an Postion pos im Array und gibt den alten Wert zurück
     *
     * @param pos position, wo überschrieben werden soll
     * @param e   neuer Wert, welcher eingefügt werden soll
     * @return gibt alten Wert zurück
     * @throws InvalidParameterException falls ein nicht erlaubter index übergeben wird
     * @throws NullPointerException      falls die Position leer ist, weil nur überschreiben erlaubt
     */
    public T set(int pos, T e) throws InvalidParameterException, NullPointerException {
        if (pos < 0 | pos >= capacity) {
            throw new InvalidParameterException();
        } else if (darray[pos] == null) {
            throw new NullPointerException();
        } else {
            T temp = darray[pos];
            darray[pos] = e;
            return temp;
        }
    }

    /**
     * fügt einen neuen Wert an der ersten Stelle des Arrays ein,
     * falls Array voll, wird ein neues Array erzeugt mit doppelter Capacity
     *
     * @param e neuer Wert
     */
    @SuppressWarnings("unchecked")
    public void addFirst(T e) {
        if (size + 1 <= capacity) {
            for (int i = darray.length - 1; i > 0; i--) {
                if (darray[i - 1] != null) {
                    darray[i] = darray[i - 1];
                }
            }
            darray[0] = e;
        } else {
            T[] newArray = (T[]) new Object[capacity * 2];
            newArray[0] = e;
            for (int i = 0; i < darray.length; i++) {
                newArray[i+1] = darray[i];
            }
            darray = newArray;
            capacity *= 2;
        }
        size++;
    }

    /**
     * fügt den neuen Inhalt hinter dem letzten Wert des Arrays ein
     * @param e Wert der eingefügt werden soll
     */
    @SuppressWarnings("unchecked")
    public void addLast(T e) {
        if(size + 1 <= capacity) {
            darray[size++] = e;
        } else {
            T[] newArray = (T[]) new Object[capacity * 2];
            for (int i = 0; i < darray.length; i++) {
                newArray[i] = darray[i];
            }

            darray = newArray;
            darray[size++] = e;
            capacity *= 2;
        }
    }

    /**
     * löscht den ersten Wert im Array und gibt den Wert zurück
     * @return Wert der gelöscht wird
     * @throws NoSuchElementException falls das Array leer ist
     */
    @SuppressWarnings("unchecked")
    public T removeFirst() throws NoSuchElementException {
        T temp = darray[0];
        if (size <= 0) {
            throw new NoSuchElementException();
        } else if (((double)(size - 1) / capacity) <= ((double) 1 / 4)) {

            T[] newArray = (T[]) new Object[capacity / 2];

            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = darray[i+1];
            }
            capacity /= 2;
            darray = newArray;
        } else {
            for (int i = 0; i < darray.length - 1; i++) {
                darray[i] = darray[i+1];
            }
        }
        size--;
        return temp;
    }
    @SuppressWarnings("unchecked")
    public T removeLast() throws  ArrayIndexOutOfBoundsException{
        T temp = darray[size - 1];
        if (size <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (((double)(size - 1) / capacity) <= ((double) 1 / 4)) {

            T[] newArray = (T[]) new Object[capacity / 2];

            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = darray[i];
            }
            capacity /= 2;
            darray = newArray;
            darray[size - 1] = null;
        } else {
            darray[size - 1] = null;
        }
        size--;
        return temp;
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
}

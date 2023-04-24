package Woche3;

import javax.print.attribute.standard.MediaSize;
import java.util.NoSuchElementException;

public class EVL <T>{
    private ListenEl first = null;
    private int size = 0;


    public T getFirst() throws NoSuchElementException {
        if(first == null) {
            throw new NullPointerException();
        } else {
            return first.data;
        }

    }

    public void addFirst(T e) {
        ListenEl temp = new ListenEl(e);
        if (first == null) {
            first = temp;
        } else {
            temp.next = first;
            first = temp;
        }
        size++;
    }

    public T removeFirst() throws NoSuchElementException {

        if (first == null) {
            throw new NoSuchElementException();
        } else {
           ListenEl temp;
           temp = first;
           first = first.next;
           size--;
           return temp.data;
        }
    }

    public void zip(EVL<T> other) {

        ListenEl temp1, temp2;
        temp1 = first;
        if(this.size() == 0) {
            while(other.size() > 0) {
                this.addLast(other.removeFirst());
            }
        } else {
                temp2 = temp1.next;

                while( temp2 != null) {
                    ListenEl otherEL = new ListenEl(other.removeFirst());
                    temp1.next = otherEL;
                    otherEL.next = temp2;
                    temp1 = temp2;
                    temp2 = temp1.next;
                }

                while (other.size != 0) {
                    this.addLast(other.removeFirst());
                }
        }



    }

    public T getLast() throws NullPointerException {
        if(first == null) {
            throw new NullPointerException();
        } else {
            if (size == 1) {
                return first.data;
            } else {
                ListenEl temp = first.next;
                while (temp.next != null) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }
    }
    public void addLast(T e) {
        ListenEl newEl = new ListenEl(e);

        if (size == 0) {
            first = newEl;
            size++;
        } else {
            ListenEl temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newEl;
            size++;
        }
    }

    public T removeLast() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        } else if (size == 1) {
            T e = first.data;
            first = null;
            size--;
            return e;
        } else {
            T e;
            ListenEl temp = first;
            for (int i = 1; i < size-1; i++){
                temp = temp.next;
            }
            e = temp.next.data;
            temp.next = null;
            size--;
            return e;
        }
    }

    public boolean contains(T e) {
        if(size == 0) {
            return false;
        } else {
            ListenEl temp = first;
            while (temp.next != null) {
                if (e.equals(temp.data)) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    public String toString() {
        ListenEl temp = first;
        if(temp == null) {
            return null;
        } else if (temp.next == null) {
            return temp.data.toString();
        } else {
            return temp.data + toString(temp.next);
        }

    }
    public String toString(ListenEl el) {
        ListenEl temp = el;
        if (el.next == null) {
            return "-" + temp.data.toString();
        } else {
            return "-" + temp.data.toString() + toString(temp.next);
        }
    }

    public int size() {
        return size;
    }

    class ListenEl {
        T data;
        ListenEl next;

        ListenEl(T o) {
            data = o;
            next = null;
        }
    }


}

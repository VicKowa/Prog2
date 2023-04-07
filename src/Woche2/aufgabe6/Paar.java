package Woche2.aufgabe6;

public class Paar<E,Z>{
    E stvalue; //firstvalue
    Z ndvalue; //secongvalue

    public Paar(E first, Z second) {
        stvalue = first;
        ndvalue = second;
    }

    public E getErstes() {
        return stvalue;
    }

    public Z getZweites() {
        return ndvalue;
    }

    public void setBeide(E e, Z z) {
        stvalue = e;
        ndvalue = z;
    }

    public Boolean equals(Paar<E,Z> p) {

        return stvalue.equals(p.getErstes()) & ndvalue.equals(p.getZweites());
    }

    @Override
    public String toString() {
        return "(" + stvalue + "," + ndvalue + ")";
    }
}

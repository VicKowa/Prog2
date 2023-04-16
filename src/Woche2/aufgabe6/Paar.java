package Woche2.aufgabe6;

/**
 * Modellierung eines Paars
 * besteht aus 2 verschiedenen Werten einer beliebigen Reference
 * @param <E> Wert 1
 * @param <Z> Wert 2
 * @author vkowal2s
 */
public class Paar<E,Z>{
    E stvalue; //firstvalue
    Z ndvalue; //secondvalue

    /**
     * Erzeugt ein Object der Klasse paar
     * die beiden Referenzen werden übergeben
     * @param first erste Referenz
     * @param second zweite Referenz
     */
    public Paar(E first, Z second) {
        stvalue = first;
        ndvalue = second;
    }

    /**
     *
     * @return gibt die erste Komponente zurück
     */
    public E getErstes() {
        return stvalue;
    }

    /**
     *
     * @return gibt die zweite Komponente zurück
     */
    public Z getZweites() {
        return ndvalue;
    }

    /**
     * setzt die erste Komponente auf den Parameter, gibt alten Wert vorher aus
     * @param e Wert, welcher die neue erste Komponente sein soll
     * @return gibt Wert der ersten Komponente vor dem Ändern zurück
     */
    public E setErstes(E e) {
        E var = stvalue;
        stvalue = e;
        return var;
    }

    /**
     * setzt die zweite Komponente auf den Parameter, gibt alten Wert vorher aus
     * @param z Wert, welcher die neue zweite Komponente sein soll
     * @return gibt Wert der zweiten Komponente vor dem Ändern zurück
     */
    public Z setZweites(Z z) {
        Z var = ndvalue;
        ndvalue = z;
        return var;
    }

    /**
     * setzt die übergebenen Werte auf die Komponenten des Paares
     * @param e erster Wert
     * @param z zweiter Wert
     */
    public void setBeide(E e, Z z) {
        stvalue = e;
        ndvalue = z;
    }

    /**
     * überprüft, ob zwei Paare gleich sind Komponentenweise
     * @param p Paar mit dem es verglichen werden soll
     * @return wenn jeweiligen Komponenten gleich return true
     */
    public Boolean equals(Paar<E,Z> p) {

        return stvalue.equals(p.getErstes()) & ndvalue.equals(p.getZweites());
    }

    /**
     * erzeugt eine Darstellung für das Paar als String
     * @return gibt Paar als String in Form "(a,b)" zurück
     */
    @Override
    public String toString() {
        return "(" + stvalue + "," + ndvalue + ")";
    }
}

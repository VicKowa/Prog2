package woche9;

import Woche1.aufgabe3.Person;

import java.util.Comparator;

public class ComparatorPersonVornameName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int vornameComp = o1.getVorname().compareTo(o2.getVorname());
        return (vornameComp != 0) ?  vornameComp
                : o1.getName().compareTo(o2.getName());
    }
}

package Woche2.aufgabe8;

import Woche1.aufgabe3.Boxer;
import Woche1.aufgabe3.Student;
import Woche2.aufgabe3.Puffer;
import Woche2.aufgabe3.SchlangeMitArray;
import Woche2.aufgabe3.StapelMitArray;
import Woche2.aufgabe6.Paar;

public class PufferPaar {
    public static void main(String[] args) {

        Puffer< Paar<Student, String>> servicepoint;
        Puffer< Paar<Boxer,Boxer>> boxevent;
        Paar<Student, String> st1, st2, st3, st4;
        Paar<Boxer, Boxer> match1, match2, match3;

        servicepoint = new SchlangeMitArray<>(4);
        boxevent = new StapelMitArray<>(3);


        st1 = new Paar<>(new Student("Becker", "Peter", 134),"Wie ist meine Matrikelnr?");
        servicepoint.insert(st1);

        st2 = new Paar<>(new Student("Meier", "Ralf", 223),"Wo ist die Bib?");
        servicepoint.insert(st2);

        st3= new Paar<>(new Student("Baum", "Sophie", 3232),"Wo finde ich die Mensa?");
        servicepoint.insert(st3);

        st4 = new Paar<>(new Student("Lange", "Louisa", 45234),"Wann ist die Klausureinsicht?");
        servicepoint.insert(st4);


        match1 = new Paar<>(new Boxer("Max","blah", 90), new Boxer("bruce", "lee", 80));
        boxevent.insert(match1);//Hauptkampf

        match2 = new Paar<>(new Boxer("Herbert","dumm", 110), new Boxer("idot", "hans", 95));
        boxevent.insert(match2);

        match3 = new Paar<>(new Boxer("justin","grau", 97), new Boxer("kai", "blau", 98));
        boxevent.insert(match3);

        for (int i = 0; i < servicepoint.capacity(); i++) {
            System.out.println(servicepoint.remove());
        }
        System.out.println();

        for (int i = 0; i < boxevent.capacity(); i++) {
            System.out.println(boxevent.remove());
        }

    }
}

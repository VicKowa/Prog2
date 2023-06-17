package woche13;

import woche11.aufgabe4.Folge;
import woche11.aufgabe4.FolgeMitDynArray;

public class Wildcards {
    public static void main(String[] args) {
        Folge<Object> objectsFolge = new FolgeMitDynArray<>();
        Folge<Number> numberFolge= new FolgeMitDynArray<>();
        Folge<Integer> intFolge = new FolgeMitDynArray<>();

        Folge<? extends Object> extendedobjectFolge = intFolge;
        Folge<? extends Number> extendednumberFolge = intFolge;
        Folge<? extends Integer> extendedintFolge = intFolge;

   //     extendedobjectFolge.insert(new Object());
     //   extendedintFolge.insert(new Integer(42));

        extendedobjectFolge = numberFolge;
        extendednumberFolge = numberFolge;
       // extendedintFolge = numberFolge;

        extendedobjectFolge = objectsFolge;
        //extendednumberFolge = objectsFolge;
        //extendedintFolge = objectsFolge;
    }
}

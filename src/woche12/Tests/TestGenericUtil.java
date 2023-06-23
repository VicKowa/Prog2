package woche12.Tests;

import org.junit.jupiter.api.Test;
import woche11.aufgabe4.Folge;
import woche11.aufgabe4.FolgeMitDynArray;
import woche11.aufgabe4.Puffer;
import woche11.aufgabe4.SchlangeMitEVL;
import woche12.GenericUtil;

public class TestGenericUtil {


    @Test
    void testGetMinima() {

        Puffer<Integer> p1 = new SchlangeMitEVL<>();
        Puffer<Integer> p2 = new SchlangeMitEVL<>();

        int[] ar1 = {1,3,69,4,5};
        int[] ar2 = {7,8,9};

       /* for (int element: ar1) {
            p1.insert(element);
        }

        for (int element: ar2) {
            p2.insert(element);
        }

        */

        Folge<Integer> f = GenericUtil.getMinima(p1,p2);
        System.out.println(f);
    }

    @Test
    void testInsertInto() {
        Puffer<Integer[][][]> p = new FolgeMitDynArray<>();
        Integer[][][][] ar ={{{{2}}},{{{4}}}};

        GenericUtil.insertInto(p, ar);
    }
}

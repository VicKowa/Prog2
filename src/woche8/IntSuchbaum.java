package woche8;

import woche7.Folge;
import woche7.FolgeMitDynArray;
import woche7.SchlangeMitRing;

import java.util.NoSuchElementException;

public class IntSuchbaum {

    private BaumEl wurzel;
    private int size;

    class BaumEl {
        int data;
        BaumEl left, right;

        BaumEl(Integer o) {
            data = o;
            left = null;
            right = null;
        }
    }

    public IntSuchbaum() {
        size = 0;
        wurzel = null;
    }

    public Boolean isEmpty() {
        return size <= 0;
    }

    public void insert(Integer i) {
        if (!contains(i)) {
            BaumEl temp = new BaumEl(i);
            if (wurzel == null) {
                wurzel = temp;
            } else {
                insert(temp, wurzel);
            }
            size++;
        }
    }

    /**
     * rekursive Hilfsmethode für insert
     *
     * @param toadd BaumEl welches hinzugefügt werden soll
     * @param cNode current Knoten welcher betrachtet wird
     */
    private void insert(BaumEl toadd, BaumEl cNode) {
        if (toadd.data < cNode.data) {
            if (cNode.left == null) {
                cNode.left = toadd;
            } else {
                insert(toadd, cNode.left);
            }
        } else {
            if (cNode.right == null) {
                cNode.right = toadd;
            } else {
                insert(toadd, cNode.right);
            }

        }
    }

    public Boolean contains(Integer i) {
        return contains(i, wurzel);
    }

    private Boolean contains(Integer i, BaumEl node) {
        if (node == null) {
            return false;
        } else if (node.data == i) {
            return true;
        } else if (i < node.data) {
            return contains(i, node.left);
        } else {
            return contains(i, node.right);
        }

    }


    @Override
    public String toString() {

        if (size <= 0) {
            return "";
        } else {
            return "(" + toString(wurzel.left) + wurzel.data + toString(wurzel.right) + ")";
        }
    }

    private String toString(BaumEl node) {
        if (node == null) {
            return "";
        } else {
            return "(" + toString(node.left) + node.data + toString(node.right) + ")";
        }
    }

    public int hoehe() {
        if (wurzel == null) {
            return 0;
        }
        return 1 + Math.max(hoehe(wurzel.left), hoehe(wurzel.right));
    }

    private int hoehe(BaumEl e) {
        if (e == null) {
            return 0;
        }
        return 1 + Math.max(hoehe(e.left), hoehe(e.right));

    }

    public int size() {
        return size;
    }

    /**
     * Besuche Knoten
     * Betrachte linken Teilbaum
     * Betrachte rechten Teilbaum
     *
     * @return Folge in PreOrder
     */
    public Folge<Integer> preorder() {
        Folge<Integer> fo = new FolgeMitDynArray<>();
        fo.insert(wurzel.data);
        if (wurzel.left != null) {
            preorder(wurzel.left, fo);
        }
        if (wurzel.right != null) {
            preorder(wurzel.right, fo);
        }
        return fo;
    }

    private void preorder(BaumEl e, Folge<Integer> fo) {
        fo.insert(e.data);
        if (e.left != null) {
            preorder(e.left, fo);
        }
        if (e.right != null) {
            preorder(e.right, fo);
        }
    }

    /**
     * Betrachte linken Teilbaum
     * Betrachte Knoten
     * Betrachte rechten Teilbaum
     *
     * @return Folge in InOrder
     */
    public Folge<Integer> inorder() {
        Folge<Integer> fo = new FolgeMitDynArray<>();
        if (wurzel.left != null) {
            inorder(wurzel.left, fo);
        }
        fo.insert(wurzel.data);
        if (wurzel.right != null) {
            inorder(wurzel.right, fo);
        }
        return fo;
    }

    private void inorder(BaumEl e, Folge<Integer> fo) {
        if (e.left != null) {
            inorder(e.left, fo);
        }
        fo.insert(e.data);
        if (e.right != null) {
            inorder(e.right, fo);
        }
    }

    /**
     * Betrachte linken Teilbaum
     * Betrachte Rechten Teilbaum
     * Betrachte Knoten
     *
     * @return Folge in PostOrder
     */
    public Folge<Integer> postorder() {
        Folge<Integer> fo = new FolgeMitDynArray<>();
        if (wurzel.left != null) {
            postorder(wurzel.left, fo);
        }
        if (wurzel.right != null) {
            postorder(wurzel.right, fo);
        }
        fo.insert(wurzel.data);
        return fo;
    }

    private void postorder(BaumEl e, Folge<Integer> fo) {
        if (e.left != null) {
            postorder(e.left, fo);
        }
        if (e.right != null) {
            postorder(e.right, fo);
        }
        fo.insert(e.data);
    }

    public Folge<Integer> breitensuche() {
        return breitensuche(wurzel);
    }

    private Folge<Integer> breitensuche(BaumEl e) {
        SchlangeMitRing<BaumEl> sr = new SchlangeMitRing<>(size);
        Folge<Integer> fo = new FolgeMitDynArray<>();
        BaumEl current;
        sr.insert(e);
        while (!sr.isEmpty()) {
            current = sr.remove();
            fo.insert(current.data);

            if (current.left != null) {
                sr.insert(current.left);
            }
            if (current.right != null) {
                sr.insert(current.right);
            }
        }
        return fo;
    }

  /*  public void remove(Integer i) throws NoSuchElementException {
        if (!contains(i)) throw new NoSuchElementException();
        BaumEl toRm = search(wurzel, i);
        BaumEl paOfRm = parentof(wurzel, i);

        //1. Fall löschen im Suchbaum ohne Teilbaum
        if(toRm.left == null & toRm.right == null) {
            if(paOfRm.left.data == i) {
                paOfRm.left = null;
            } else {
                paOfRm.right = null;
            }
        }

        //2. Fall löschen im Suchbaum ein Teilbaum
        if(toRm.left != null & toRm.right == null) {
            paOfRm.left = toRm.left;

        } else {
            paOfRm.right = toRm.right;
        }

        //3. Fall löschen im Suchbaum zwei Teilbäume
        assert toRm.left != null;
        BaumEl newNode = toRm.left.right;
        toRm.left.right = null;
        if(toRm.right != null & newNode != null) {
            if (paOfRm.left.data == i) {
                paOfRm.left = newNode;
            } else {
                paOfRm.right = newNode;
            }
            newNode.left = toRm.left;
            newNode.right = toRm.right;

        }


    }

   */

    public void remove(Integer i) throws NoSuchElementException {
        if(!contains(i)) {
            throw new NoSuchElementException();
        }
        wurzel = remove(i, wurzel);
    }
    private BaumEl remove(Integer i, BaumEl node) {
        if (node == null) {
            return null;
        }

        if (i < node.data) {
            node.left = remove(i, node.left);
        } else if (i > node.data) {
            node.right = remove(i, node.right);
        } else {
            // Fall 1: Keine Kinder
            if (node.left == null && node.right == null) {
                node = null;
            }
            // Fall 2: Ein Kind
            else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }
            // Fall 3: Zwei Kinder
            else {
                int maxVal = findMaxValue(node.left);
                node.data = maxVal;
                node.left = remove(maxVal, node.left);
            }
        }

        return node;
    }

    private int findMaxValue(BaumEl node) {
        int maxValue = node.data;
        while (node.right != null) {
            maxValue = node.right.data;
            node = node.right;
        }
        return maxValue;
    }

  /*  private BaumEl search(BaumEl node, Integer i) {
        if (node.data == i) {
            return node;
        } else if (i < node.data) {
            return search(node.left, i);
        } else {
            return search(node.right, i);
        }
    }

    private BaumEl parentof(BaumEl node, Integer i) {
        // Wenn akt Knoten null ist oder Element gefunden wurde → kein Elternknoten
        if(node == null || node.data == i) {
            return null;
        }
        // Wenn i eine linken oder rechten Nachfolger gehört return akt node
        if((node.left != null && node.left.data == i) ||
                (node.right != null && node.right.data == i)) {
            return node;
        }
        //wenn i kleiner als akt Knoten ist, suche im linken Teilbaum ansonsten im rechten
        if(i < node.data) {
            return parentof(node.left, i);
        } else {
            return parentof(node.right, i);
        }
    }


   */
}

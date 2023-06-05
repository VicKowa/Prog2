package woche9;

import woche7.Folge;
import woche7.FolgeMitDynArray;
import woche7.SchlangeMitRing;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Suchbaum<T> {
    private BaumEl wurzel;
    private Comparator<T> comp;

    public Suchbaum() {
        wurzel = null;
        comp = null;
    }

    public Suchbaum(Comparator<T> comp) {
        wurzel = null;
        this.comp = comp;
    }

    class BaumEl {
        T data;
        BaumEl left, right;

        BaumEl(T o) {
            data = o;
            left = null;
            right = null;
        }
    }

	public int vergleich(T a, T b) {
		if(comp == null) {
			return((Comparator<T>) a).compareTo(b);
		} else{
			return comp.compare(a, b);
		}
	}

    public Boolean contains(T o) {
        return contains(o, wurzel);
    }

    

    private Boolean contains(T o, BaumEl node) {
        if (node == null) {
            return false;
        } else if (vergleich(o, node.data == 0) {
            return true;
        } else if (vergleich(o, node.data) < 0) {
            return contains(o, node.left);
        } else {
            return contains(o, node.right);
        }
    }

    public Boolean isEmpty() {
        return size() <= 0;
    }

    public void insert(T o) {
        if (!contains(o)) {
            BaumEl temp = new BaumEl(o);
            if (wurzel == null) {
                wurzel = temp;
            } else {            
                insert(temp, wurzel);
            }
        }
    }

    /**
     * rekursive Hilfsmethode für insert
     *
     * @param toadd BaumEl welches hinzugefügt werden soll
     * @param cNode current Knoten welcher betrachtet wird
     */
    private void insert(BaumEl toadd, BaumEl cNode) {
        if (vergleich(toadd.data, cNode.data) < 0) {
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

    public int size() {
        return size(wurzel);
    }

    public int size(BaumEl node) {
        if (node != null) {
            return 1 + size(node.left) + size(node.right);
        }
        return 0;
    }

    @Override
    public String toString() {
        return toString(wurzel);
    }

    private String toString(BaumEl node) {
        if (node == null) {
            return "";
        } else {
            return "(" + toString(node.left) + node.data + toString(node.right) + ")";
        }
    }

    public int hoehe() {
        return hoehe(wurzel);
    }

    private int hoehe(BaumEl e) {
        if (e == null) {
            return 0;
        }
        return 1 + Math.max(hoehe(e.left), hoehe(e.right));

    }

    public void remove(T o) throws NoSuchElementException {
        if (!contains(o)) {
            throw new NoSuchElementException();
        }
        wurzel = remove(o, wurzel);
    }

    private BaumEl remove(T o, BaumEl node) {
        if (node == null) {
            return null;
        }

        if (vergleich(o, node.data) < 0) {
            node.left = removeTo(o, node.left);
        } else if (vergleich(o, node.data) > 0) {
            node.right = removeTo(o, node.right);
        } else {
           // Fall 1: keine Kinder
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
        	T maxVal = findMaxValue(node.left);
        	node.data = maxVal;
        	node.left = removeTo(maxVal, node.left);
        	}
        }
        return node;
    }
    private T findMaxValue(BaumEl node){
        T maxValue = node.data;
        while (node.right != null) {
            maxValue = node.right.data;
            node = node.right;
        }
        return maxValue;
    }



    /**
     * Besuche Knoten
     * Betrachte linken Teilbaum
     * Betrachte rechten Teilbaum
     *
     * @return Folge in PreOrder
     */
    public Folge<T> preorder() {
        Folge<T> fo = new FolgeMitDynArray<>();
        preorder(wurzel, fo);
        return fo;
    }

    private void preorder(BaumEl e, Folge<T> fo) {
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
    public Folge<T> inorder() {
        Folge<T> fo = new FolgeMitDynArray<>();
        inorder(wurzel, fo);
        return fo;
    }

    private void inorder(BaumEl e, Folge<T> fo) {
        if (e.left != null) {
            inorder(e.left, fo);
        }
        fo.insert(e.data);
        if (e.right != null) {
            inorder(e.right, fo);
        }
    }

    public Folge<T> postorder() {
        Folge<T> fo = new FolgeMitDynArray<>();
        postorder(wurzel, fo);
        return fo;
    }

    private void postorder(BaumEl e, Folge<T> fo) {
        if (e.left != null) {
            postorder(e.left, fo);
        }
        if (e.right != null) {
            postorder(e.right, fo);
        }
        fo.insert(e.data);
    }

    public Folge<T> breitensuche() {
        return breitensuche(wurzel);
    }

    private Folge<T> breitensuche(BaumEl e) {
        SchlangeMitRing<BaumEl> sr = new SchlangeMitRing<>(size());
        Folge<T> fo = new FolgeMitDynArray<>();
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
}

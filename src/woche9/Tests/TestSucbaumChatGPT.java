package woche9.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woche7.Folge;
import woche7.FolgeMitDynArray;
import woche9.Suchbaum;

import java.util.NoSuchElementException;

public class TestSucbaumChatGPT {
    private Suchbaum<Integer> suchbaum;

    @BeforeEach
    void setUp() {
        suchbaum = new Suchbaum<>();
        suchbaum.insert(5);
        suchbaum.insert(3);
        suchbaum.insert(8);
        suchbaum.insert(2);
        suchbaum.insert(4);
        suchbaum.insert(7);
        suchbaum.insert(9);
    }

    @Test
    void contains_existingElement_returnsTrue() {
        Assertions.assertTrue(suchbaum.contains(3));
    }

    @Test
    void contains_nonExistingElement_returnsFalse() {
        Assertions.assertFalse(suchbaum.contains(6));
    }

    @Test
    void contains_emptyTree_returnsFalse() {
        Suchbaum<String> emptyTree = new Suchbaum<>();
        Assertions.assertFalse(emptyTree.contains("test"));
    }

    @Test
    void insert_newElement_increasesSize() {
        int initialSize = suchbaum.size();
        suchbaum.insert(6);
        Assertions.assertEquals(initialSize + 1, suchbaum.size());
    }

    @Test
    void insert_existingElement_doesNotIncreaseSize() {
        int initialSize = suchbaum.size();
        suchbaum.insert(3);
        Assertions.assertEquals(initialSize, suchbaum.size());
    }

    @Test
    void remove_existingElement_decreasesSize() {
        int initialSize = suchbaum.size();
        suchbaum.remove(3);
        Assertions.assertEquals(initialSize - 1, suchbaum.size());
    }

    @Test
    void remove_nonExistingElement_throwsNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            suchbaum.remove(6);
        });
    }

    @Test
    void isEmpty_emptyTree_returnsTrue() {
        Suchbaum<String> emptyTree = new Suchbaum<>();
        Assertions.assertTrue(emptyTree.isEmpty());
    }

    @Test
    void isEmpty_nonEmptyTree_returnsFalse() {
        Assertions.assertFalse(suchbaum.isEmpty());
    }

    @Test
    void preorder_returnsCorrectSequence() {
        Folge<Integer> expected = new FolgeMitDynArray<>();
        expected.insert(5);
        expected.insert(3);
        expected.insert(2);
        expected.insert(4);
        expected.insert(8);
        expected.insert(7);
        expected.insert(9);

        Folge<Integer> actual = suchbaum.preorder();

        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void inorder_returnsCorrectSequence() {
        Folge<Integer> expected = new FolgeMitDynArray<>();
        expected.insert(2);
        expected.insert(3);
        expected.insert(4);
        expected.insert(5);
        expected.insert(7);
        expected.insert(8);
        expected.insert(9);

        Folge<Integer> actual = suchbaum.inorder();

        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void postorder_returnsCorrectSequence() {
        Folge<Integer> expected = new FolgeMitDynArray<>();
        expected.insert(2);
        expected.insert(4);
        expected.insert(3);
        expected.insert(7);
        expected.insert(9);
        expected.insert(8);
        expected.insert(5);

        Folge<Integer> actual = suchbaum.postorder();

        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void breitensuche_returnsCorrectSequence() {
        Folge<Integer> expected = new FolgeMitDynArray<>();
        expected.insert(5);
        expected.insert(3);
        expected.insert(8);
        expected.insert(2);
        expected.insert(4);
        expected.insert(7);
        expected.insert(9);

        Folge<Integer> actual = suchbaum.breitensuche();

        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void toString_returnsCorrectStringRepresentation() {
        String expected = "(((2)3(4))5((7)8(9)))";
        String actual = suchbaum.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void size_returnsCorrectSize() {
        int expected = 7;
        int actual = suchbaum.size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void hoehe_returnsCorrectHeight() {
        int expected = 3;
        int actual = suchbaum.hoehe();

        Assertions.assertEquals(expected, actual);
    }

   /* @Test
    void contains_customComparator_existingElement_returnsTrue() {
        Suchbaum<String> customTree = new Suchbaum<>(Comparator.reverseOrder());
        customTree.insert("apple");
        customTree.insert("banana");
        customTree.insert("cherry");

        Assertions.assertTrue(customTree.contains("cherry"));
    }

    */
}

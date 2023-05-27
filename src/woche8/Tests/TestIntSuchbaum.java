package woche8.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import woche7.Folge;
import woche8.IntSuchbaum;

import static org.junit.jupiter.api.Assertions.*;

public class TestIntSuchbaum {

    IntSuchbaum sb;
    int[] ar = {3,2,5,4,1,7};
    @BeforeEach
    void setup() {
        sb = new IntSuchbaum();
    }

    @AfterEach
    void teardown() {
        sb = null;
    }

    @Test
    void testInsert() {
        sb.insert(3);
        sb.insert(2);

    }

    @Test
    void testToString() {
        for (int j: ar) {
            sb.insert(j);
        }

        assertEquals("(((1)2)3((4)5(7)))", sb.toString());

    }

    @Test
    void testContains() {
        sb.insert(1);
        assertFalse(sb.contains(60));
        assertTrue(sb.contains(1));
    }

    @Test
    void testSize() {
        int[] ar = {1,6,2,5,7,4,23};
        for (int j: ar) {
            sb.insert(j);
        }
        assertEquals(ar.length, sb.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(sb.isEmpty());
        sb.insert(1);
        assertFalse(sb.isEmpty());
    }

    @Test
    void testHoehe() {
        for (int j: ar) {
            sb.insert(j);
        }
        assertEquals(3, sb.hoehe());
    }

    @Test
    void testPreOrder() {
        int[] pre = {3,2,1,5,4,7};
        fill();

        Folge<Integer> folge = sb.preorder();
        for (int i = 0; i < pre.length; i++) {
            assertEquals(pre[i], folge.get(i));
        }

    }

    @Test
    void testInOrder() {
        int[] in = {1,2,3,4,5,7};
        fill();

        Folge<Integer> folge = sb.inorder();
        for (int i = 0; i < in.length; i++) {
            assertEquals(in[i], folge.get(i));
        }

    }
    @Test
    void testPostOrder() {
        int[] post = {1,2,4,7,5,3};
        fill();

        Folge<Integer> folge = sb.postorder();
        for (int i = 0; i < post.length; i++) {
            assertEquals(post[i], folge.get(i));
        }

    }

    private void fill() {
        for (int j: ar) {
            sb.insert(j);
        }

    }

    @Test
    void testBreitensuche() {
        int[] bs = {3,2,5,1,4,7};
        fill();

        Folge<Integer> fo = sb.breitensuche();
        for (int i = 0; i < bs.length; i++) {
            assertEquals(bs[i], fo.get(i));
        }
    }

    @Test
    void testRemove() {

        sb.insert(6);
        sb.insert(4);
        sb.insert(9);
        sb.insert(1);
        sb.insert(7);
        sb.insert(10);
        sb.insert(8);
        sb.remove(9);
    }

}

package chandan449.coursera.algo1.unionfind;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class QuicksortTest {

    private static final String DISTINCT = "distinct";

    @Test
    public void testSingleItemSorting() {
        Integer[] items = new Integer[1];
        items[0] = -3;

        sortAndTest(items, DISTINCT);
    }

    @Test
    public void test1TwoDistinctItemSorting() {
        Integer[] items = new Integer[2];
        items[0] = 3;
        items[1] = -3;

        sortAndTest(items, DISTINCT);
    }
    
    @Test
    public void test2TwoDistinctItemSorting() {
        Integer[] items = new Integer[2];
        items[0] = -3;
        items[1] = 3;

        sortAndTest(items, DISTINCT);
    }

    @Test
    public void testThreeDistinctItemSorting() {
        Integer[] items = new Integer[3];
        items[0] = 3;
        items[1] = -3;
        items[2] = 0;

        sortAndTest(items, DISTINCT);
    }

    @Test
    public void testFiveDistinctItemSorting() {
        Integer[] items = new Integer[5];
        items[0] = -3;
        items[1] = 8;
        items[2] = -2;
        items[3] = 0;
        items[4] = 1;

        sortAndTest(items, DISTINCT);
    }

    @Test
    public void testSortingOfFiveItemWithDuplicates() {
        Integer[] items = new Integer[5];
        items[0] = -3;
        items[1] = 8;
        items[2] = 0;
        items[3] = 0;
        items[4] = 1;

        sortAndTest(items, "duplicate");
    }

    @Test
    public void testSortingOfMultipleDuplicates() {
        Integer[] items = new Integer[5];
        items[0] = 1;
        items[1] = 0;
        items[2] = 1;
        items[3] = 0;
        items[4] = 1;

        sortAndTest(items, "duplicate");
    }

    private void sortAndTest(Integer[] items, String itemType) {
        System.out.println(items.length + " " + itemType + " items before sorting");
        printArray(items);

        Quicksort.sort(items);

        System.out.println(items.length + " " + itemType + " items after sorting");
        printArray(items);

        assertTrue(isSorted(items));
    }

    private static boolean less(Comparable[] items, int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private static <T> boolean isSorted(Comparable[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            if (less(items, i + 1, i))
                return false;
        }
        return true;
    }

    private void printArray(Integer[] items) {
        for (Integer item : items) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }
}

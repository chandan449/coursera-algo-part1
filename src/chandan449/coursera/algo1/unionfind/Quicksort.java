package chandan449.coursera.algo1.unionfind;

/**
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class Quicksort {

    public static void sort(Comparable[] items) {
        sort(items, 0, items.length - 1);
    }

    private static void sort(Comparable[] items, int lo, int hi) {
        if (hi <= lo)
            return;

        // partition
        int j = partition(items, lo, hi);

        // sort partitions
        sort(items, lo, j - 1);
        sort(items, j + 1, hi);
    }

    private static int partition(Comparable[] items, int lo, int hi) {
        // choose pivot
        int pivot = lo;

        int i = lo + 1, j = hi;
        while (i <= j) {
            if (lessThanEqualsTo(items, i, pivot)) i++;
            else if (less(items, pivot, j)) j--;
            else if (i < j) exchange(items, i, j);
        }
        // replace pivot
        exchange(items, pivot, j);
        return j;
    }

    private static void exchange(Comparable[] items, int i, int j) {
        Comparable item = items[i];
        items[i] = items[j];
        items[j] = item;
    }

    private static boolean less(Comparable[] items, int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private static boolean lessThanEqualsTo(Comparable[] items, int i, int j) {
        return items[i].compareTo(items[j]) <= 0;
    }

    private static <T> boolean isSorted(Comparable[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            if (less(items, i + 1, i))
                return false;
        }
        return true;
    }

    private static void printArray(Object[] items) {
        for (Object item : items) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] items = new Integer[5];
        items[0] = -3;
        items[1] = 8;
        items[2] = 0;
        items[3] = 0;
        items[4] = 1;
        sort(items);

        System.out.println(isSorted(items));
        for (Integer item : items) {
            System.out.print(item + "  ");
        }

        // Read input from a source
        // Verify output
    }

}

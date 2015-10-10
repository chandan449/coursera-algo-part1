package chandan449.coursera.algo1.unionfind;

/**
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class Mergesort {

    private static int mergeCount = 0;

    public static void sort(Comparable[] items) {
        mergeCount = 0;
        sort(items, 0, items.length - 1);
    }

    private static void copyAuxToItems(Comparable[] items, Comparable[] aux,
            int low) {
        for (int i = 0; i < aux.length; i++, low++) {
            items[low] = aux[i];
        }
    }

    private static void sort(Comparable[] items, int low, int high) {
        // single item is already sorted
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        // sort left side
        sort(items, low, mid);
        // sort right side
        sort(items, mid + 1, high);
        // merge left and right
        merge(items, low, mid, mid + 1, high);
    }

    private static void merge(Comparable[] items, int leftLow, int leftHigh,
            int rightLow, int rightHigh) {
        mergeCount++; // for tracing
        Comparable[] aux = new Comparable[rightHigh - leftLow + 1];
        int i = leftLow, j = rightLow;
        int count = 0;
        while (i <= leftHigh && j <= rightHigh) {
            if (less(items, i, j)) {
                aux[count++] = items[i++];
            } else {
                aux[count++] = items[j++];
            }
        }
        while (i <= leftHigh) {
            aux[count++] = items[i++];
        }
        while (j <= rightHigh) {
            aux[count++] = items[j++];
        }

        // copy back to items
        copyAuxToItems(items, aux, leftLow);

        System.out.print("After " + mergeCount + " merge: ");
        printArray(items);
    }

    private static boolean less(Comparable[] items, int i, int j) {
        return items[i].compareTo(items[j]) < 0;
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

}

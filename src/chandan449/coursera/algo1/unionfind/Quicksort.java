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
        Range range = partition(items, lo, hi);

        // sort partitions
        sort(items, lo, range.left - 1);
        sort(items, range.right + 1, hi);
    }

    private static Range partition(Comparable[] items, int lo, int hi) {
        
        int mid = lo + (hi - lo) / 2;
        int lt = mid, gt = mid;
        
        // choose pivot
        Comparable pivot = items[mid];

        int i = lo, j = hi;
        while (!(i >= lt && j <= gt)) {
            if (less(items[i], pivot)) {
                i++;
            }
            else if (items[i].equals(pivot) && i < lt) {
                exchange(items, i, --lt);
            }
            else if (less(pivot, items[j])) {
                j--;
            }
            else if (items[j].equals(pivot) && j > gt){
                exchange(items, j, ++gt);
            }
            else if (i < lt && j > gt) {
                exchange(items, i, j);
            }
            else if (i == lt && j > gt) {
                exchange(items, i, j);
                lt++;
                if (gt < lt) gt = lt;
            }
            else if (j == gt) {
                exchange(items, i, j);
                gt--;
                if (lt > gt) lt = gt;
            }
        }
        
        Range range = new Range();
        range.left = lt;
        range.right = gt;
        return range;
    }
    
    private static boolean less(Comparable comparable, Comparable pivot) {
        return comparable.compareTo(pivot) < 0;
    }

    static class Range {
        public int left;
        public int right;
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

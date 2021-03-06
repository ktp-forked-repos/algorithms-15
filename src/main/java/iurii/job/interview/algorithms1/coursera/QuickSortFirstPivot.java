package iurii.job.interview.algorithms1.coursera;

/**
 * Quick sort implementation with extra memory space(log n) & with random pivot.
 */
public class QuickSortFirstPivot {

    public static long comparisonNumber = 0;

    public static int[] sort(int[] array) {
        return sort(array, 0, array.length - 1);
    }

    private static int[] sort(int[] array, int low, int high) {
        if (low >= high) {
            return array;
        }
        int pivot = pivot(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
        return array;
    }

    private static int pivot(int[] array, int low, int high) {
        // first pivot
        int pivotIndex = low;
        int pivot = array[pivotIndex];
        // swap first
        int swapFirst = array[low];
        array[low] = array[pivotIndex];
        array[pivotIndex] = swapFirst;
        int i = low + 1;
        // swap for <p & >p border
        for (int j = low + 1; j <= high; j++) {
            if (array[j] < pivot) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
            }
        }
        comparisonNumber += high - low;
        // final swap
        array[low] = array[i - 1];
        array[i - 1] = pivot;
        return i - 1;
    }

}

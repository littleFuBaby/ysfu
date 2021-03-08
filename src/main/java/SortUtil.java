public class SortUtil {

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 6, 1, 7};
        //insertionSort(array);
        //selectionSort(array);
        //bubbleSort(array);
        quickSort(array, 0, array.length - 1);
        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void mergeSort(){

    }

    /**
     * Quick Sort
     *
     * @param array
     */
    public static void quickSort(int[] array, int begin, int end) {
        if (array == null || array.length == 0) return;
        if (begin >= end) return;
        // find pivot
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    /**
     * Partition
     *
     * @return
     */
    private static int partition(int[] array, int begin, int end) {
        // pivot index
        int pivot = end;
        // number which is less than pivot
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[counter];
        array[counter] = array[pivot];
        array[pivot] = temp;
        return counter;
    }

    /**
     * Bubble Sort
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * Insertion Sort
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        for (int i = 1; i < array.length; i++) {
            int prev = i - 1;
            int current = array[i];
            while (prev >= 0 && array[prev] > current) {
                array[prev + 1] = array[prev];
                prev--;
            }
            array[prev + 1] = current;
        }
    }

    /**
     * Selection Sort
     *
     * @param array
     */
    public static void selectionSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

}

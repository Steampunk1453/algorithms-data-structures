package sort.quick;

public class QuickSort {

    /* The main function that implements QuickSort()
     array[] --> Array to be sorted,
    low  --> Starting index,
    high  --> Ending index
    */
    protected void sort(int[] array, int low, int high) {
        if (low < high) {
            /* partIndex is partitioning index, array[partIndex] is
              now at right place */
            int partIndex = partition(array, low, high);
            // Recursively sort elements before
            // partition and after partition
            sort(array, low, partIndex - 1);
            sort(array, partIndex + 1, high);
        }
    }

    protected int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int index = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                index++;
                // swap array[index] and array[j]
                int temp = array[index];
                array[index] = array[j];
                array[j] = temp;
            }
        }
        // swap array[index+1] and array[high] (or pivot)
        int temp = array[index + 1];
        array[index + 1] = array[high];
        array[high] = temp;

        return index + 1;
    }

}

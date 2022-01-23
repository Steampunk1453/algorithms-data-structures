package sort.selection;

public class SelectionSort {

    protected int[] sort(int[] array) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < array.length - 1; i++) {
            // Find the minimum element in unsorted array
            int lowestNumberIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[lowestNumberIndex])
                    lowestNumberIndex = j;
            }
            // Swap the found minimum element with the first element
            int temp = array[lowestNumberIndex];
            array[lowestNumberIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

}

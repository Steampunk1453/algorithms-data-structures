package sort.bubble;

public class BubbleSort {

    protected int[] sortWithWhile(int[] array) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return array;
    }

    protected int[] sortWithFor(int[] array) {
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength - 1; i++)
            for (int j = 0; j < arrayLength - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        return array;
    }

}

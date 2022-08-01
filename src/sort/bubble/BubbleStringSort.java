package sort.bubble;

public class BubbleStringSort {

    protected String[] sortStrings(String[] array) {
        String temp;
        int arrayLength = array.length;
        // Sorting strings using bubble sort
        for (int j = 0; j < arrayLength - 1; j++) {
            for (int i = j + 1; i < arrayLength; i++) {
                if (array[j].compareTo(array[i]) > 0) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

}

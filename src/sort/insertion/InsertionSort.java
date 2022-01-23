package sort.insertion;

public class InsertionSort {

   protected int[] insertion(int[] array) {
        for (int step = 1; step < array.length; step++) {
            int tempValue = array[step];
            int position = step - 1;
            // Compare tempValue with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change tempValue<array[position] to tempValue>array[position].
            while (position >= 0 && tempValue < array[position]) {
                array[position + 1] = array[position];
                --position;
            }
            // Place tempValue at after the element just smaller than it.
            array[position + 1] = tempValue;
        }
        return array;
    }

}

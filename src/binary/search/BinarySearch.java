package binary.search;

public class BinarySearch {
    protected int binarySearch(int[] array, int key) {
        if (isEmpty(array)) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static boolean isEmpty(int[] array) {
        int arraySize = array.length;
        return arraySize == 0;
    }

}


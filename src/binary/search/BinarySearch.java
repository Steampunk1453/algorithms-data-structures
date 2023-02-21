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

    // 34. Find First and Last Position of Element in Sorted Array
    // Given an array of integers nums sorted in non-decreasing order, find the starting and ending position
    // of a given target value.
    //If target is not found in the array, return [-1, -1]
    //You must write an algorithm with O(log n) runtime complexity

    protected int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstLast(nums, target, true);
        result[1] = findFirstLast(nums, target, false);
        return result;
    }

    private int findFirstLast(int[] nums, int target, boolean first) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid] || (first && target == nums[mid])) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) {
                idx = mid;
            }
        }
        return idx;
    }

}


package array.integer;

import java.util.HashMap;
import java.util.Map;

public class Main {

    // Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order
    protected int[] topKFrequent(int[] nums, int k) {
        // Write your code here
        int[] result = new int[k];
        int[] count = new int[nums.length];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < k; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < count.length; j++) {
                if (count[j] > max) {
                    max = count[j];
                    index = j;
                }
            }
            result[i] = index;
            count[index] = 0;
        }
        return result;
    }

    // Book: create a new function to reverse an array that takes up just O(1) extra space.
    protected int[] reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int aux = array[(array.length -1) - i];
            array[(array.length - 1) - i] = array[i];
            array[i] = aux;
        }
        return array;
    }

    // Merge sorted arrays
    // Time complexity: O(n1 + n2)
    // Space complexity: O(n1 + n2)
    // With Tree Map:
    // Time complexity: O(nlog(n) + mlog(m))
    // Space complexity: O(n)
    protected int[] merge(int[] array1, int[] array2) {
        int array1length = array1.length;
        int array2length = array2.length;
        int mergedArraySize = array1length + array2length;
        int[] mergedArray = new int[mergedArraySize];
        int array1Index = 0;
        int array2Index = 0;
        int mergedIndex = 0;

        while (array1Index < array1length && array2Index < array2length) {
            if (array1[array1Index] < array2[array2Index]) {
                mergedArray[mergedIndex] = array1[array1Index];
                array1Index++;
            } else {
                mergedArray[mergedIndex] = array2[array2Index];
                array2Index++;
            }
            mergedIndex++;
        }

        while (array1Index < array1length) {
            mergedArray[mergedIndex] = array1[array1Index];
            array1Index++;
            mergedIndex++;
        }

        while (array2Index < array2length) {
            mergedArray[mergedIndex] = array2[array2Index];
            array2Index++;
            mergedIndex++;
        }

        return mergedArray;
    }

    // Two Sum Brute Force
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    protected int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // Two Sum
    // Time complexity: O(n)
    // Space complexity: O(n)
    protected int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int requiredNum = target - num;
            if (indexMap.containsKey(requiredNum)) {
                int firstIndex = indexMap.get(requiredNum);
                return new int[]{firstIndex, i};
            }
            indexMap.put(num, i);
        }
        return new int[]{};
    }

    // Move Zeroes
    // Time complexity: O(n)
    // Space complexity: O(1)
    protected int[] moveZeroes(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }

        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }

    // Contains Duplicate
    // Time complexity: O(n)
    // Space complexity: O(n)
    protected boolean hasDuplicates(int[] nums) {
        Map<Integer, Boolean> numsMap = new HashMap<>();

        for (int num : nums) {
            if (numsMap.getOrDefault(num, false)) {
                return true;
            }
            numsMap.put(num, true);
        }

        return false;
    }

    // First Recurring Character
    // Time complexity: O(n)
    // Space complexity: O(n)
    protected Integer firstRecurringCharacter(int[] nums) {
        Map<Integer, Boolean> numsMap = new HashMap<>();

        for (int num : nums) {
            if (numsMap.getOrDefault(num, false)) {
                return num;
            }
            numsMap.put(num, true);
        }

        return null;
    }

    // 11. Container With Most Water
    // Time complexity: O(n)
    // Space complexity: O(1)
    protected int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int halfLength = height.length / 2;
        int pointerLeft = 0;
        int pointerRight = height.length - 1;
        int maxValueLeft = 0;
        int maxValueRight = 0;

        while (pointerLeft < halfLength && pointerRight >= halfLength) {
            int valueLeft = height[pointerLeft];
            int weightedValueLeft = valueLeft - pointerLeft;
            if (weightedValueLeft > maxValueLeft) {
                maxValueLeft = valueLeft;
            }
            int valueRight = height[pointerRight];
            int weightedValueRight = valueRight + pointerRight;
            if (weightedValueRight > maxValueRight) {
                maxValueRight = valueRight;
            }
            pointerLeft++;
            pointerRight--;
        }
        return maxValueLeft * maxValueRight;
    }

}

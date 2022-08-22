package array.string.udemy;

import java.util.HashMap;
import java.util.Map;

public class Main {

    // Reverse a string
    // Time complexity: O(n)
    // Space complexity: O(n)
    protected String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] inputs = input.toCharArray();
        StringBuilder output = new StringBuilder();

        for (int i = inputs.length - 1; i >= 0; i--) {
            output.append(inputs[i]);
        }

        return output.toString();
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

    // Longest Word
    // Time complexity: O(n)
    // Space complexity: O(n)
    protected String getLongestWord(String word) {
        String[] words = word.split(" ");
        String longestWord = "";

        for (String item : words) {
            if (item.matches("^[a-zA-Z0-9]*$") && item.length() > longestWord.length()) {
                longestWord = item;
            }
        }

        return longestWord;
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

    // Google: write a function which will remove any given character from a String
    protected String remove(String word, char unwanted) {
        StringBuilder sb = new StringBuilder();
        char[] letters = word.toCharArray();

        for (char c : letters) {
            if (c != unwanted) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    protected String removeRecursive(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        return removeRecursive(word.substring(0, index) + word.substring(index + 1), ch);
    }

}

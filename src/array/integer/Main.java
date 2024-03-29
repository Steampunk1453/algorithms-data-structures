package array.integer;

import java.util.Arrays;
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
            int aux = array[(array.length - 1) - i];
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
    // Given an array of integers nums and an integer target,
    // return indices of the two numbers such that they add up to target
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

    // 136. Single Number
    // Given a non-empty array of integers nums, every element appears twice except for one
    // Find that single one
    // You must implement a solution with a linear runtime complexity and use only constant extra space
    public int singleNumber(int[] nums) {
        // Solution not complete. it fails in the case of many numbers
        int singleNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == singleNum) {
                int previous = nums[i - 1];
                if (i + 1 < nums.length && num == previous) {
                    singleNum = nums[i + 1];
                    i++;
                } else {
                    singleNum = previous;
                }
            }
        }
        return singleNum;
    }

    public int singleNumberOptimal(int[] nums) {
        int result = 0;
        //even occurence will nullify
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // 169. Majority Element
    // Given an array nums of size n, return the majority element
    //The majority element is the element that appears more than ⌊n / 2⌋ times
    // You may assume that the majority element always exists in the array
    // TODO Check:
    // https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/

    // Boyer-Moore Voting Algorithm
    // Time complexity: O(n)
    // Space complexity: O(1)
    protected int findMajorityOptimal(int[] nums) {
        int count = 0;
        int candidate = -1;

        // Finding majority candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                if (num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        // Checking if majority candidate occurs more than
        // n/2 times
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        if (count > (nums.length / 2)) {
            return candidate;
        }

        return -1;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    // Fails with {1,2,3} because it does not return -1
    protected int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    // Fails with {1,2,3} because it does not return -1
    protected int majorityElement1(int[] nums) {
        int sum = 1;
        int major = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == major) {
                sum = sum + 1;
            } else {
                sum = sum - 1;
            }
            if (sum == 0) {
                major = nums[i + 1];
            }
        }
        return major;
    }

    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    // Fails with {1,2,3} because it does not return -1
    protected int majorityElementArraySort(int[] nums) {
        Arrays.sort(nums);
        int x = nums.length / 2;
        return nums[x];
    }

    // 11. Container With Most Water
    // Medium
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    protected int maxAreaBruteForce(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int minHeight = Math.min(heights[i], heights[j]);
                int width = j - i;
                int area = minHeight * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    protected int maxAreaOptimal(int[] heights) {
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = heights.length - 1;

        while (leftIndex < rightIndex) {
            int leftHeight = heights[leftIndex];
            int rightHeight = heights[rightIndex];
            int height = Math.min(leftHeight, rightHeight);
            int width = rightIndex - leftIndex;
            int area = calculateArea(height, width);
            maxArea = Math.max(maxArea, area);

            if (leftHeight <= rightHeight) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxArea;
    }

    private int calculateArea(int height, int width) {
        return height * width;
    }

    // 42. Trapping Rain Water
    // Hard
    // Given n non-negative integers representing an elevation map where the width of each bar is 1,
    // compute how much water it can trap after raining.

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    protected int trapBruteForce(int[] heights) {
        int waterTrap = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftIndex = i - 1;
            int rightIndex = i + 1;
            int maxLeft = 0;
            int maxRight = 0;
            int firstPosition = 0;

            while (leftIndex >= firstPosition) {
                maxLeft = Math.max(maxLeft, heights[leftIndex--]);
            }
            while (rightIndex < heights.length) {
                maxRight = Math.max(maxRight, heights[rightIndex++]);
            }

            int water = Math.min(maxLeft, maxRight) - heights[i];
            waterTrap += Math.max(water, 0); // To avoid negative numbers
        }

        return waterTrap;
    }

    // It's O(N) you will traverse the whole array just once! Brilliant solution
    // Time complexity: O(n)
    // Space complexity: O(1)
    protected int trapOptimal(int[] heights) {
        int result = 0;
        int start = 0;
        int end = heights.length - 1;

        while (start < end) {
            if (heights[start] <= heights[end]) {
                int current = heights[start];
                while (heights[++start] < current) {
                    result += current - heights[start];
                }
            } else {
                int current = heights[end];
                while (heights[--end] < current) {
                    result += current - heights[end];
                }
            }
        }
        return result;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    protected int trapOptimalOneWhile(int[] heights) {
        int totalWater = 0;
        int left = 0;
        int right = heights.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {

            if (heights[left] <= heights[right]) {
                if (heights[left] >= maxLeft) {
                    maxLeft = heights[left];
                } else {
                    totalWater += maxLeft - heights[left];
                }
                left++;

            } else {
                if (heights[right] >= maxRight) {
                    maxRight = heights[right];
                } else {
                    totalWater += maxRight - heights[right];
                }
                right--;
            }
        }
        return totalWater;
    }

}

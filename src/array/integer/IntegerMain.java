package array.integer;

public class IntegerMain {

    // Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order
    public static int[] topKFrequent(int[] nums, int k) {
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

}

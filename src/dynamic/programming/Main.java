package dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class Main {

    protected int fibonacci(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    protected int fibonacciMemoization(int num, int[] memory) {
        if (memory[num] != 0) {
            return memory[num];
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        int calculation = fibonacciMemoization(num - 1, memory) + fibonacciMemoization(num - 2, memory);
        memory[num] = calculation;
        return calculation;
    }

    protected int fibonacciBottomUp(int num) {
        int[] memory;
        if (num == 1 || num == 2) {
            return 1;
        }
        memory = new int[num + 1];
        memory[1] = 1;
        memory[2] = 1;
        for (int i = 3; i <= num; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[num];
    }

    // 121. Best Time to Buy and Sell Stock
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    protected int maxProfitBruteForce(int[] prices) {
        int profit = 0;
        int pricesLength = prices.length;

        for (int i = 0; i < pricesLength; i++) {
            for (int j = i + 1; j < pricesLength; j++) {
                if (prices[j] > prices[i]) {
                    int subtract;
                    subtract = prices[j] - prices[i];
                    if (subtract > profit) {
                        profit = subtract;
                    }
                }
            }
        }
        return profit;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    protected int maxProfitFinal(int[] prices) {
        int higherPrice = 0;
        int lowestPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length - 1; i++) {
            int currentDayPrice = prices[i];
            int dayAfterPrice = prices[i + 1];
            if (dayAfterPrice > currentDayPrice && dayAfterPrice > higherPrice) {
                higherPrice = dayAfterPrice;
            }
            if (dayAfterPrice < lowestPrice) {
                lowestPrice = dayAfterPrice;
            }
        }
        return higherPrice == 0 ? higherPrice : higherPrice - lowestPrice;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    protected int maxProfitOptimal(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int sell = 0;

        for (int price : prices) {
            //Buying Department:
            buy = Math.min(buy, price);
            //Selling Department:
            sell = Math.max(sell, price - buy);
        }
        return sell;
    }

    // 198. House Robber
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    protected int robBruteForce(int[] nums) {
        int totalMoney = 0;
        int numsLength = nums.length;
        for (int i = 0; i < numsLength - 1; i++) {
            int money = nums[i];
            for (int j = i + 2; j < numsLength; j += 2) {
                money += nums[j];
                // TODO Try to improve
                if (j == numsLength - 2) {
                    break;
                }
            }
            if (money > totalMoney) {
                totalMoney = money;
            }
        }
        return totalMoney;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    protected int robOptimalTwoPointers(int[] nums) {
        int prevMax = 0;
        int currentMax = 0;

        for (int num : nums) {
            int temp = currentMax;
            currentMax = Math.max(prevMax + num, currentMax);
            prevMax = temp;
        }

        return currentMax;
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    // TODO check to understand
    protected int robOptimalMemory(int[] nums) {
        int numsLength = nums.length;

        if (numsLength == 0) {
            return 0;
        }
        if (numsLength == 1) {
            return nums[0];
        }

        int[] memory = new int[numsLength];
        memory[0] = nums[0];
        memory[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < numsLength; i++) {
            memory[i] = Math.max(nums[i] + memory[i - 2], memory[i - 1]);
        }

        return memory[numsLength - 1];
    }

    // 746. Min Cost Climbing Stairs
    // You are given an integer array cost where cost[i] is the cost of ith step on a staircase
    // Once you pay the cost, you can either climb one or two steps
    // You can either start from the step with index 0, or the step with index 1
    // Return the minimum cost to reach the top of the floor
    protected int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i < n; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[n - 1], cost[n - 2]);
    }

    // 688. Knight Probability in Chessboard
    // On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves
    // The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1)
    // A chess knight has eight possible moves it can make, as illustrated below
    // Each move is two cells in a cardinal direction, then one cell in an orthogonal direction
    protected double knightProbability(int N, int K, int r, int c) {
        Map<String, Double> map = new HashMap<>();

        // prob returns the total paths which stayed inside the board and then we divide it with total number of moves .
        return prob(N, K, r, c, map) / Math.pow(8, K);
    }

    private double prob(int N, int K, int r, int c, Map<String, Double> map) {
        // If the path is out of the board return 0 ;
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }

        String key = K + "->" + r + "->" + c;
        // If path is not out of the board and no moves left return 1;
        if (K == 0) {
            return 1;
        }
        if (map.containsKey(key)) {
            return map.get(key);
        }

        // There are total of 8 possible moves and we are traversing all the possible paths.
        double op1 = prob(N, K - 1, r + 2, c + 1, map);
        double op2 = prob(N, K - 1, r + 2, c - 1, map);
        double op3 = prob(N, K - 1, r - 2, c + 1, map);
        double op4 = prob(N, K - 1, r - 2, c - 1, map);
        double op5 = prob(N, K - 1, r - 1, c + 2, map);
        double op6 = prob(N, K - 1, r + 1, c + 2, map);
        double op7 = prob(N, K - 1, r + 1, c - 2, map);
        double op8 = prob(N, K - 1, r - 1, c - 2, map);

        double result = op1 + op2 + op3 + op4 + op5 + op6 + op7 + op8;
        map.put(key, result);
        return result;
    }

}

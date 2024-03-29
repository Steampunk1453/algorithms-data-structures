package dynamic.programming;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void fibonacci() {
        // Given
        Main main = new Main();
        long time = System.nanoTime();
        // When
        System.out.println("Starting Fibonacci Recursive");
        int result = main.fibonacci(45);
        System.out.println("Done in " + (System.nanoTime() - time) +" nano secs");
        // Then
        assertEquals(result, 1134903170);
    }

    @Test
    void fibonacciMemoization() {
        // Given
        Main main = new Main();
        int number = 45;
        int[] memory = new int[number + 1];
        long time = System.nanoTime();
        // When
        System.out.println("Starting Fibonacci Recursive Memoization");
        int result = main.fibonacciMemoization(number, memory);
        System.out.println("Done in " + (System.nanoTime() - time) +" nano secs");
        // Then
        assertEquals(result, 1134903170);
    }

    @Test
    void fibonacciBottomUp() {
        // Given
        Main main = new Main();
        long time = System.nanoTime();
        // When
        System.out.println("Starting Fibonacci Recursive Bottom-up");
        int result = main.fibonacciBottomUp(45);
        System.out.println("Done in " + (System.nanoTime() - time) +" nano secs");
        // Then
        assertEquals(result, 1134903170);
    }

    @Test
    void maxProfitBruteForce() {
        // Given
        Main main = new Main();
        int[] actual = {7,1,5,3,6,4};
        int expected = 5;
        // When
        int result = main.maxProfitBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitBruteForceReturnZero() {
        // Given
        Main main = new Main();
        int[] actual = {7,6,4,3,1};
        int expected = 0;
        // When
        int result = main.maxProfitBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitFinal() {
        // Given
        Main main = new Main();
        int[] actual = {7,1,5,3,6,4};
        int expected = 5;
        // When
        int result = main.maxProfitFinal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitFinalReturnZero() {
        // Given
        Main main = new Main();
        int[] actual = {7,6,4,3,1};
        int expected = 0;
        // When
        int result = main.maxProfitFinal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitOptimal() {
        // Given
        Main main = new Main();
        int[] actual = {7,1,5,3,6,4};
        int expected = 5;
        // When
        int result = main.maxProfitOptimal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitOptimalReturnZero() {
        // Given
        Main main = new Main();
        int[] actual = {7,6,4,3,1};
        int expected = 0;
        // When
        int result = main.maxProfitOptimal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robBruteForce() {
        // Given
        Main main = new Main();
        int[] actual = {1,2,3,1};
        int expected = 4;
        // When
        int result = main.robBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robBruteForce1() {
        // Given
        Main main = new Main();
        int[] actual = {2,7,9,3,1};
        int expected = 12;
        // When
        int result = main.robBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robBruteForce2() {
        // Given
        Main main = new Main();
        int[] actual = {6, 7, 1, 3, 8, 2, 4};
        int expected = 19;
        // When
        int result = main.robBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalTwoPointers() {
        // Given
        Main main = new Main();
        int[] actual = {1,2,3,1};
        int expected = 4;
        // When
        int result = main.robOptimalTwoPointers(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalTwoPointers1() {
        // Given
        Main main = new Main();
        int[] actual = {2,7,9,3,1};
        int expected = 12;
        // When
        int result = main.robOptimalTwoPointers(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalTwoPointers2() {
        // Given
        Main main = new Main();
        int[] actual = {6, 7, 1, 3, 8, 2, 4};
        int expected = 19;
        // When
        int result = main.robOptimalTwoPointers(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalTwoPointersEmpty() {
        // Given
        Main main = new Main();
        int[] actual = new int[2];
        int expected = 0;
        // When
        int result = main.robOptimalTwoPointers(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalTwoPointersDuplicate() {
        // Given
        Main main = new Main();
        int[] actual = {1,1};
        int expected = 1;
        // When
        int result = main.robOptimalTwoPointers(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalTwoPointersTwoElements() {
        // Given
        Main main = new Main();
        int[] actual = {1,2};
        int expected = 2;
        // When
        int result = main.robOptimalTwoPointers(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalTwoPointersThreeElements() {
        // Given
        Main main = new Main();
        int[] actual = {1,3,1};
        int expected = 3;
        // When
        int result = main.robOptimalTwoPointers(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalTwoPointersFourElements() {
        // Given
        Main main = new Main();
        int[] actual = {2,1,1,2};
        int expected = 4;
        // When
        int result = main.robOptimalTwoPointers(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalMemory() {
        // Given
        Main main = new Main();
        int[] actual = {1,2,3,1};
        int expected = 4;
        // When
        int result = main.robOptimalMemory(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimalMemory1() {
        // Given
        Main main = new Main();
        int[] actual = {2,7,9,3,1};
        int expected = 12;
        // When
        int result = main.robOptimalMemory(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    public void minCostClimbingStairs() {
        Main main = new Main();
        int[] cost1 = {10, 15, 20};
        assertEquals(15, main.minCostClimbingStairs(cost1));

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        assertEquals(6, main.minCostClimbingStairs(cost2));

        int[] cost3 = {0, 0, 0, 1};
        assertEquals(0, main.minCostClimbingStairs(cost3));

        int[] cost4 = {5, 1, 2, 4, 8, 6};
        assertEquals(11, main.minCostClimbingStairs(cost4));
    }

    @Test
    public void testKnightProbability() {
        // Given
        Main main = new Main();
        int N = 3;
        int K = 2;
        int r = 0;
        int c = 0;
        // expected probability for given inputs is 0.0625
        double expected = 0.0625;
        // When
        double probability = main.knightProbability(N, K, r, c);
        // Then
        assertEquals(expected, probability, 0.0001);
    }

}
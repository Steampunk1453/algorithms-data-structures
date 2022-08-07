package dynamic.programming;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DynamicTest {

    @Test
    void fibonacci() {
        // Given
        Dynamic dynamic = new Dynamic();
        long time = System.nanoTime();
        // When
        System.out.println("Starting Fibonacci Recursive");
        int result = dynamic.fibonacci(45);
        System.out.println("Done in " + (System.nanoTime() - time) +" nano secs");
        // Then
        assertEquals(result, 1134903170);
    }

    @Test
    void fibonacciMemoization() {
        // Given
        Dynamic dynamic = new Dynamic();
        int number = 45;
        int[] memory = new int[number + 1];
        long time = System.nanoTime();
        // When
        System.out.println("Starting Fibonacci Recursive Memoization");
        int result = dynamic.fibonacciMemoization(number, memory);
        System.out.println("Done in " + (System.nanoTime() - time) +" nano secs");
        // Then
        assertEquals(result, 1134903170);
    }

    @Test
    void fibonacciBottomUp() {
        // Given
        Dynamic dynamic = new Dynamic();
        long time = System.nanoTime();
        // When
        System.out.println("Starting Fibonacci Recursive Bottom-up");
        int result = dynamic.fibonacciBottomUp(45);
        System.out.println("Done in " + (System.nanoTime() - time) +" nano secs");
        // Then
        assertEquals(result, 1134903170);
    }

    @Test
    void maxProfitBruteForce() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {7,1,5,3,6,4};
        int expected = 5;
        // When
        int result = dynamic.maxProfitBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitBruteForceReturnZero() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {7,6,4,3,1};
        int expected = 0;
        // When
        int result = dynamic.maxProfitBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitFinal() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {7,1,5,3,6,4};
        int expected = 5;
        // When
        int result = dynamic.maxProfitFinal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitFinalReturnZero() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {7,6,4,3,1};
        int expected = 0;
        // When
        int result = dynamic.maxProfitFinal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitOptimal() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {7,1,5,3,6,4};
        int expected = 5;
        // When
        int result = dynamic.maxProfitOptimal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void maxProfitOptimalReturnZero() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {7,6,4,3,1};
        int expected = 0;
        // When
        int result = dynamic.maxProfitOptimal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robBruteForce() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {1,2,3,1};
        int expected = 4;
        // When
        int result = dynamic.robBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robBruteForce1() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {2,7,9,3,1};
        int expected = 12;
        // When
        int result = dynamic.robBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robBruteForce2() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {6, 7, 1, 3, 8, 2, 4};
        int expected = 19;
        // When
        int result = dynamic.robBruteForce(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimal() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {1,2,3,1};
        int expected = 4;
        // When
        int result = dynamic.robOptimal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimal1() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {2,7,9,3,1};
        int expected = 12;
        // When
        int result = dynamic.robOptimal(actual);
        // Then
        assertEquals(result, expected);
    }

    @Test
    void robOptimal2() {
        // Given
        Dynamic dynamic = new Dynamic();
        int[] actual = {6, 7, 1, 3, 8, 2, 4};
        int expected = 19;
        // When
        int result = dynamic.robOptimal(actual);
        // Then
        assertEquals(result, expected);
    }

}
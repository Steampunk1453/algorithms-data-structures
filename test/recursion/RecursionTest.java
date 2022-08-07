package recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RecursionTest {

    @Test
    void countDown() {
        // Given
        Recursion recursion = new Recursion();
        // When
        recursion.countDown(10);
    }

    @Test
    void factorial() {
        // Given
        Recursion recursion = new Recursion();
        // When
        long result = recursion.factorial(5);
        // Then
        assertEquals(result, 120);
    }

    @Test
    void findFactorialIterative() {
        // Given
        Recursion recursion = new Recursion();
        // When
        long result = recursion.findFactorialIterative(5);
        // Then
        assertEquals(result, 120);
    }
    @Test
    void findFactorialIterative1() {
        // Given
        Recursion recursion = new Recursion();
        // When
        long result = recursion.findFactorialIterative1(5);
        // Then
        assertEquals(result, 120);
    }

    @Test
    void factorialWithOutRecursion() {
        // Given
        Recursion recursion = new Recursion();
        // When
        long result = recursion.factorialWithOutRecursion(5);
        // Then
        assertEquals(result, 120);
    }

    @Test
    void arrayDouble() {
        // Given
        Recursion recursion = new Recursion();
        int[] array = {1, 2, 3, 4};
        // When
        int[] result = recursion.arrayDouble(array, 0);
        // Then
        assertEquals(result[0], 2);
    }

    @Test
    void arrayDouble1() {
        // Given
        Recursion recursion = new Recursion();
        int[] array = {1, 2, 3, 4};
        // When
        recursion.arrayDouble1(array, 0);
    }

    @Test
    void arraySum() {
        // Given
        Recursion recursion = new Recursion();
        int[] array = {1, 2, 3, 4, 5};
        // When
        int result = recursion.arraySum(array);
        // Then
        assertEquals(result, 15);
    }

    @Test
    void reverse() {
        // Given
        Recursion recursion = new Recursion();
        String input ="abcde";
        // When
        String result = recursion.reverse(input);
        // Then
        assertEquals(result, "edcba");
    }

    @Test
    void counting() {
        // Given
        Recursion recursion = new Recursion();
        // When
        int result = recursion.counting("axbxcxd");
        // Then
        assertEquals(result, 3);
    }

    @Test
    void arrayCharacters() {
        // Given
        Recursion recursion = new Recursion();
        String[] array = {"ab", "c", "def", "ghij"};
        // When
        int result = recursion.arrayCharacters(array);
        // Then
        assertEquals(result, 10);
    }

    @Test
    void evenNumbers() {
        // Given
        Recursion recursion = new Recursion();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> list = new ArrayList<>();
        // When
        List<Integer> result = recursion.evenNumbers(array, list);
        // Then
        assertEquals(result.size(), 3);
    }

    @Test
    void triangularNumber() {
        // Given
        Recursion recursion = new Recursion();
        // When
        int result = recursion.triangularNumber(7);
        // Then
        assertEquals(result, 28);
    }

    @Test
    void getIndex() {
        // Given
        Recursion recursion = new Recursion();
        String input = "abcdefghijklmnopqrstuvwxyz";
        // When
        int result = recursion.getIndex(input);
        // Then
        assertEquals(result, 23);
    }


    @Test
    void getIndex1() {
        // Given
        Recursion recursion = new Recursion();
        String input = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabet = input.toCharArray();
        // When
        int result = recursion.getIndex1(alphabet, 0, 'x');
        // Then
        assertEquals(result, 23);
    }

    @Test
    void uniquePaths() {
        // Given
        Recursion recursion = new Recursion();
        // When
        int result = recursion.uniquePaths(3, 7);
        // Then
        assertEquals(result, 28);
    }

    @Test
    void fibonacciRecursive() {
        // Given
        Recursion recursion = new Recursion();
        // When
        int result = recursion.fibonacciRecursive(10);
        // Then
        assertEquals(result, 55);
    }

    @Test
    void fibonacciIterative() {
        // Given
        Recursion recursion = new Recursion();
        // When
        int result = recursion.fibonacciIterative(9);
        // Then
        assertEquals(result, 34);
    }

    @Test
    void reverseStringRecursive() {
        // Given
        Recursion recursion = new Recursion();
        String input ="abcde";
        // When
        String result = recursion.reverseStringRecursive(input);
        // Then
        assertEquals(result, "edcba");
    }

    @Test
    void reverseStringIterative() {
        // Given
        Recursion recursion = new Recursion();
        String input ="abcde";
        // When
        String result = recursion.reverseStringIterative(input);
        // Then
        assertEquals(result, "edcba");
    }

}
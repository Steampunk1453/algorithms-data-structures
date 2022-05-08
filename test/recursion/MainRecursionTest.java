package recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainRecursionTest {

    @Test
    void countDown() {
        // Given
        MainRecursion recursion = new MainRecursion();
        // When
        recursion.countDown(10);
    }

    @Test
    void factorial() {
        // Given
        MainRecursion recursion = new MainRecursion();
        // When
        long result = recursion.factorial(5);
        // Then
        assertEquals(result, 120);
    }

    @Test
    void factorialWithOutRecursion() {
        // Given
        MainRecursion recursion = new MainRecursion();
        // When
        long result = recursion.factorialWithOutRecursion(5);
        // Then
        assertEquals(result, 120);
    }

    @Test
    void arrayDouble() {
        // Given
        MainRecursion recursion = new MainRecursion();
        int[] array = {1, 2, 3, 4};
        // When
        int[] result = recursion.arrayDouble(array, 0);
        // Then
        assertEquals(result[0], 2);
    }

    @Test
    void arrayDouble1() {
        // Given
        MainRecursion recursion = new MainRecursion();
        int[] array = {1, 2, 3, 4};
        // When
        recursion.arrayDouble1(array, 0);
    }

    @Test
    void arraySum() {
        // Given
        MainRecursion recursion = new MainRecursion();
        int array[] = {1, 2, 3, 4, 5};
        // When
        int result = recursion.arraySum(array);
        // Then
        assertEquals(result, 15);
    }

    @Test
    void reverse() {
        // Given
        MainRecursion recursion = new MainRecursion();
        String input ="abcde";
        // When
        String result = recursion.reverse(input);
        // Then
        assertEquals(result, "edcba");
    }

    @Test
    void counting() {
        // Given
        MainRecursion recursion = new MainRecursion();
        // When
        int result = recursion.counting("axbxcxd");
        // Then
        assertEquals(result, 3);
    }

    @Test
    void arrayCharacters() {
        // Given
        MainRecursion recursion = new MainRecursion();
        String[] array = {"ab", "c", "def", "ghij"};
        // When
        int result = recursion.arrayCharacters(array);
        // Then
        assertEquals(result, 10);
    }

    @Test
    void evenNumbers() {
        // Given
        MainRecursion recursion = new MainRecursion();
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
        MainRecursion recursion = new MainRecursion();
        // When
        int result = recursion.triangularNumber(7);
        // Then
        assertEquals(result, 28);
    }

    @Test
    void getIndex() {
        // Given
        MainRecursion recursion = new MainRecursion();
        String input = "abcdefghijklmnopqrstuvwxyz";
        // When
        int result = recursion.getIndex(input);
        // Then
        assertEquals(result, 23);
    }


    @Test
    void getIndex1() {
        // Given
        MainRecursion recursion = new MainRecursion();
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
        MainRecursion recursion = new MainRecursion();
        // When
        int result = recursion.uniquePaths(3, 7);
        // Then
        assertEquals(result, 28);
    }


}
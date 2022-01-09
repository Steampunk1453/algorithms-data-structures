package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainRecursionTest {

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
    void arraySum() {
        // Given
        MainRecursion recursion = new MainRecursion();
        int array[] = {2, 5, 6, 8, 9, 12};
        // When
        int result = recursion.arraySum(array, array.length);
        // Then
        assertEquals(result, 42);
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

}
package math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void subtract() {
        // Given
        Main main = new Main();
        // When
        int result = main.subtract(10, 8);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void multiply() {
        // Given
        Main main = new Main();
        // When
        int result = main.multiply(5, 4);
        // Then
        assertEquals(result, 20);
    }

    @Test
    void multiplyRecursive() {
        // Given
        Main main = new Main();
        // When
        int result = main.multiplyRecursive(5, 7);
        // Then
        assertEquals(result, 35);
    }

    @Test
    void division() {
        // Given
        Main main = new Main();
        // When
        int result = main.division(10, 5);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void division1() {
        // Given
        Main main = new Main();
        // When
        int result = main.division1(10, 2);
        // Then
        assertEquals(result, 5);
    }

    @Test
    void pow() {
        // Given
        Main main = new Main();
        // When
        int result = main.pow(3, 6);
        // Then
        assertEquals(result, 729);
    }

    @Test
    void pow1() {
        // Given
        Main main = new Main();
        // When
        int result = main.pow1(3, 6);
        // Then
        assertEquals(result, 729);
    }

    @Test
    void factorial() {
        // Given
        Main main = new Main();
        // When
        int result = main.factorial(3);
        // Then
        assertEquals(result, 6);
    }

    @Test
    void factorial1() {
        // Given
        Main main = new Main();
        // When
        int result = main.factorial1(7);
        // Then
        assertEquals(result, 5040);
    }

    @Test
    void factorial2() {
        // Given
        Main main = new Main();
        // When
        int result = main.factorial2(7);
        // Then
        assertEquals(result, 5040);
    }

    @Test
    void isPerfectNumber() {
        // Given
        Main main = new Main();
        // When
        boolean result = main.isPerfectNumber(28);
        // Then
        assertTrue(result);
    }

    @Test
    void isAmicableNumbers() {
        // Given
        Main main = new Main();
        // When
        boolean result = main.isAmicableNumbers(220, 284);
        // Then
        assertTrue(result);
    }

    @Test
    void isPrime() {
        // Given
        Main main = new Main();
        // When
        boolean result = main.isPrime(29);
        // Then
        assertTrue(result);
    }

    @Test
    void isCool() {
        // Given
        Main main = new Main();
        // When
        boolean result = main.isCool(28);
        // Then
        assertTrue(result);
    }

    @Test
    void calculateArrayValues() {
        // Given
        Main main = new Main();
        double[] array = {5.2, 2.2, 7.7, 4.0, 6.4};
        // When
        main.calculateArrayValues(array);
        // Then
    }

    @Test
    void romanToInteger() {
        // Given
        Main main = new Main();
        String romanNumber = "III";
        // When
        int result = main.romanToInteger(romanNumber);
        // Then
        assertEquals(result, 3);
    }

    @Test
    void romanToInteger1() {
        // Given
        Main main = new Main();
        String romanNumber = "LVIII";
        // When
        int result = main.romanToInteger(romanNumber);
        // Then
        assertEquals(result, 58);
    }

    @Test
    void romanToInteger2() {
        // Given
        Main main = new Main();
        String romanNumber = "MCMXCIV";
        // When
        int result = main.romanToInteger(romanNumber);
        // Then
        assertEquals(result, 1994);
    }
    @Test
    void romanToInteger3() {
        // Given
        Main main = new Main();
        String romanNumber = "MDCXCV";
        // When
        int result = main.romanToInteger(romanNumber);
        // Then
        assertEquals(result, 1695);
    }

    @Test
    void sqrt() {
        // Given
        Main main = new Main();
        // When
        int result = main.sqrt(8);
        // Then
        assertEquals(result, 2);
    }

}
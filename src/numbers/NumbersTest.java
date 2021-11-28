package numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersTest {

    @Test
    void subtract() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.subtract(10, 8);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void multiply() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.multiply(5, 4);
        // Then
        assertEquals(result, 20);
    }

    @Test
    void division() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.division(10, 5);
        // Then
        assertEquals(result, 2);
    }

    @Test
    void division1() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.division1(10, 2);
        // Then
        assertEquals(result, 5);
    }

    @Test
    void pow() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.pow(3, 6);
        // Then
        assertEquals(result, 729);
    }

    @Test
    void pow1() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.pow1(3, 6);
        // Then
        assertEquals(result, 729);
    }

    @Test
    void countDown() {
        // Given
        Numbers numbers = new Numbers();
        // When
        numbers.countDown(5);
        // Then
    }

    @Test
    void factorial() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.factorial(5);
        // Then
        assertEquals(result, 120);
    }

    @Test
    void factorialJJ() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.factorialJJ(3);
        // Then
        assertEquals(result, 6);
    }

    @Test
    void factorialWhile() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.factorialWhile(7);
        // Then
        assertEquals(result, 5040);
    }

    @Test
    void factorialFor() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.factorialFor(7);
        // Then
        assertEquals(result, 5040);
    }

    @Test
    void isPerfectNumber() {
        // Given
        Numbers numbers = new Numbers();
        // When
        boolean result = numbers.isPerfectNumber(28);
        // Then
        assertTrue(result);
    }

    @Test
    void isAmicableNumbers() {
        // Given
        Numbers numbers = new Numbers();
        // When
        boolean result = numbers.isAmicableNumbers(220, 284);
        // Then
        assertTrue(result);
    }

    @Test
    void isPrime() {
        // Given
        Numbers numbers = new Numbers();
        // When
        boolean result = numbers.isPrime(29);
        // Then
        assertTrue(result);
    }

    @Test
    void isCool() {
        // Given
        Numbers numbers = new Numbers();
        // When
        boolean result = numbers.isCool(28);
        // Then
        assertTrue(result);
    }

    @Test
    void calculateArrayValues() {
        // Given
        Numbers numbers = new Numbers();
        double[] array = {5.2, 2.2, 7.7, 4.0, 6.4};
        // When
        numbers.calculateArrayValues(array);
        // Then
    }

    @Test
    void fibonacci() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.fibonacciNum(5);
        // Then
        assertEquals(result, 5);
    }

    @Test
    void recursiveMulti() {
        // Given
        Numbers numbers = new Numbers();
        // When
        int result = numbers.recursiveMulti(3, 3);
        // Then
        assertEquals(result, 9);
    }

}
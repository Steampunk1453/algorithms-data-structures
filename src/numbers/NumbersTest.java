package numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}
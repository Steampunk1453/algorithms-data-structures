package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoDimensionalTest {

    @Test
    void createAgenda() {
        // Given
        TwoDimensional twoDimensional = new TwoDimensional();
        // When
        int[][] result =  twoDimensional.createAgenda();
        // Then
        assertEquals(result.length, 12);
    }


}
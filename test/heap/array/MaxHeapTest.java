package heap.array;

import heap.array.MaxHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    @Test
    void insert() {
        // Given
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        // When
        maxHeap.insert(9);
        // Then
        maxHeap.print();
        assertEquals(84, maxHeap.getFirst());
    }

    @Test
    void insert1() {
        // Given
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(100);
        maxHeap.insert(88);
        maxHeap.insert(25);
        maxHeap.insert(87);
        maxHeap.insert(16);
        maxHeap.insert(8);
        maxHeap.insert(12);
        maxHeap.insert(86);
        maxHeap.insert(50);
        maxHeap.insert(2);
        maxHeap.insert(15);
        // When
        maxHeap.insert(3);
        // Then
        maxHeap.print();
        assertEquals(100, maxHeap.getFirst());
    }

    @Test
    void remove() {
        // Given
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        // When
        maxHeap.remove();
        // Then
        maxHeap.print();
        assertEquals(22, maxHeap.getFirst());
    }
    @Test
    void remove1() {
        // Given
        MaxHeap maxHeap = new MaxHeap(25);
        maxHeap.insert(100);
        maxHeap.insert(88);
        maxHeap.insert(25);
        maxHeap.insert(87);
        maxHeap.insert(16);
        maxHeap.insert(8);
        maxHeap.insert(12);
        maxHeap.insert(86);
        maxHeap.insert(50);
        maxHeap.insert(2);
        maxHeap.insert(15);
        maxHeap.insert(3);
        // When
        maxHeap.remove();
        // Then
        maxHeap.print();
        assertEquals(88, maxHeap.getFirst());
    }


}
package tree.heap.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    @Test
    void insert() {
        // Given
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        // When
        minHeap.insert(9);
        // Then
        minHeap.print();
        assertEquals(3, minHeap.getRoot());
    }

    @Test
    void remove() {
        // Given
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        // When
        minHeap.remove();
        // Then
        minHeap.print();
        assertEquals(5, minHeap.getRoot());
    }

    @Test
    void print() {
    }
}
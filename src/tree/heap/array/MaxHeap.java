package tree.heap.array;

public class MaxHeap {
    public static final int FRONT = 0;
    private final int[] heap;
    private final int maxSize;
    private int size;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize];
    }

    // Inserts a new element to max heap
    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        heap[size] = element;
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    // Remove an element from max heap
    public int remove() {
        int popped = heap[FRONT];
        heap[FRONT] = heap[size - 1];
        size--;
        maxHeapify(FRONT);
        return popped;
    }

    // To display heap
    public void print() {
        for (int i = 0; i < size / 2; i++) {

            System.out.print("Parent Node: " + heap[i]);

            if (left(i) < size) //if the child is out of the bound of the array
                System.out.print(" Left Child Node: " + heap[left(i)]);

            if (right(i) < size) //if the right child index must not be out of the index of the array
                System.out.print(" Right Child Node: " + heap[right(i)]);

            System.out.println(); //for new line

        }
    }

    public int getFirst() {
        return heap[FRONT];
    }

    public int getLast() {
        return heap[size - 1];
    }

    // Returning position of parent
    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    // Returning left children
    private int left(int pos) {
        return 2 * pos + 1;
    }

    // Returning right children
    private int right(int pos) {
        return 2 * pos + 2;
    }

    // Returning true of given node is leaf
    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }

    // Swapping nodes
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    // Recursive function to max heapify given subtree
    private void maxHeapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        if (heap[pos] < heap[left(pos)] || heap[pos] < heap[right(pos)]) {
            if (heap[left(pos)] > heap[right(pos)]) {
                swap(pos, left(pos));
                maxHeapify(left(pos));
            } else {
                swap(pos, right(pos));
                maxHeapify(right(pos));
            }
        }
    }

}

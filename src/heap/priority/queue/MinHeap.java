package heap.priority.queue;

import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String[] args)
    {

        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        // Adding items to the priority queue
        // using add() method
        pQueue.add(10);
        pQueue.add(30);
        pQueue.add(20);
        pQueue.add(400);

        // Printing the most priority element
        System.out.println("Head value using peek function: " + pQueue.peek());

        // Printing all elements
        System.out.println("The queue elements:");

        for (Integer item : pQueue) System.out.println(item);

        // Removing the top priority element (or head) and
        // printing the modified pQueue using poll()
        pQueue.poll();
        System.out.println("After removing an element with poll function:");

        for (Integer item : pQueue) System.out.println(item);

        // Removing 30 using remove()
        pQueue.remove(30);

        System.out.println("after removing 30 with remove function: ");

        // Again creating iterator object
        for (Integer integer : pQueue) System.out.println(integer);

        // Check if an element is present using contains()
        boolean b = pQueue.contains(20);
        System.out.println("Priority queue contains 20 or not?: " + b);

        // Getting objects from the queue using toArray()
        // in an array and print the array
        Object[] arr = pQueue.toArray();

        System.out.println("Value in array: ");

        for (int i = 0; i < arr.length; i++)
            System.out.println("Value: " + arr[i].toString());
    }

}

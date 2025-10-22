/**
 * =============================================
 *  Class: RingQueue
 *  Project: SortBenchmarkTool / Data Structures
 *  Author: Vladimir K. (@vkir090)
 *  Date:   2025-10-22
 * =============================================
 *
 * Description:
 * This class implements a circular queue (ring buffer)
 * based on an array. Both enqueue and dequeue operations
 * run in constant time O(1).
 *
 * Key Concepts:
 * - Practical use of the modulo operator
 * - State management via front, rear, and count
 * - Handling overflow and capacity limits
 *
 * Example:
 * RingQueue q = new RingQueue(3);
 * q.enqueue(10);
 * q.enqueue(20);
 * System.out.println(q.dequeue()); // 10
 *
 * License:
 * MIT License – free for educational and commercial use.
 */

public class RingQueue {
    private int[] data;
    private int front;
    private int rear;
    private int count;
    private int capacity;

    public RingQueue(int capacity) {
        this.data = new int[capacity]; 
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.capacity = capacity;
    }

    public void enqueue(int value) {
        if (isFull()){
            throw new IllegalStateException("Queue is full");
        } else {
            data[rear] = value; 
            rear = (rear+1)%capacity;  
            ++count;
        }
    }
    
    public int dequeue() { 
        int elementfront = data[front]; 
        data[front] = 0;
        front = (front+1)%capacity; 
        --count;
        return elementfront;
    }
    
    public int peek() { 
        return data[front]; 
    }
    
    public boolean isEmpty() { 
        return count==0;
    }
    
    public boolean isFull() { 
        return (rear+1)%capacity==front;
    }
    
    public int size() { 
        return count;
    }
    
}

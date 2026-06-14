class MyCircularQueue {
// 1. The Blueprint for our Singly Linked List Node
    class Node {
        int val;
        Node next;
        
        public Node(int val) {
            this.val = val;
        }
    }

    // 2. Class Variables
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    // 3. Constructor
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false; // Speed limit reached!
        
        Node newNode = new Node(value);
        
        if (isEmpty()) {
            // If the line is empty, the new guy is both the front AND the back.
            head = newNode;
            tail = newNode;
        } else {
            // Tell the current last guy to point to the new guy
            tail.next = newNode;
            // The new guy is now the official tail
            tail = newNode;
        }
        
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        
        // The line moves forward! The old head is left behind and deleted by Java.
        head = head.next;
        size--;
        
        // CRITICAL EDGE CASE: If we just removed the very last person, 
        // the tail pointer shouldn't be pointing to a ghost. Set it to null!
        if (size == 0) {
            tail = null;
        }
        
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return head.val;
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return tail.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
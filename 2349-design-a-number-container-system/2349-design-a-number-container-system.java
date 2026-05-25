class NumberContainers {

   // The Source of Truth: Maps an Index to the Number currently sitting there.
    Map<Integer, Integer> indexToNumber;
    
    // The Map of Heaps: Maps a Number to a Min-Heap of all indices it has EVER been at.
    Map<Integer, PriorityQueue<Integer>> numberToIndices;

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }
    
    public void change(int index, int number) {
        // 1. Update the Source of Truth
        indexToNumber.put(index, number);
        
        // 2. Blindly push the index into this number's heap
        // (Create the heap first if this is a brand new number)
        numberToIndices.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
    }
    
    public int find(int number) {
        // If we have never seen this number, return -1
        if (!numberToIndices.containsKey(number)) {
            return -1;
        }
    
        PriorityQueue<Integer> minHeap = numberToIndices.get(number);
        
        // THE CLEANUP PHASE (Lazy Deletion)
        // Check the top index. If the Source of Truth says a DIFFERENT number 
        // is currently at this index, then this index is a ghost! Pop it.
        while (!minHeap.isEmpty()) {
            int smallestIndex = minHeap.peek();
            
            // Does the Source of Truth match our current number?
            if (indexToNumber.get(smallestIndex) == number) {
                break; // It's valid! Stop cleaning.
            }
            
            // It's a ghost. Throw it away and check the next one.
            minHeap.poll();
        }
        // After cleaning, if the heap is empty, there are no valid indices left.
        return minHeap.isEmpty() ? -1 : minHeap.peek();
}
}
/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
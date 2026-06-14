class BrowserHistory {

  // 1. The blueprint you described: Doubly Linked List Node
    class Node {
        String url;   // The string field for the URL
        Node prev;    // Pointer to go backward
        Node next;    // Pointer to go forward
        
        public Node(String url) {
            this.url = url;
        }
    }

    // This is the "Explorer" pointer you mentioned. 
    // It keeps track of exactly where we are right now.
    private Node curr;

    // 2. The Constructor
    // "When we initialise itself the object, we should create one thing... Initiate there itself"
    public BrowserHistory(String homepage) {
        // We create the very first node (The Anchor) and set our Explorer to stand on it.
        curr = new Node(homepage);
    }
    
    // 3. The Visit Function
    // "We will create new node each time... link the previous next thing"
    public void visit(String url) {
        Node newNode = new Node(url);
        
        // Link the new node to our current position
        curr.next = newNode;
        newNode.prev = curr;
        
        // The Explorer moves forward to the brand new page!
        // This automatically leaves any old forward history behind to be deleted.
        curr = newNode;
    }
    
    // 4. The Back Function
    // "keep a counter. I try to decrement it... condition will be K should be greater than zero... should not be like null"
    public String back(int steps) {
        // Keep moving back until we run out of steps OR hit the very first page
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }
        
        // Return the URL of wherever the Explorer ended up
        return curr.url;
    }
    
    // 5. The Forward Function
    // "Forward will just do the same thing but the Next thing"
    public String forward(int steps) {
        // Keep moving forward until we run out of steps OR hit the very last page
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }
        
        // Return the URL of wherever the Explorer ended up
        return curr.url;
}
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
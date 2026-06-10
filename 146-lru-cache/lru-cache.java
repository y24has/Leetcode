class LRUCache {
    
    class Node{
         int key;
         int val;
         Node prev;
         Node next;

         Node(int key,int val){
        this.key=key;
        this.val=val;
    }
    }
    private int capacity;
    private Map<Integer,Node> map;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    private void remove(int key){
           Node toremove=map.get(key);

           toremove.prev.next=toremove.next;
           toremove.next.prev=toremove.prev;
    }

    public void insert(Node node){
           Node nxt_node=head.next;
           head.next=node;
           node.prev=head;
           node.next=nxt_node;
           nxt_node.prev=node;
    }
    public int get(int key) {
         if(map.containsKey(key)){
            Node toget=map.get(key);
            remove(toget.key);
            insert(toget);
            
            return toget.val;
         }
         return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node G_Key=map.get(key);
            G_Key.val=value;
            remove(G_Key.key);
            insert(G_Key);
        }else{
            if(map.size()==capacity){
                Node new_node=tail.prev;
                int toRem=new_node.key;
                remove(toRem);
                map.remove(toRem);
            }
            Node toAdd=new Node(key,value);
            insert(toAdd);
            map.put(key,toAdd);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
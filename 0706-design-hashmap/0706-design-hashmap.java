class MyHashMap {
    int[][] table;
    int bucket=1001;
    int bucket_Size=1001;
    public MyHashMap() {
       table=new int[bucket][];
    }
    public int Hashkey(int key){
        int hash=(key)%bucket;
        return hash;
    }

    public int pos(int key){
        int position=(key)/bucket;
        return position;
    }
    public void put(int key, int value) {
        int hash=Hashkey(key);
    
        if(table[hash]==null){
            table[hash]=new int[1001];
        }
        table[hash][pos(key)]=value+1;
    }
    
    public int get(int key) {
        int hash=Hashkey(key);
        int position=pos(key);
        int val=0;
          if(table[hash]==null) return -1;
         if(table[hash]!=null){
           val=table[hash][position];
    }
     return val == 0 ? -1 : val - 1;
    }
    
    public void remove(int key) {
        int hash=Hashkey(key);
       // int position=pos(key);
    if(table[hash]!=null){
         table[hash][pos(key)]=0;
    }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
class ProductOfNumbers {

   
    List<Integer> prefix_list;
    public ProductOfNumbers() {
        prefix_list = new ArrayList<>();
        prefix_list.add(1);
    }

    public void add(int num) {
        if(num==0){
            prefix_list.clear();
            prefix_list.add(1);
            return;
        }
        prefix_list.add(prefix_list.get(prefix_list.size()-1)*num);
    }

    public int getProduct(int k) {
        int product=1;
        if(k>=prefix_list.size()) return 0;
        product=prefix_list.get(prefix_list.size()-1)
             / prefix_list.get(prefix_list.size()-1-k);
        return product;
    }
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();

for (int x : nums) {
    if (set.contains(x)) {
        res.add(x);
    } else {
        set.add(x);
    }
}
 return res;
    }
}
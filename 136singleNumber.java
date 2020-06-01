class Solution {
    /**
    * two for loop (not nested) means O(2n)
    * use hashMap --- O(n)
    * use ArrayList --- O(N^2) because contains() iterate n items to search
    */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            numbers.put(nums[i], numbers.getOrDefault(nums[i],0) + 1);
        }
        for (int i: nums){
            if (numbers.get(i) == 1){
                return i;
            }
        }
        return 0;

        // Method 2: Use ArrayList
        // List<Integer> no_duplicate_list = new ArrayList<>();
        // for (int i : nums) {
        //   if (!no_duplicate_list.contains(i)) {
        //     no_duplicate_list.add(i);
        //   } else {
        //     no_duplicate_list.remove(new Integer(i));
        //   }
        // }
        // return no_duplicate_list.get(0);
        
    }
}


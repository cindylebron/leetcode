class Solution {
    public int findPairs(int[] nums, int k) {
        // O(n^2)
        Arrays.sort(nums);
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i=0; i<nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
               int diff = nums[j] - nums[i];
                if (diff == k) {
                    System.out.println(nums[i]+" "+nums[j]);
                    a.put(nums[i], nums[j]);
                } 
            }
        }
        return a.size();
    }
}
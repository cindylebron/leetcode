class Solution {
    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        len = nums.length;
        return kSum(nums, target, 4, 0);
    }
    
    private List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        // result
        List<List<Integer>> res = new ArrayList<>();
        
        if (index == len || nums[index] * k > target || target > nums[len-1] * k)
            return res;
        // two sum
        if (k == 2) {
            // left and right boundary
            int low = index, high = len - 1;
            while(low < high) {
                System.out.println(low+" "+ high);
                int sum = nums[low] + nums[high];
                //edge case:
                // current value is the same as the one before, increment low/decrement high
                // nums[low]+nums[high] is less than target, increment low
                // nums[low]+nums[high] is greater than target, decrement high
                if (sum < target || (low > index && nums[low] == nums[low-1])) ++low;
                else if (sum > target || (high < len - 1 && nums[high] == nums[high+1])) --high;
                else
                    res.add(Arrays.asList(nums[low++], nums[high--]));
            }
        } //end of two sum
        else {
            // iterate i through the array from start
            for (int i = index; i < len; ++i) {
                // if current value is the same as the one before, skip it
                if (i == index || nums[i] != nums[i - 1]) {
                    for (var set : kSum(nums, target - nums[i], k - 1, i + 1)) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i])));
                        res.get(res.size() - 1).addAll(set);
                    }/* 加入所有元素 */
                }
            }
        }
        return res;
    }
}
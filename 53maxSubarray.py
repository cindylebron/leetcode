class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = []
        for i in range(len(nums)):
            if i == 0:
                dp.append(nums[0])
            else:
                dp.append(nums[i] + max(0, dp[i-1]))
        return max(dp)

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_so_far, rsum = nums[0], 0
        for i in range(len(nums)) :
            rsum += nums[i]
            if rsum > max_so_far: 
                max_so_far = rsum
            if rsum < 0:
                rsum = 0
            print(rsum)
        return max_so_far
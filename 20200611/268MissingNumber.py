class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        sortedList = sorted(nums)
        for i,num in zip(range(len(nums)), sortedList):
            if i != num:
                return i
        return len(nums)
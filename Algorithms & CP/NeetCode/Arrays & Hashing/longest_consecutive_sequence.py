from typing import List

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        nums.sort()
        seq_len, max_len = 1, 1
        for i in range(len(nums)-1):
            if nums[i] != nums[i+1]:
                if nums[i] == nums[i+1]-1:
                    seq_len += 1
                else:
                    max_len = max(seq_len, max_len)
                    seq_len = 1
        return max(seq_len, max_len)
    
nums = [2,20,4,10,3,4,5]

mysolution = Solution()
mysolution.longestConsecutive(nums)
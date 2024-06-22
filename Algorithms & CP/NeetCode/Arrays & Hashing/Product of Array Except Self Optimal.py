from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        answer = [1] * len(nums)
        multi = 1
        for i in range(1, len(nums)):
            answer[i] = answer[i-1]*nums[i-1]
        for i in range(1, len(nums)):
            multi *= nums[-i]
            answer[-i-1] = answer[-i-1]*multi
        return answer
    
nums = [1,2,3,4]
solution = Solution()
print(solution.productExceptSelf(nums))
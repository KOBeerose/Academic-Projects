class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        answer = []
        for i in range(0, len(nums)):
            left_array = nums[:i]
            right_array = nums[i+1:]
            left_v, right_v = 1, 1
            for x in left_array:
                left_v *= x
            for x in right_array:
                right_v *= x
            answer.append(left_v*right_v)
        return answer
    
nums = [1,2,3,4]
solution = Solution()
print(solution.productExceptSelf(nums))
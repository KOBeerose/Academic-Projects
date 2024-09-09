from typing import List
class Solution:
    @staticmethod
    def findMin(nums: List[int]) -> int:
        '''compare edge with middle element
            if (left or right) and middle is inc => res in other half
            if both are inc => check left
            if n = 2 return min
        '''
        left, right = 0, len(nums) - 1
        res = nums[0]
        while right >= left:
            middle = (right+left)//2
            res = min(res, nums[middle])
            if nums[left] < nums[middle]:
                if nums[middle] < nums[right]:
                    right = middle - 1
                else:
                    left = middle + 1
            else:
                if nums[middle] < nums[right]:
                    right = middle - 1
                else:
                    res = min(res, nums[right])
                    left = middle + 1
        return res

nums = [3,4,5,6,1,2]
print(Solution.findMin(nums))
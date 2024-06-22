from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        track = {}
        for num in nums:
            if num in track:
                return True
            else:
                track[num]=True
        return False


nums = [1,1,1,3,3,4,3,2,4,2]
mysolution = Solution()
print(mysolution.containsDuplicate(nums))
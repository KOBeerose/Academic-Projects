from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result_set = set()
        nums.sort()
        for i in range(len(nums)-1):
            j, k = i+1, len(nums)-1
            while k>j:
                num_sum = nums[i]+nums[j]+nums[k]
                if num_sum>0:
                    k-=1
                elif num_sum<0:
                    j+=1
                else:
                    result_set.add((nums[i], nums[j], nums[k]))
                    j, k = j+1, k-1
        result = []
        for elem in result_set:
            result.append(list(elem))
        return result

nums = [-1,0,1,2,-1,-4]

mysolution = Solution()
mysolution.threeSum(nums)
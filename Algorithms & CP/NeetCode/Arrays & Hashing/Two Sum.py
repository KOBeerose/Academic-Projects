class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        hashmap = {}
        for i in range(len(nums)):
            wanted = target - nums[i]
            if nums[i] in hashmap:
                return [i, hashmap[nums[i]]]
            hashmap[wanted] = i

nums = [2,7,11,15]
target = 9

mysolution = Solution()
print(mysolution.twoSum(nums, target))
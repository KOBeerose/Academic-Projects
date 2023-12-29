from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        frequency = defaultdict(int)
        for num in nums:
            frequency[num] += 1
        result = []
        while k>0:
            max = 0
            for elem in frequency:
                if frequency[elem] > max:
                    max = frequency[elem]
            result.append(max)
            frequency.pop(max)
        return result
    
nums = [1,1,1,2,2,3]
k = 2
solution = Solution()
print(solution.topKFrequent(nums, k))

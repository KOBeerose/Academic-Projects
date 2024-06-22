from typing import List
from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        word_count = defaultdict(int)
        for num in nums:
            word_count[num] += 1
        result = []
        while k > 0:
            max = None
            for key, value in word_count.items():
                if word_count.get(max, 0)<value:
                    max = key
            result.append(max)
            del word_count[max]
            k -=1
        return result
    
nums = [1,1,1,2,2,3]
k = 2
solution = Solution()
print(solution.topKFrequent(nums, k))

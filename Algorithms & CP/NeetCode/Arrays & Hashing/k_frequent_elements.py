from typing import List
from collections import defaultdict
import heapq

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # counts = defaultdict(int)
        # for num in nums:
        #     counts[num] += 1
        # order = sorted(counts, key=counts.get, reverse=True)
        # result = []
        # for w in order[:k]:
        #     result.append(w)
        # return result
        counts = defaultdict(int)
        for num in nums:
            counts[num] += 1

        dummy_heap = [(-val, key) for key, val in counts.items()]
        heapq.heapify(dummy_heap)
        result = []
        while k:
            result.append(heapq.heappop(dummy_heap)[1])
            k -= 1
            
        return result

nums = [1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5]
k = 3
solution = Solution()
print(solution.topKFrequent(nums, k))

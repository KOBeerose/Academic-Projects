from collections import defaultdict
class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        counts = defaultdict(int)
        for num in nums:
            counts[num] += 1
        order = sorted(counts, key=counts.get, reverse=True)
        result = []
        for w in order[:k]:
            result.append(w)
        return result


nums = [1]
k = 2
solution = Solution()
print(solution.topKFrequent(nums, k))

class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        freq_dict = {}
        freq_array = [[] for _ in range(len(nums) + 1)]
        for num in nums:
            freq_dict[num] = 1 + freq_dict.get(num, 0)
        for num, count in freq_dict.items():    
            freq_array[count].append(num)
            
        result = []
        for i in range(len(freq_array)-1, 0, -1):
            for elem in freq_array[i]:
                if len(result)<k:
                    result.append(elem)
        return result
    
nums = [1,1,1,1,1,2,3,3,2,2]
k = 2
solution = Solution()
print(solution.topKFrequent(nums, k))

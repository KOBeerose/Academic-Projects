from typing import List
from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        sorted_strs = [ ''.join(sorted(elem)) for elem in strs]
        hashmap = defaultdict(list)
        for i, elem in enumerate(sorted_strs):
            hashmap[elem].append(strs[i])
        return hashmap.values()
       

#strs = ["","b", 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k']
strs = ["eat","tea","tan","ate","nat","bat"]
solution = Solution()
print(solution.groupAnagrams(strs))

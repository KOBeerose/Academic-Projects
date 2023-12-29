from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        hashmap = defaultdict(list)
        for string in strs:
            map = [0]*26
            for char in string:
                map[ord(char)-97] += 1
            hashmap[tuple(map)].append(string)
        return hashmap.values()


                 
       

#strs = ["","b", 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k']
strs = ["eat","tea","tan","ate","nat","bat"]
solution = Solution()
print(solution.groupAnagrams(strs))

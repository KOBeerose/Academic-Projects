class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        sorted_strs = [''.join(sorted(s)) for s in strs]
        track = {}
        for i in range(len(strs)):
            if sorted_strs[i] in track:
                track[sorted_strs[i]].append(strs[i])
            else:
                track[sorted_strs[i]] = [strs[i]]
        return track.values()
       

#strs = ["","b", 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k']
strs = ["eat","tea","tan","ate","nat","bat"]
solution = Solution()
print(solution.groupAnagrams(strs))

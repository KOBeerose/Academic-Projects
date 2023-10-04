from collections import defaultdict

class Solution:
    @staticmethod
    def isAnagrams(s, t):
        if len(s) != len(t):
            return False
        track = defaultdict(int)
        for i in range(len(s)):
            track[s[i]]+=1
            track[t[i]]-=1
        for key in track:
            if track[key] != 0:
                return False
        return True
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        result, temp = [], []
        track = {}
        i, ctr = 0, 0
        while ctr < len(strs) :
            if i in track: i+=1; continue
            j = i+1
            temp = [strs[i]]
            while j < len(strs):
                if j in track: j+=1; continue
                if self.isAnagrams(strs[i],strs[j]):
                    temp.append(strs[j])
                    track[j] = True
                j+=1
            ctr += len(temp)
            i+=1
            result.append(temp)
        return result

strs = ["","b", 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k']
#strs = ["eat","tea","tan","ate","nat","bat"]
solution = Solution()
print(solution.groupAnagrams(strs))

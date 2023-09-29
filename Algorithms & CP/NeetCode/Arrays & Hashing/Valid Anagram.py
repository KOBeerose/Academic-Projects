from collections import defaultdict
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        track = defaultdict(int)
        for i in range(len(s)):
            track[s[i]] += 1
            track[t[i]] -= 1

        for key in track:
            if track[key] != 0:
                return False
        return True
        
        
s = "a"
t = "ab"
mysolution = Solution()
print(mysolution.isAnagram(s, t))

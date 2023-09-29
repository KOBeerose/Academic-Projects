from collections import defaultdict
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        track = defaultdict(int)

        for i in range(len(s)):
            if s[i] in track:
                track[s[i]] += 1

        for j in range(len(t)):
            if t[j] in track:
                track[t[j]] -= 1

        for key in track:
            if track[key] != 0:
                return False
                
        return True
        
        
s = "a"
t = "ab"
mysolution = Solution()
print(mysolution.isAnagram(s, t))
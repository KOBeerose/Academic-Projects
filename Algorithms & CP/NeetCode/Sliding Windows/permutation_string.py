from collections import defaultdict
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1_map = defaultdict(int)
        for char in s1:
            s1_map[char] += 1
        
        s2_map = defaultdict(int)
        p, counter = 0, 0
        while p < len(s2):
            if s2[p] in s1_map:
                if counter < len(s1):
                    s2_map[s2[p]] += 1
                    counter += 1
                else:
                    s2_map = defaultdict(int)
                    p = p - counter
                    counter = 0
                if len(s1_map) == len(s2_map) and s1_map == s2_map:
                    return True

            else:
                s2_map = defaultdict(int)
            p += 1
        return False

    
s1="ab"
s2="eidboaoo"
print(Solution().checkInclusion(s1, s2))
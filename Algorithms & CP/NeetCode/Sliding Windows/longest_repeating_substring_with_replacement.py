from collections import defaultdict

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        char_map = defaultdict(int)
        start, max_char = 0, 0
        res = 0
        
        for r in range(len(s)):
            char_map[s[r]] += 1
            max_char = max(char_map[s[r]], max_char)

            if (r-start)-max_char < k:
                res = max(res, r-start+1)
            else:
                char_map[s[start]] -= 1
                start += 1
            r += 1
        return res

s="AABABBA"
k=1

print(Solution().characterReplacement(s, k))
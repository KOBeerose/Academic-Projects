from collections import defaultdict

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # "O U Z O D Y X A Z V Y X X A Z"  "X X Y Z" {X:1, Y:0, Z:0} | {X:2, Y:1, Z:1}
        #                      | |                 |  
        '''
        First get the count of each element in t
        have start pointer to search for existing elem in t_map 
        once s[start] in t_map we decrease the count incrementing the end pointer until:
            1- we reach the end of the s -> return ""
            2- we find another element in t_map that has 0 in counter -> reset t_map and two pointers
            3- we reach an element where all values in t_map are 0
        '''
        if len(s) < len(t):
            return ""

        map_t = defaultdict(int)
        for char in t:
            map_t[char] += 1

        map_s = defaultdict(int)
        start, end = 0, 0
        result = s
        searching = True
        while end < len(s):
            if s[end] in map_t:
                map_s[s[end]] += 1
                searching = False
            elif s[end] not in map_t and searching:
                start = end+1

            if map_s == map_t:
                if len(s[start:end+1]) < len(result):
                    result = s[start:end+1]
                    start = end+1
                    searching = True
            
            end += 1
        
        return result

s="ADOBECODEBANC"
t="ABC"

print(Solution().minWindow(s, t))
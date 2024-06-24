from typing import List

class Solution:
    def encode(self, strs: List[str]) -> str:
        endcoded_string = ""
        for s in strs:
            endcoded_string += str(len(s)) + "#" + s
        return endcoded_string
    def decode(self, s: str) -> List[str]:
        strs = []
        i = 0
        str_len, decoded_str = "", ""
        while i<len(s):
            if s[i] == "#":
                length = int(str_len)
                for j in range(length):
                    decoded_str += s[i+j+1]
                strs.append(decoded_str)
                decoded_str, str_len = "",  ""
                i+=length+1
            else:
                str_len+= s[i]
                i+=1
        return strs
    
mysolution = Solution()
strs = ["we","say",":","yes","!@#$%^&*()"]
print(mysolution.decode(mysolution.encode(strs)))

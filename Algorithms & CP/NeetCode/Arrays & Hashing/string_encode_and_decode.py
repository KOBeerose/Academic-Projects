from typing import List

class Solution:
    def encode(self, strs: List[str]) -> str:
        endcoded_string = ""
        for s in strs:
            endcoded_string += s + "💩"
        return endcoded_string
    def decode(self, s: str) -> List[str]:
        strs = []
        decoded_str = ""
        for i in range(len(s)):
            if s[i] == "💩":
                strs.append(decoded_str)
                decoded_str = ""
            else:
                decoded_str += s[i]
        return strs
    
mysolution = Solution()
strs = ["we","say",":","yes","!@#$%^&*()"]
print(mysolution.decode(mysolution.encode(strs)))

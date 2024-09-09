class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        bracket_map = {")": "(", "}": "{", "]": "["}
        for char in s:
            if char in bracket_map:
                if stack and bracket_map[char] == stack.pop():
                    continue
                else:
                    return False
            else:
                stack.append(char)
        return not stack
    
s = "([{}])"

mysolution = Solution()
mysolution.isValid(s)
class Solution:
    def isPalindrome(self, s: str) -> bool:
        i, j = 0, len(s)-1
        while j > i:
            print("---------new iteration---------")
            print(i, j)
            print(s[i], s[j])
            if not s[i].isalnum():
                i+=1
                print("not s[i].isalnum() => i+1")
            elif not s[j].isalnum():
                j-=1
                print("not s[j].isalnum() => j-1")
            elif s[i].lower() != s[j].lower():
                return False
            else:
                i, j = i+1, j-1
        return True
                
mysolution = Solution()
s = "ra ce 3 e car"
print(mysolution.isPalindrome(s))
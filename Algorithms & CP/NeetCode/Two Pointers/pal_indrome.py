class Solution:
    def isPalindrome(self, s: str) -> bool:
        left_pt, right_pt = 0, len(s)-1
        while right_pt - left_pt > 0:
            if s[left_pt].isalnum()==False:
                left_pt+=1
            elif s[right_pt].isalnum()==False:
                right_pt-=1
            elif s[left_pt].lower()!=s[right_pt].lower():
                return False
            else:
                left_pt+=1
                right_pt-=1
        return True
                
mysolution = Solution()
s = "ra ce 3 e car"
print(mysolution.isPalindrome(s))
from typing import List

class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left_pt, right_pt = 0, len(numbers)-1
        while right_pt>left_pt:
            num_sum = numbers[right_pt]+numbers[left_pt]
            if num_sum>target:
                right_pt-=1
            elif num_sum<target:
                left_pt+=1
            else:
                return[left_pt+1, right_pt+1]
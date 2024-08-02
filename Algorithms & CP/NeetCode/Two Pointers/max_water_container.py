from typing import List

class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left_pt, right_pt = 0, len(heights) - 1
        max_surface = 0
        while right_pt>left_pt:
            surface = min(heights[left_pt], heights[right_pt]) * (right_pt-left_pt)
            max_surface = max(max_surface, surface)
            if heights[left_pt]>heights[right_pt]:
                right_pt -= 1
            else:
                left_pt += 1

        return max_surface
            

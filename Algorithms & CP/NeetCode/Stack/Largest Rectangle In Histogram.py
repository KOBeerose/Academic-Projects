from typing import List

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        '''
        [7, 1, 7, 2, 2, 4]
         |  
        '''
        max_area = 0
        for i in range(len(heights)):
            min_h = heights[i]
            for j in range(i, len(heights)):
                min_h = min(min_h, heights[j])
                area = min_h * (j-i+1)
                max_area = max(max_area, area)

        return max_area
        
        

from typing import List

class Solution:
    def trap(self, heights: List[int]) -> int:
        maxLeft, maxRight = 0, 0
        l_array, r_array = [0]*(r+1), [0]*(r+1)
        rain = 0
        for i in range(len(heights)):
            j = len(heights)-i-1
            l_array[i] = maxLeft
            maxLeft = max(heights[i], maxLeft)

            r_array[j] = maxRight
            maxRight = max(heights[j], maxRight)

        for k in range(len(heights)):
            rain += max(min(l_array[k], r_array[k]) - heights[k], 0)
        return rain    

height=[0,2,0,3,1,0,1,3,2,1]

mysolution = Solution()
mysolution.trap(height)
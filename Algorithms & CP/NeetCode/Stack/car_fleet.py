from typing import List
class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        '''
         [(10, 2), (8, 4), (5, 1), (3, 3), (0, 1)]
            1        1        7        3      12
                                     1, 3, 12 
        '''
        ordered_pairs = sorted(zip(position, speed), reverse=True)
        # calculate arrival time
        stack = [-1]
        for pos, speed in ordered_pairs:
            arrival_time = (target - pos) / speed
            if stack[-1] < arrival_time:
                stack.append(arrival_time)
        return len(stack)-1
                
target=12
position=[4,1,0,7]
speed=[2,2,1,1]
    
mysolution = Solution()
mysolution.carFleet(target, position, speed)
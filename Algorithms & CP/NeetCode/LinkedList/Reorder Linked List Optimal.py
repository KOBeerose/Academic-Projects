from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __repr__(self):
        return f"{self.val} -> {self.next}"
    

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # get to the middle of the list and reverse the second half and merge the two parts
        slow_pt, fast_pt = head, head
        while fast_pt and fast_pt.next:
            slow_pt = slow_pt.next
            fast_pt = fast_pt.next.next

            
        # reverse the prev list take first half of head
        second = slow_pt.next
        dummy = slow_pt.next = None
        while second:
            dummy = ListNode(second.val, dummy)
            second = second.next


        # Merge two lists
        first, second= head, dummy
        while second:
            # keep the reset of element in tmp
            tmp1, tmp2 = first.next, second.next

            # add element from first and second
            first.next = second
            second.next = tmp1

            # update first and second lists
            first, second = tmp1, tmp2

    
head = ListNode(2, ListNode(4, ListNode(6, ListNode(8, ListNode(10, None)))))
print(Solution().reorderList(head))
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
        i = 0
        second = dummy
        dummy = head
        first = head.next
        while first or second:
            if i % 2 == 0 and second:
                dummy.next = ListNode(second.val)
                second = second.next
            else :
                dummy.next = ListNode(first.val)
                first = first.next
            dummy = dummy.next
            i += 1

    
head = ListNode(2, ListNode(4, ListNode(6, ListNode(8, ListNode(10, None)))))
print(Solution().reorderList(head))
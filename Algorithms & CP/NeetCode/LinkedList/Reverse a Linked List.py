# Definition for singly-linked list.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __repr__(self):
        return f"{self.val} -> {self.next}"
    
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev, curr = None, head
        #      C
        #   nul <- 1  (2 -> 3 -> nul)
        #          p    temp
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
    
head = ListNode(1, ListNode(2, ListNode(3, None)))
print(Solution().reverseList(head))

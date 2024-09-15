from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __repr__(self):
        return f"{self.val} -> {self.next}"

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        result_list = ListNode()
        dummy = result_list
        while list1 and list2:
            if list1.val <= list2.val:
                dummy.next = ListNode(list1.val)
                list1 = list1.next
            else :
                dummy.next = ListNode(list2.val)
                list2 = list2.next
            dummy = dummy.next
            
        dummy.next = list2 if list1 is None else list1

        return result_list.next
    
list1 = ListNode(1, ListNode(2, ListNode(4, None)))
list2 = ListNode(1, ListNode(3, ListNode(5, None)))

print(Solution().mergeTwoLists(list1, list2))
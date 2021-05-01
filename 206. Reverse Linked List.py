'''

Given the head of a singly linked list, reverse the list, and return the reversed list.


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Iterative solution: O(1) Space | O(N) Time

Recrusive Soltuion: O(N) Space | O(N) Time
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


#iterative 
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        startIdx = None #P1
        midIdx = head   #P2 
        
        while midIdx:
            endIdx = midIdx.next
            midIdx.next = startIdx
            startIdx = midIdx 
            midIdx = endIdx 
        return startIdx
 

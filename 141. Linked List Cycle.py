"""
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed)

- Assumption - Linked list can be modified 

Method 1: Using a hashset. Traverse through linked list and add nodes to a hashet. Check if the nodes are in hashet before adding them. If theyre in the hashshet,
then we want to return True. If we all added all ndoes to the hashset with no repeating values, return False.

Time: O(n) | Space O(n) 


Method 2: Modify Linked Lists with a "visited" value - Edit class to include visited attruibte. When we visit a node, we mark it with visited attribute.
if we visit all nodes and mark them once, return False. Else return true.

Time: O(n) | Space O(1)

Method 3: Using Two Pointers - Traverse the Linked List using two pointers. Move one pointer slowly by one and move the other pointer faster by two.
if the these two pointers meet at the same node, then there is a loop. If there isnt, then the linked list doesnt have a loop.

Time: O(n) | Space O(1) 

"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        slow_p = head
        fast_p = head
        while(slow_p and fast_p and fast_p.next):
            slow_p = slow_p.next
            fast_p = fast_p.next.next
            if slow_p == fast_p:
                return True
        return False

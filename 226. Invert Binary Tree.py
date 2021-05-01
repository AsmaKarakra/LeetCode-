'''
Given the root of a binary tree, invert the tree, and return its root.


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]


Iterative Method:
Use a BFS using a queue and node manipluation

Space O(n) | Time O(n)

Recurisve Method:
Use Inorder BFS and switch nodes

Space O(d) - Call stack takes the deepest height of tree
Time O(N)

'''

#Recurisve 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return
        
        root.left, root.right = root.right, root.left
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root
      
     
# Iterative

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        queue = []
        queue.append(root)
        
        while queue: 
            node = queue.pop(0)
            if node:
                node.left, node.right = node.right, node.left
                queue.append(node.left)
                queue.append(node.right)
        return root

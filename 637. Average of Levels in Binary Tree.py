'''

Given the root of a binary tree, 
return the average value of the nodes on each level in the form of an array. 
Answers within 10-5 of the actual answer will be accepted.

Input: Binary tree

Input: root = [3,9,20,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Approach (BFS)

O(N) Time, O(N) Space

Do BFS on tree because we need to add nodes on the tree by level and divide to get the average of each level. 

Create a variable to keep track of summation of nodes on each level
Divide the summuation of nodes by length of queue to get the average 
Append average to results array 

'''

class Solution:
    def averageOfLevels(self, root):
        q = [root]                             #create queue and append root to it
        result = []                            #create results array to return 
        while(q):                              #while our queue is not empty, do the following 
            summation = 0                      #summuation of our nodes 
            numberOfNode = len(q)              #Length of our queue to divide summation of nodes by to get average
            for i in range(numberOfNode):      #for all the index values in the queue 
                node = q.pop(0)                #pop the first item off the queue
                if node.left:                  #if the left child of selected node exsits, append it to the array
                    q.append(node.left)
                if node.right:                 #if the right child of selected node exsits, append it to the array
                    q.append(node.right)
                summation += node.val          #sum all the values of the nodes by level 
            result.append(summation / numberOfNode)   
        
        return result

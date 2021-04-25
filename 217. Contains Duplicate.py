"""

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true


Assumptions: 
-	Array is not sorted 
-	Can have positive and negative integers 
-	Can modify arrays 
-	Value can repeat more than twice 

Method 1: 
Sort the array and use two pointers to check if two values next to each other match. 
Time: N Log(N) | Space: O(1)

Method 2: Two nested for loops with pointers to traverse through the array and check every value 
Time: O(N^2) | Space: O(1)

Method 3: Hash Table to store values and check if they are repeated. 
Time: O(n) }| Space O(n) 

"""

#solution: 

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        Hashset = {} 
        for i in nums:
            if i in Hashset:
                return True
            else:
                Hashset[i] = False
        return False

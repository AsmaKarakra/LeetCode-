"""

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true

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

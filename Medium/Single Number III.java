/*
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]

Note:

    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. 
    Could you implement it using only constant space complexity?

*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int n = 0, m = 0, mask = 0;
        
        for(int num : nums) {
            mask ^= num;
        }
        
        mask ^= (mask & (mask - 1));
        
        for(int num : nums) {
            if((num & mask) != 0) {
                n ^= num;
            }
            else {
                m ^= num;
            }
        }
        
        int[] res = new int[2];
        
        res[0] = n;
        res[1] = m;
        
        return res;
    }
}
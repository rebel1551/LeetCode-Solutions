/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10

Note: Your solution should run in O(log n) time and O(1) space.
*/

class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {  //O(n)
        int singleNumber = 0;
        for(int num : nums){
            singleNumber ^= num;
        }
        
        return singleNumber;
    }
    int singleNonDuplicate(vector<int>& nums) { // O(log(n))
        int low  = 0, high  = nums.size() - 1;
        while(low < high){
            int mid = low  + (high - low)/2;
            
            if(mid%2){
                if(nums[mid] == nums[mid - 1]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            else{
                if(nums[mid] == nums[mid + 1]){
                    low = mid + 2;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return nums[low];
    }
};
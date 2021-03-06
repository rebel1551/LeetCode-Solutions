/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
 

Constraints:

1 <= num <= 2^31 - 1
*/


class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 2;
        long high = num/2;
        
        if(num == 1) {
            return true;
        }
        
        while(low <= high) {
            long mid = low + (high - low)/2;
            long sqr = mid * mid;
            // long to avoid overflow
            if(num == sqr) {
                return true;
            }
            else if(num > sqr){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        
        if(num < 2) {
            return true;
        }
        
        long iv = num / 2; // long to avoid overflow
        
        while(iv * iv > num) {
            iv = (iv + num/iv)/2;
        }
        
        return iv * iv == num;
    }
}


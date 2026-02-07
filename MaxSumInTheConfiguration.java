

// You are given an integer array nums of length n.

// Assume arrk to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function F on nums as follow:

// F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
// Return the maximum value of F(0), F(1), ..., F(n-1).

// The test cases are generated so that the answer fits in a 32-bit integer.

 

// Example 1:

// Input: nums = [4,3,2,6]
// Output: 26
// Explanation:
// F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
// F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
// F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
// F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
// So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

import java.util.*;
public class MaxSumInTheConfiguration{
    static int maxSum(int[] arr) {
        // code here
    //   the idea is to find the maximum of all configurations by 
    // finding the initial sum, that ll also be the configuration sum
    //  then for the next configuration (imagine rotating clockwise)
    // the last most element will reduce to power 0, 
    // all other elements will raise power by 1
    
    // calculating total sum and inital config sum 
    int sum=0,initialConfigSum=0;
    for (int i=0;i<arr.length;i++)
    {
        sum+=arr[i];
        initialConfigSum+=i*arr[i];
    }
    
    // finding each config sum by manipulating inital sum and config sum`
    // imagining rotating anticlockwise - where the last element goes to the first 
    // in the next configuration
    
    int res = initialConfigSum;
    int newConfig=initialConfigSum;
    for ( int i=arr.length-1;i>0;i--)
    {
        // every element moving right, hence newConfig sum increases by sum except arr[i]
        // arr[i] loses value to power length -1, plus minus 1 for reduction in sum
         newConfig=newConfig+(sum-arr[i]*(arr.length));
        res=Math.max(newConfig,res);
    }
    return res;
    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the array seperated by space: ");
        String [] inp =sc.nextLine().split(" ");
        int [] nums =new int[inp.length];
        for ( int i=0;i<nums.length;i++)
        {
            nums[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("The maximum configuration obtained by rotating array in clockwise direction is:"+maxSum(nums));
    }
} 


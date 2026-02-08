
import java.util.*;
class MaximumProductSubarray {
    static int maxProduct(int[] arr) {
        // code here
        int maxProduct=1;
        //  we'll try applying greedy algo 
        // intuition:
        // cases can be that arr contains :
        // no negative
        // even negative ( maximization and even for maximization)
        // odd negative (maximization on either left or right side of negative val)
        int prefixSum =1, suffixSum=1;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++)
        {
            // restart when encountered a 0 (pref?suffix sum becomes 0
            if (prefixSum==0) prefixSum=1;
            if (suffixSum==0)suffixSum=1;
            // calculating prefix and suffix from start and end for all subarr individually
            prefixSum*=arr[i];
            suffixSum*=arr[arr.length-i-1];
            // storing the maximum possible sum for all subarray sum from either sides
            max=Math.max(max, Math.max(prefixSum, suffixSum));
            
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the array seperated by spaces:");
        String [] inp = sc.nextLine().split(" ");
        int [] arr = new int[inp.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=Integer.parseInt(inp[i]);

        }
        System.out.println("The maximum subarray product is: "+maxProduct(arr));
    }
}
import java.util.*;
class MaximumNumberOfOnes {
    public static int maxOnes(int arr[], int k) {
        // code here
        // the idea is to use a sliding window approach 
        // the window would accept at most k zeroes
        int max=0;
        int left =0;
        int zeroCount=0;
        for (int right =0; right<arr.length;right++)
        {
            // if zero encountered, increment the zero count
            if (arr[right]==0)zeroCount++;
            // if the zeroes exceed the limit, shift the left pointer until they r under the limit
            while (zeroCount>k)
            {
                // if the element on the left most end is 0 , reduce the count
                if (arr[left]==0)
                {
                    
                    zeroCount--;
                } left++;  
            }
            // calculate the max sequence length
            max=Math.max(right-left+1, max);
            
            
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the array seperated by spaces: ");
        String [] inp = sc.nextLine().split(" ");
        int [] arr = new int[inp.length];
        for ( int i=0;i<arr.length;i++)
        {
            arr[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("Enter the value of k: ");
        int k =sc.nextInt();
        System.out.println("The maximum number of  1s by flipping at most "+k+" 0s is"+maxOnes(arr, k));
    }
}
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
class LongestSubarrayWithAtmost2DistinctIntegers{
public static int totalElements(int[] arr) {
        // code here
        // the idea is to follow a sliding window approach 
        // move left if the length exceeds two 
        //  else calculate the length
        int left=0,max=0;
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int right =0;right<arr.length;right++)
        {
            map.put(arr[right], map.getOrDefault(arr[right],0)+1);
            while(map.size()>2)
            {
                // if the frequency of the array at the leftmost pos in window is 1, remove it
                int count =map.get(arr[left])-1;
                if (count==0)
                {
                    map.remove(arr[left]);
                }else{
                    map.put(arr[left], count);
                }
                left++;
            }
            // since the max distinct elements are two, find the length of subarr again
            max=Math.max(max, right-left+1);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the subarray seperated by spaces: ");
        String [] inp =sc.nextLine().split(" ");
        int [] arr = new int[inp.length];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("The length of the longest subarray with at most 2 distinct integers is: "+totalElements(arr));
    }
}
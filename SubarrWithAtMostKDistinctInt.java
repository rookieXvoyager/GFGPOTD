import java.util.*;
import java.util.HashMap;

public class SubarrWithAtMostKDistinctInt {
    public int countAtMostK(int arr[], int k) {
        // code here
        //  using a two pointer approach to solve this in linear time 
        int l =0,r=0, count=0;
        int n =arr.length;
        HashMap<Integer, Integer> freq =new HashMap<>();
        while(r<n)
        {
            // store the frequency of each element
            freq.put(arr[r],freq.getOrDefault(arr[r],0)+1);
            // peform until there are more than k elements
            while(freq.size()>k)
            {
                // remove the first element in the current window
                freq.put(arr[l],freq.get(arr[l])-1);
                // remove the element if its frequency is 0
                if(freq.get(arr[l])==0)
                {
                    freq.remove(arr[l]);
                }
                // keep moving the pointer ahead until the count of distinct elements 
                // is more than k
                    l++;
            }
            // the no. of subarrays satisfying ll be equal to the length of the subarr
                count+=r-l+1;
                // increase right for the next iteration
                r++;
                
                
            
            
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array seperated by spaces:");
        String [] inp=sc.nextLine().split(" ");
        int [] arr = new int[inp.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=Integer.parseInt(inp[i]);
        }    
        System.out.println("Enter the maximum of distinct integers at most accepted:");
        int k =sc.nextInt();
        SubarrWithAtMostKDistinctInt obj = new SubarrWithAtMostKDistinctInt();
        System.out.println("The maximum no. of subarrays with "+k+ "distinct elements at most is :"+obj.countAtMostK(arr, k));
    }

}

import java.util.Scanner;

public class MaxXORSubarrayOfSizeK {
     public static int maxSubarrayXOR(int[] arr, int k) {
        // code here
        // the idea is to solve this using sliding window 
        
        // pointers to keep the track of sum
        int window_sum=0;
        // the first window
        for (int i=0;i<k;i++)
        {
            window_sum^=arr[i];
        }
        int sum=window_sum;
        
        for(int i=k;i<arr.length;i++)
        {
            window_sum=window_sum^arr[i-k]^arr[i];
            
            sum=Math.max(window_sum,sum);
        }
        return sum;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array (elements seperated by space): ");
        String[] inp_arr = sc.nextLine().split(" ");
        int[] arr = new int[inp_arr.length];
        for (int i = 0; i < inp_arr.length; i++) {
            arr[i] = Integer.parseInt(inp_arr[i]);
        }
        System.out.println("Enter the size of the sub array:");
        int k = sc.nextInt();
        System.out.println("The maximum XOR sum of subarray with length " + k + " is: " + maxSubarrayXOR(arr, k));
    }
}

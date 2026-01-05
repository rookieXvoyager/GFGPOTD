import java.util.*;

public class MaxSubarraySum {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int window_sum = 0;
        for (int i = 0; i < k; i++) {
            window_sum += arr[i];
        }
        int maxSum = window_sum;
        for (int i = k; i < arr.length; i++) {
            window_sum += arr[i];
            window_sum -= arr[i - k];
            maxSum = Math.max(window_sum, maxSum);

        }
        return maxSum;

    }

    public static void main(String[] args) {
        MaxSubarraySum obj = new MaxSubarraySum();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array (elements seperated by space): ");
        String[] inp_arr = sc.nextLine().split(" ");
        int[] arr = new int[inp_arr.length];
        for (int i = 0; i < inp_arr.length; i++) {
            arr[i] = Integer.parseInt(inp_arr[i]);
        }
        System.out.println("Enter the size of the sub array:");
        int k = sc.nextInt();
        System.out.println("The maximum sum of subarray with length " + k + " is: " + obj.maxSubarraySum(arr, k));
    }
}

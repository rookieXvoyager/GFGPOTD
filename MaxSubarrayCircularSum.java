import java.util.*;

class MaxSubarrayCircularSum {
    public static int maxCircularSum(int arr[]) {
        // code here
        // the idea here is to implement Kadane's Algo but in a different way
        // First is to implement the regular Kadane's algo for a non circular case
        // for the circular case, the idea is to find the minimum subarray and then
        // subtract it from the total sum of arr
        // minimum can be found by applying kadane's algo to the negative of the array

        int nonCircularMax = Kadane(arr);
        if (nonCircularMax < 0)
            return nonCircularMax;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            arr[i] *= -1;

        }

        // return total+Kadane(arr);
        return Math.max(nonCircularMax, total + Kadane(arr));

    }

    static int Kadane(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // if the previous sum is negative, use curr sum as 0

            if (sum < 0)
                sum = 0;

            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array seperated by spaces: ");
        String[] inp = sc.nextLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        System.out.println("The maximum circular subarray sum for the given subarray is:" + maxCircularSum(arr));
    }
}

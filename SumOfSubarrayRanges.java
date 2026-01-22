import java.util.*;

public class SumOfSubarrayRanges {
    // The idea is to determine the sum of the maximums and minimum of all subarrays
    // instead of determining the individual max and min vals

    public static int subarrayRanges(int[] arr) {
        // code here
        int maxSum = maxSum(arr);
        int minSum = minSum(arr);
        return maxSum - minSum;

    }

    static int maxSum(int[] arr) {
        // the idea is to determine in which range is the curr element arr[i] maximum in
        // its contribution in arr[i] 'd be arr[i] times the no. of subarr it is max
        int[] pge = pge(arr);
        int[] nge = nge(arr);

        int maxsum = 0;
        for (int i = 0; i < arr.length; i++) {
            // start will be no. of possible start indices where the subarr wih max as
            // arr[i] can start
            // end determines the no. of indices that which end index could be
            int start = i - pge[i], end = nge[i] - i;
            // start * end determines the no. of total subarrs with arr[i] as max
            maxsum += arr[i] * (start * end);
        }
        return maxsum;
    }

    static int minSum(int[] arr) {
        int[] pse = pse(arr);
        int[] nse = nse(arr);
        int minsum = 0;
        for (int i = 0; i < arr.length; i++) {
            int start = i - pse[i], end = nse[i] - i;
            minsum += arr[i] * start * end;

        }
        return minsum;
    }

    static int[] pse(int[] arr) {
        int[] pse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }
            stack.push(i);

        }
        return pse;
    }

    static int[] nse(int[] arr) {
        int[] nse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            if (stack.isEmpty()) {
                nse[i] = arr.length;
            } else {
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        return nse;
    }

    static int[] pge(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] pge = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = stack.peek();
            }
            stack.push(i);
        }
        return pge;
    }

    static int[] nge(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = arr.length;
            } else {
                nge[i] = stack.peek();
            }
            stack.push(i);
        }
        return nge;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Provide the array seperated by spaces:");
        String[] inp = sc.nextLine().split(" ");
        int[] arr = new int[inp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        System.out.println("Then sum of ranges of all subarrays is: " + subarrayRanges(arr));

    }
}

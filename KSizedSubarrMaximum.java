import java.util.*;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

class KSizedSubarrMaximum{
     public static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        // The idea is to implement a monotonic stack using a Deque
        // Deque or doubly - ended queue enables insertion and deletion from either ends 
        // We maintain a monotonic stack (decreaasing towards insertion) to find the largest element
        // Simultaneously implementing a Queue for window to determine
        ArrayList<Integer> res = new ArrayList<>();
        // Deque to maintain the indices of elements
        Deque <Integer> dq = new ArrayDeque<>();
        for (int i =0;i<arr.length;i++)
        {
            // check if the last window isnt lost and remove it 
            if (!dq.isEmpty() && (dq.peekFirst()<=i-k))
            {
                dq.pollFirst();
            }
            // until the elements from the rear are smaller than current,
            // Keep popping the indices
        while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i])
        {
            dq.pollLast();
        }
        // Now add the current index to complete the index
        dq.addLast(i);
        // Check if the first window has been formed
        if (i>=k-1)
    // Adding the largest element to the queue 
    res.add(arr[dq.peekFirst()]);
            
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the array seperated by spaces: ");
        String [] inp = sc.nextLine().split(" ");
        int [] arr = new int [inp.length];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("Enter the value of k:");
        int k =sc.nextInt();

        System.out.println("The maximum el in each subarray of size "+k+ " are "+maxOfSubarrays(arr, k));
    }
}
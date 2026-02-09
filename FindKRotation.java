import java.util.*;
public class FindKRotation {
    public static  int findKRotation(int arr[]) {
        // Code here
        //  the idea here is to find the breaking point 
        // if the array is sorted , then return 0;
        
        int idx =1;
        // comparing elements to find the breaking point
        while(idx<arr.length && arr[idx]>arr[idx-1])
        {
            
           idx++;
        }
        return idx%arr.length;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        System.out.println("Enter the array seperated by spaces: ");
        String [] inp=sc.nextLine().split(" ");
        int [] arr = new int[inp.length];
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("The array is rotated by "+findKRotation(arr)+" spaces");

    }

} 

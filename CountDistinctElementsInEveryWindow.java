import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountDistinctElementsInEveryWindow {
     static ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        if(k>arr.length)return new ArrayList <>();
        HashMap <Integer,Integer> curr=new HashMap<>();
        ArrayList <Integer> res = new ArrayList<>();
        for (int i=0;i<k;i++)
        {
            curr.put(arr[i], curr.getOrDefault(arr[i],0)+1);
            
        }
        res.add(curr.size());
        for(int i=k;i<arr.length;i++)
        {
            int out =arr[i-k];
            curr.put(out,curr.get(out)-1);
            if (curr.get(out)==0)curr.remove(out);
            int in =arr[i];
            curr.put(in, curr.getOrDefault(in,0)+1);
            res.add(curr.size());
            
        }
        
        
        return res;
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
        System.out.println("The frequencies of unique of elements woth window size " + k + " is: " + countDistinct(arr, k));
    }
    
}

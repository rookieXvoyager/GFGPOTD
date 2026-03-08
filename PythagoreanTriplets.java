import java.util.*;
import java.util.HashSet;
class PythagoreanTriplets{
    static boolean pythagoreanTriplet(int[] arr) {


        // code here
    // use two nested for loops to solve this 
    
    HashSet <Integer> set = new HashSet<>();
    for (int el:arr){
        set.add(el*el);
    }
    
    
    
    for (int i=0;i<arr.length;i++)
    {
        for (int j =i+1;j<arr.length;j++){
            if (set.contains((arr[i]*arr[i]+arr[j]*arr[j])))
            {
                return true;
            }
        }
    }
    return false;
    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the array seperated by spaces:");
        String [] inp =sc.nextLine().split(" ");
        int [] arr = new int [inp.length];
        for (int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(inp[i]);
        }

        System.out.println(pythagoreanTriplet(arr)?"Pythhon triplet exists":"No such triplet exists");
    }

}
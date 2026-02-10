import java.util.*;
class KokoEatingBananas {
    public static int kokoEat(int[] arr, int k) {
        // code here
        // the idea is to implement a binary search on the range of bananas
        // that koko can eat per hour 
        // in the range 1 to max(arr)
        int max =1;
        for (int i=0;i<arr.length;i++)
        max=Math.max(arr[i],max);
        int min=1;
        int low =min, high =max;
        int perHour=0;
        int minPerHour=max;
        while (low<=high)
        {
             perHour=low +(high-low)/2;
            if(acceptedRate(arr,perHour,k))
            {
                minPerHour=Math.min(minPerHour,perHour);
                high=perHour-1;
            }else{
                low=perHour+1;
            }
            
        }
        return  minPerHour;
    }
    static boolean acceptedRate(int [] arr, int perHour, int k)
    {
        int time =0;
        for (int i=0;i<arr.length;i++)
        {
            time +=((arr[i]+perHour-1)/perHour);
        }
        
        return time<=k;
        
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the no. of bananas per pile (seperated by spaces)");
        String [] inp = sc.nextLine().split(" ");
        int [] bananas = new int[inp.length];
        for ( int i=0;i<bananas.length;i++){
            bananas[i]=Integer.parseInt(inp[i]);
        }
        System.out.println("Enter the maximum no. of hours accepted: ");
        int k =sc.nextInt();
        System.out.print("The minimum no. of hours to be eaten by Koko per hour is"+kokoEat(bananas, k));
    }
}

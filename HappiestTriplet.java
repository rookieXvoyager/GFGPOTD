import java.util.*;
class HappiestTriplet {
    static int[] smallestDiff(int a[], int b[], int c[]) {
        // write code here
        // the idea here is to maintain the triplet by finding the least difference
        // steps:
        // sort the arrays
        // move the pointers until one reached end of arr
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        // res to store triplet
        int [] res = new int[3];
        // initializing the pointers
         int i1=0,i2=0,i3=0;
         int n=a.length;
        //  maxSum to determine the the difference
        // maxDiff to determine the max difference in the triplet
         int maxSum=Integer.MAX_VALUE, maxDiff =Integer.MAX_VALUE;
         while (i1<n && (i2<n && i3<n))
        //    find maximum and minimum in triplet
{
             int max =Math.max(a[i1],Math.max(b[i2],c[i3]));
             int min =Math.min(a[i1],Math.min(b[i2],c[i3]));
            //  determine the difference
             int diff =max-min;
             int sum =a[i1]+b[i2]+c[i3];
             
            // update triplet if 
            // the new Difference in minimal than prev
            // the sum is smaller for same difference
             if (diff<maxDiff || (diff==maxDiff && sum<maxSum))
             {
                 maxDiff=diff;
                 maxSum=sum;
                 res[0]=a[i1];
                 res[1]=b[i2];
                 res[2]=c[i3];
             }
            //  move the pointer which points at the least value
             if (min==a[i1]){i1++;}
             else if (min==b[i2])i2++;
             else i3++;
             
         }
        //  returning the result in decreasing order
         int [] final_res= new int[3];
         Arrays.sort(res);
         for (int i=0;i<3;i++)
         final_res[i]=res[2-i];
         return final_res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter array a seperated by spaces: ");
        String [] inp1= sc.nextLine().split(" ");
        int [] a = new int[inp1.length];
        for (int i=0; i<inp1.length;i++)
        {
            a[i]=Integer.parseInt(inp1[i]);
        }

         System.out.println("Enter array b seperated by spaces: ");
        String [] inp2= sc.nextLine().split(" ");
        int [] b = new int[inp2.length];
        for (int i=0; i<inp2.length;i++)
        {
            b[i]=Integer.parseInt(inp2[i]);
        }

         System.out.println("Enter array c seperated by spaces: ");
        String [] inp3= sc.nextLine().split(" ");
        int [] c = new int[inp3.length];
        for (int i=0; i<inp3.length;i++)
        {
            c[i]=Integer.parseInt(inp3[i]);
        }
        System.out.println("The happiest triplet ( minimal difference and sum) is :");
        for (int el :smallestDiff(a, b, c))
        System.out.print(el+" ");
        System.out.println();
        sc.close();

    }
}

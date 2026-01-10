import java.util.*;
public class SubstringsWithKDistinct {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the string to determine the distinct subsequences: ");
        String inp=sc.nextLine();
        System.out.println("Enter the no. of distinct integers allowed:");
        int k = sc.nextInt();
     
        SubstringsWithKDistinct obj = new SubstringsWithKDistinct();
        System.out.println("The number of substrings with exactly " + k+"subtrings are "+obj.countSubstr(inp, k));
    }
    public int countSubstr(String s, int k) {
        //  code here
        return countSubstrUpto(s,k)-countSubstrUpto(s,k-1);
    }
    
    static int countSubstrUpto(String s, int k)
    {
        if(k<1)return 0;
        int left =0, right =0, count=0;
        HashMap <Character , Integer> freq = new HashMap<>();
        char [] str =s.toCharArray();
        int size =s.length();
        while(right<size)
        {
            freq.put(str[right], freq.getOrDefault(str[right],0)+1);
            while(freq.size()>k)
            {
                freq.put(str[left], freq.getOrDefault(str[left],0)-1);
                if(freq.get(str[left])==0)
                {
                    freq.remove(str[left]);
                }
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}

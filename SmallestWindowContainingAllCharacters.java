import java.nio.channels.Pipe.SourceChannel;
import java.util.*;
import java.util.HashMap;
class SmallestWindowContainingAllCharacters{
    public static String minWindow(String s, String p) {
        // code here
        //  the idea is to maintain a HashMap to keep a record of freq
        // Note that :
        // +ve freq represents contribution from p 
        // -ve freq represents contribution from s
        
        // inserting +ve freq from p
        HashMap <Character, Integer> freq = new HashMap<>();
        for (char ch:p.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        
        // using a sliding window approach to maintain a valid String 
        
        int left =0,right=0, start=0;
        int minLength=Integer.MAX_VALUE;
        int count =0;
        while(right<s.length()){
            // if a new elements is encountered, increase the count 
            if (freq.getOrDefault(s.charAt(right),0)>0)count++;
            // updating the contribution freq from p (reducing val)
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right),0)-1);
            
            // if a valid solution exists, try minimizing the length
            while (count==p.length()){
                if (right-left+1<minLength)
                {
                    minLength=right-left+1;
                    start =left;
                }
                // removing l should increase the frequency as it is decontirbuted by p
                
                freq.put(s.charAt(left), freq.getOrDefault(s.charAt(left),0)+1);
                // if the character is decontributed from s and contributed from p
                if (freq.getOrDefault(s.charAt(left),0)>0)count-=1;
                left++;
                
            }
            right=right+1;
            
        }
        if (minLength==Integer.MAX_VALUE)return "";
        return s.substring(start,start+minLength);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the string s:");
        String s =sc.nextLine();
        System.out.println("Enter the string t: ");
        String p =sc.nextLine();
        System.out.println("The smallest window of s containing all characters of t is: "+minWindow(s, p));
    }
}
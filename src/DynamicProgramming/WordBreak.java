package DynamicProgramming;

import java.util.HashSet;

/**
 * Created by Anand on 4/21/2016.
 */
public class WordBreak {



    public static boolean wordBreakRecursive(String str, HashSet set){
        if(str.length() ==0)
            return true;
        for(int i =1; i<=str.length();i++){
            if(set.contains(str.substring(0,i)) && set.contains(str.substring(i)))
                return true;
        }
        return false;
    }

    public static void main (String [] args){
        HashSet set = new HashSet();
        set.add("I");
        set.add("leet");
        set.add("code");
        System.out.println(wordBreakRecursive("leetcode",set));
    }
}

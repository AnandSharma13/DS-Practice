package Strings;

import java.util.*;

/**
 * Created by Anand on 2/5/2016.
 */
public class LeetCodeStrings {


    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);

            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(strs[i], list);
            } else {
                List<String> list = map.get(strs[i]);
                list.add(strs[i]);
            }
        }

        List<List<String>> list = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> tempList = map.get(key);
            Collections.sort(tempList);
            list.add(tempList);
        }
        return list;
    }

    public static void permOfString(String str){
        char [] charStr = str.toCharArray();
        perm(charStr, 0, charStr.length);
    }


    public static void perm(char [] str, int i, int n){
        if(i == n){
            System.out.println(String.valueOf(str));
            return;
        } for(int k = i;k<n ;k++){
            char temp = str[k];
            str[k] = str[i];
            str[i] =  temp;
        perm(str, i+1, n);
            temp = str[i];
            str[i] = str[k];
            str[k] = temp;
        }
    }

    public static void main(String[] args) {
    //    System.out.println(groupAnagrams(new String[]{"ate", "eat", "tea"}));
      permOfString("aba");


    }

}

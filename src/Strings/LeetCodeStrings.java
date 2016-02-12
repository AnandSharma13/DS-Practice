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

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"ate", "eat", "tea"}));


    }

}

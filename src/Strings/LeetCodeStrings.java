package Strings;

import java.util.*;

/**
 * Created by Anand on 2/5/2016.
 */
public class LeetCodeStrings {


    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tempArr = strs[i].toCharArray();
            Arrays.sort(tempArr);
            String key = String.valueOf(tempArr);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
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

    public static void permOfString(String str) {
        char[] charStr = str.toCharArray();
        perm(charStr, 0, charStr.length);
    }

    public static void perm(char[] str, int i, int n) {
        if (i == n) {
            System.out.println(String.valueOf(str));
            return;
        }
        for (int k = i; k < n; k++) {
            char temp = str[k];
            str[k] = str[i];
            str[i] = temp;
            perm(str, i + 1, n);
            temp = str[i];
            str[i] = str[k];
            str[k] = temp;
        }
    }

    public static void possiblePalindromes(String str) {
    }

    public static void allCombs(String str) {

        if (str == null)
            return;
        HashSet<String> set = new HashSet();
        allCombsHelper(str.toCharArray(), 0, str.length(), set);
        set.forEach(System.out::println);
    }

    public static void allCombsHelper(char[] str, int i, int n, HashSet<String> set) {

        if (i == n)
            set.add(String.valueOf(str));

        for (int k = i; k < n; k++) {
            str[i] = Character.toLowerCase(str[i]);
            allCombsHelper(str, i + 1, n, set);
            str[i] = Character.toUpperCase(str[i]);
            allCombsHelper(str, i + 1, n, set);
        }
    }

    public static void tokenizeString(String str) {
        StringTokenizer stnz = new StringTokenizer(str, "[\\.\\,\\!]");

        while (stnz.hasMoreTokens()) {
            System.out.println(stnz.nextToken());
        }
    }

    public static boolean checkAnagrams(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        if (str1Len != str2Len)
            return false;
        int[] letters = new int[256];
        for (int i = 0; i < str1Len; i++) {
            char c = str1.charAt(i);
            System.out.println((int) (Character.toLowerCase(c)));
            letters[(int) (Character.toLowerCase(c))]++;
        }
        for (int i = 0; i < str1Len; i++) {
            char c = str2.charAt(i);
            letters[(int) (Character.toLowerCase(c))]--;
        }
        for (int i = 0; i < 256; i++) {
            if (letters[i] != 0)
                return false;
        }
        return true;
    }

    public static boolean checkAnagramsII(String str1, String str2) {
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        String key1 = String.valueOf(charArr1);
        String key2 = String.valueOf(charArr2);
        HashSet<String> set = new HashSet<String>();
        set.add(key1);
        set.add(key2);

        return set.size() > 1 ? false : true;


    }

    public static String sumStrings(String str1, String str2) {
        if (str1 == null || str1.length() == 0)
            return str2;
        if (str2 == null || str2.length() == 0)
            return str1;
        int carry = 0;
        int sum = 0;
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int num1;
            int num2;
            if (i >= 0)
                num1 = Integer.parseInt(String.valueOf(str1.charAt(i)));
            else
                num1 = 0;
            if (j >= 0)
                num2 = Integer.parseInt(String.valueOf(str2.charAt(j)));
            else
                num2 = 0;
            sum = num1 + num2 + carry;
            carry = sum / 10;
            sb.insert(0, sum % 10);
            i--;
            j--;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(sumStrings("823", "628"));

    }

}

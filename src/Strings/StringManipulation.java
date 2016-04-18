package Strings;

import java.util.ArrayList;

/**
 * Created by Anand on 2/15/2016.
 */
public class StringManipulation {


    public static String compressBad(String str) {

        if (str == null || str.length() == 0)
            return str;
        int size = checkCompression(str);
        if (size >= str.length())
            return str;
        StringBuffer sb = new StringBuffer();
        int count = 1;
        char last = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                sb.append(last);
                sb.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        sb.append(last);
        sb.append(count);
        return sb.toString();
    }

    public static int checkCompression(String str) {
        int length = str.length();

        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (last == str.charAt(i)) {
                count++;
            } else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

    public static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        if (str.length() == 1 || str.length() == 0)
            return true;
        int lo = 0;
        int hi = str.length() - 1;
        while (lo < hi) {
            if (str.charAt(lo) != str.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static String reverseStringWords(String str) {
        String[] tokens = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = tokens.length - 1; i > 0; i--)
            sb.append(tokens[i] + " ");

        sb.append(tokens[0]);
        return sb.toString();
    }

    public static boolean canFormPalindrome(String str) {

        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[(int) str.charAt(i)]++;
        }
        int oddCount = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0)
                oddCount++;
        }

        if (oddCount > 1)
            return false;

        return true;

    }

    public static void LongestCommonSubstring(ArrayList<String> list) {
        if (list == null || list.size() == 0)
            return;
        String str1 = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            String str2 = list.get(i);
            for (int j = 0; j < str1.length() && j < str2.length(); j++) {
                if (str1.charAt(j) != str2.charAt(j)) {
                    str1 = str1.substring(0, j);
                }
            }
        }
        System.out.println(str1);
    }

    // A string consists of ‘0’, ‘1’ and '?'. The question mark can be either '0' or '1'. Find all possible combinations for a string.

    public static void replaceQuestionMarks(char[] str, int i) {

        if(i == str.length){
            System.out.println(String.valueOf(str));
        }
        else if(str[i] =='?'){
            str[i] = '0';
            replaceQuestionMarks(str, i+1);
            str[i] = '1';
            replaceQuestionMarks(str, i+1);
            str[i] = '?';
        }
        else
            replaceQuestionMarks(str, i+1);
    }




    public static void main(String[] args) {
        char[] arr = new char[]{'0', '?', '1'};
       // replaceQuestionMarks(arr, 0);

    }
}

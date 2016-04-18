package Strings;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * Created by Anand on 4/10/2016.
 */
public class StringMiscellaneous {


    //find longest palindromic substring
    public static String LongestPalindromicSubString(String str) {
        int[] maxlen = new int[1];
        int[] lo = new int[1];


        if (str.length() < 2)
            return str;

        for (int i = 0; i < str.length() - 1; i++) {
            extendPalindrome(str, i, i, maxlen, lo);    // odd palindrome
            extendPalindrome(str, i, i + 1, maxlen, lo); // even palindrome
        }

        return str.substring(lo[0], lo[0] + maxlen[0]);
    }

    public static void extendPalindrome(String str, int left, int right, int[] maxlen, int[] lo) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        if (maxlen[0] < right - left - 1) {
            lo[0] = left + 1;
            maxlen[0] = right - left - 1;
        }
    }

    public static void stringSubstring(String str) {

        int len = str.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                System.out.println(str.substring(j, len));
            }
        }


    }


    public static void main(String[] args) {
    stringSubstring("fun");
    }


}

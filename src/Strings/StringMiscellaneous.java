package Strings;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;


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

    public  void stringSubstring(String str) {

        int len = str.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                System.out.println(str.substring(j, len));
            }
        }
    }

    public static boolean oneEditDistance(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        int str1Len = str1.length();
        int str2Len = str2.length();
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < str1Len && j < str2Len) {
            if (str1.charAt(i) != str1.charAt(j)) {
                count++;
                if (count > 1)
                    return false;
                else if (str1.length() == str2.length())
                    return str1.substring(i + 1).equals(str2.substring(i + 1));
                else if (str1.length() > str2.length())
                    return str1.substring(i + 1).equals(str2.substring(i));
                else
                    return str1.substring(i).equals(str2.substring(i + 1));
            }
            i++;
            j++;
        }
        return Math.abs(str1Len - str2Len) == 1;
    }

    public static void countChars(String str) {

        char [] array = new char[256];

        for(int i =0;i<str.length();i++){
            array[str.charAt(i)] += array[str.charAt(i)] +1;
        }

    }

    public static void removeDups(String str){

        LinkedHashSet<String> set = new LinkedHashSet<>(Arrays.asList(str.split(" ")));
        System.out.println(set);

    }

    public static void compressString(String str){
        if(str == null|| str.length() ==0)
            return;
        int count =1;
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<str.length();i++){
            if(str.charAt(i) != str.charAt(i-1)){
                sb.append(count + String.valueOf(str.charAt(i-1)));
                count =1;
            }
            else
                count++;

        }
        sb.append(count + String.valueOf(str.charAt(str.length()-1)));
        System.out.println(sb);

    }



    public static void main(String[] args) {
        //       stringSubstring("fun");

//        System.out.println(oneEditDistance("ageeka", "geeka"));
 //       compressString("aaabbc");
  //      countChars("Anand ssd fdfdf");
  //      removeDups("My name is hi My name anand sharma");


    }


}

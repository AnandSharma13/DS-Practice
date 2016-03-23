package Strings;

import java.util.ArrayList;
import java.util.Scanner;

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
            sb.append(tokens[i]+ " ");

        sb.append(tokens[0]);
        return sb.toString();
    }

    public static boolean canFormPalindrome(String str){

        int [] count = new int[256];
        for(int i=0;i<str.length();i++){
            count[(int) str.charAt(i)]++;
        }
        int oddCount = 0;
        for(int i=0;i<count.length;i++){
            if(count[i]%2 !=0)
                oddCount++;
        }

        if(oddCount >1)
            return false;

        return true;

    }

    public static void LongestCommonSubstring(ArrayList<String> list){
        if(list ==null || list.size() ==0)
            return;
        String str1 = list.get(0);
        for(int i=1;i<list.size();i++){
            String str2 = list.get(i);
            for(int j = 0;j<str1.length()&& j< str2.length();j++){
                if(str1.charAt(j)!=str2.charAt(j)){
                    str1 = str1.substring(0,j);
                }
            }
        }
        System.out.println(str1);
    }

    public static void main(String[] args) {

     /*   Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(canFormPalindrome(str));*/

        LongestCommonSubstring(new ArrayList<String>(){{
        add("hellosdsd");
        add("hellsdsdSD");
        add("qhellla");
    }});
}}

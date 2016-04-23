package Strings;

import java.util.HashMap;

/**
 * Created by Anand on 4/19/2016.
 */
public class PrintAllWords {


    public static void printAllWords(String str, char [] output, HashMap<Integer, String> dictionary, int pos) {
        if (pos == str.length()){
            System.out.println(String.valueOf(output));
            return;
        }
        String alphabets = dictionary.get(Integer.parseInt(String.valueOf(str.charAt(pos))));
        for (int i = 0; i < alphabets.length(); i++) {
            output[pos]= alphabets.charAt(i);
            printAllWords(str, output, dictionary, pos + 1);
            if (str == "0" || str == "1")
                return;
        }
    }

    public static void main(String[] args) {
        String str = "23";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "ghi");

        printAllWords(str, new char[2], map, 0);
    }
}

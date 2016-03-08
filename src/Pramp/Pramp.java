package Pramp;

import java.util.*;

/**
 * Created by Anand on 2/29/2016.
 */
public class Pramp {


    public static void wordCount(String text) {

        String[] tokens = text.split("\\s");
        SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> e1,
                                       Map.Entry<String, Integer> e2) {

                        if(e1.getValue()>=e2.getValue())
                            return -1;
                        return
                                1;

                    }
                });

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("[a-zA-z]+")) {
                if (map.get(tokens[i].toLowerCase()) != null) {
                    int count = map.get(tokens[i].toLowerCase());
                    map.put(tokens[i].toLowerCase(), ++count);
                } else {
                    map.put(tokens[i].toLowerCase(), 1);
                }
            }
        }
        sortedset.addAll(map.entrySet());
        System.out.println(sortedset);
    }


    public static void main(String [] args){
        wordCount("Practice make Practice makess man man");

    }


}
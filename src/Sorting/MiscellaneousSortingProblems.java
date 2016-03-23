package Sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Anand on 2/9/2016.
 */
public class MiscellaneousSortingProblems {

    //Given a company name and rank number, sort the companies by their number.

    public static void sortByValues(HashMap<String, Integer> hashmap) {
        TreeMap<String, Integer> tm = new TreeMap(new MyComp(hashmap));
        tm.putAll(hashmap);
        System.out.println(tm);
    }

    public static void sortByKeys(HashMap<String, Integer> hashmap) {
        TreeMap<String, Integer> tm = new TreeMap(new MyCompKeys(hashmap));
        tm.putAll(hashmap);
        System.out.println(tm);
    }

    public static void sortedTreeMap(){
        TreeMap<String, Integer> tm = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        tm.put("Anand", 5);
        tm.put("Bhondu", 2);
        tm.put("AAGupta", 1);
        tm.put("Red Boy", 8);
        System.out.println(tm);
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        hashmap.put("Anand", 6);
        hashmap.put("Bhondu", 9);
        hashmap.put("Nitu", 1);
        hashmap.put("Dude", 3);
        sortedTreeMap();
    }
}




class MyComp implements Comparator<String> {

    private HashMap<String, Integer> map;
    public MyComp(HashMap<String, Integer> map) {
        this.map = map;
    }
    public int compare(String a, String b) {
        return map.get(a).compareTo(map.get(b));
    }
}

class MyCompKeys implements Comparator<String> {

    private HashMap<String, Integer> map;
    public MyCompKeys(HashMap<String, Integer> map) {
        this.map = map;
    }
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
}
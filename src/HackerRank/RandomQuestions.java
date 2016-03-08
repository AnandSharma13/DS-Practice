package HackerRank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Anand on 3/2/2016.
 */
public class RandomQuestions {


    public static void countSumK(int[] arr, int k) {
        Arrays.sort(arr);
        //i points to smaller items
        //j points to larger item
        int count = 0;
        for (int i = 0, j = 0; i < arr.length && j < arr.length; ) {
            if ((arr[j] - arr[i]) == k) {
                i++;
                j++;
                count++;
            } else if (arr[j] - arr[i] < k)
                j++;
            else
                i++;
        }
        System.out.println(count);
    }



    public static void main(String[] args) {
        countSumK(new int[]{7, 3, 1, 2, 4, 7, 9}, 2);


        Scanner scanner = new Scanner(System.in);


    }

}

package Arrays;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Anand on 4/8/2016.
 */
public class GeekForGeeks {


    public static void mergeArraysPlace(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int last;
        int j;
        //iterate over second array
        for (int i = n - 1; i >= 0; i--) {
            j = m - 2;    //1st array
            last = arr1[m - 1]; //last element of first array
            while (j >= 0 && arr2[i] < arr1[j]) {
                arr1[j + 1] = arr1[j];
                j--;
            }
            //there was a swap
            if (j != m - 2) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
        arrayPrinter(arr1);
        arrayPrinter(arr2);
    }


//    Maximum of all subarrays of size k

    public static void printKMax(int[] arr, int k) {

        PriorityQueue<Integer> Q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1.compareTo(o2));
            }
        });
        int max;
        for (int i = 0; i <arr.length; i++) {
            if(i<=k){
                Q.add(arr[i]);
            }else{
                max = Q.peek();
                System.out.println(max);
                Q.remove(arr[i-k]);
                Q.add(arr[i]);
            }
        }
        max = Q.peek();
        System.out.println(max);
    }


    public static void arrayPrinter(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
//        mergeArraysPlace(new int[]{2, 6, 11}, new int[]{1, 4, 17});
        printKMax(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6},3);
    }

}

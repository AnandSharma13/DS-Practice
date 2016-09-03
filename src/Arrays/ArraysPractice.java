package Arrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Anand on 3/7/2016.
 */
public class ArraysPractice {


    //partition algorithm
    public static int kthSmallest(int[] nums, int k) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = partition(nums, lo, hi);
            if (mid == k) return nums[mid];
            else if (mid > k) {
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return -1;
    }

    public static int partition(int[] nums, int lo, int hi) {

        int i = lo;
        int j = lo;
        int pivot = nums[hi];
        while (i <= hi && j <= hi) {
            if (nums[i] > pivot)
                i++;

            else if (nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return j - 1;

    }


    public static void mergeSortedArrays(int[] arr1, int[] arr2) {


    }

    public static void multiplyTwoNumber(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int s = C.length - 1;

        for (int j = B.length - 1; j >= 0; j--) {
            int carry = 0;
            int shift = s;
            for (int i = A.length - 1; i >= 0; i--) {
                int m = A[i] * B[j];
                int sum = m + C[shift] + carry;
                int num = sum % 10;
                int c = sum / 10;
                C[shift] = num;
                carry = c;

                shift--;
            }
            C[shift] = C[shift] + carry;
            s--;
        }
    }

    public static void arrayListSorting(ArrayList<Student> list) {
        list.add(new Student(45, "Anand"));
        list.add(new Student(5, "Abhishek"));
        list.add(new Student(15, "Nitish"));
        list.add(new Student(25, "Mayank"));
        list.add(new Student(1, "Abhijat"));

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.id < o2.id)
                    return -1;
                else
                    return +1;
            }
        });
        for (Student s : list)
            System.out.println(s.id);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 2, 5, 0};
        System.out.println(kthSmallest(nums, 2));
        // arrayPrinter(nums);

        arrayListSorting(new ArrayList<>());
    }

    public static void arrayPrinter(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

package Arrays;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Anand on 2/1/2016.
 */
public class MiscellaneousProblems {


    public static void priorityQueue(int[] n) {

        Queue q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > 02)
                    return 1;
                else
                    return -1;

            }
        });
        for (int i = 0; i < n.length; i++) {
            q.add(n[i]);
        }

        Iterator it = q.iterator();
        while (it.hasNext()) {
            System.out.println("Value: " + it.next());
        }

    }

    public static void findKthSmallest(int[] nums, int k) {

        boolean swapped = true;
        int j = 0;

        while (swapped == true) {
            swapped = false;
            if (j == k)
                break;
            else
                j++;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        arrayPrinter(nums);
    }

    public static void arrayPrinter(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void IEEProblemsBitWise(int[] nums) {
        //stores the maximum match
        int prevMax = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            int max = 0;
            for (int j = i + 1; j < nums.length; ++j) {
                int num = (nums[i] | nums[j]);
                if (num > max) {
                    max = num;
                }
                if (max > prevMax) {
                    prevMax = max;
                    count = 0;
                } else if (max == prevMax) {
                    count++;
                }
            }
        }

        int ones = 0;
        while (prevMax != 0) {
            prevMax = prevMax & (prevMax - 1);
            ones++;
        }

        System.out.println("Total Ones " + ones);
        System.out.println("Total count " + count);
    }

    public static void bipraIntuit(int[] nums) {
        int min = nums[0];
        int max = nums[1];
        int tempMin = nums[0];
        for (int i = 2; i < nums.length; i++) {

            if (nums[i] < min && nums[i] < tempMin) {
                tempMin = nums[i];
            } else if (nums[i] > max || Math.abs(nums[i] - tempMin) > max - min) {
                min = tempMin;
                max = nums[i];
            }
        }

        System.out.println("Min\t" + min);
        System.out.println("Max\t" + max);

    }

    public static int kthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = partition(nums, lo, hi);
            if (mid == k) return mid;
            if (k < mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        int j = lo;
        while (j <= hi && i <= hi) {
            if (nums[j] > pivot) {
                j++;
            } else if (nums[j] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return i - 1;
    }

    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) / 2);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static void maxProfit(int[] nums) {
        int min = nums[0];
        int currMin = nums[0];
        int diff = 0;
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < currMin) {
                currMin = nums[i];
            } else if (nums[i] - currMin > diff) {
                min = currMin;
                max = nums[i];
                diff = max - min;
            }
        }
        System.out.println(min);
        System.out.println(max);

    }






    private static void sortArrayWave(int[] nums) {

        if (nums == null)
            return;

        for (int i = 0; i < nums.length; i+=2) {
            if(i>0 && nums[i] <nums[i-1]){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
            if(i<nums.length - 1 && nums[i] <nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        arrayPrinter(nums);
    }




//      lo              hi
//      5   1   2   3   4

    public static int startIndexRotatedArray(int [] nums) throws Exception {

        if(nums == null)
            throw new Exception();

        int len = nums.length;
        int lo = 0;
        int hi = len -1;

        while(nums[lo] >nums[hi]){
        int mid = (lo+hi)/2;
        if(nums[mid]<nums[hi])
            hi = mid;
        else
            lo =mid +1;
        }
        return lo;
    }





    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{4, 2, 1, -2, 100};
      //  sortArrayWave(new int[]{3, 1, 11, 3, 22, 3});

        System.out.println(startIndexRotatedArray(new int [] {4,5,1,2,3}));

    }
}
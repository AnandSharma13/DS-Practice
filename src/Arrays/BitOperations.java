package Arrays;

/**
 * Created by Anand on 2/3/2016.
 */
public class BitOperations {


    public static int hammingWeight(int n) {

        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >> 1;
        }
        return ones;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        return ((n & (n - 1)) == 0);
    }


    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(5));

        System.out.println(isPowerOfTwo(5));
    }

}


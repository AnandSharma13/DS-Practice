package Numbers;

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


    static int Add(int x, int y)
    {
        // Iterate till there is no carry
        while (y != 0)
       {
            // carry now contains common set bits of x and y
            int carry = x & y;
            System.out.println(Integer.toBinaryString(carry));
            // Sum of bits of x and y where at least one of the bits is not set
            x = x ^ y;
            System.out.println(Integer.toBinaryString(x));
            // Carry is shifted by one so that adding it to x gives the required sum
            y = carry << 1;
            System.out.println(Integer.toBinaryString(y));
       }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(Add(5,1));
     //   System.out.println(Integer.toBinaryString(12));

    }

}


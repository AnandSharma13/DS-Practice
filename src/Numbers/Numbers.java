package Numbers;

/**
 * Created by Anand on 3/8/2016.
 */
public class Numbers {


    public static boolean isHappy(int n) {
        while (true) {
            int len = Integer.toString(n).length();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                int digit = n % 10;
                n = n / 10;
                sum += Math.pow(digit, 2);
            }
            n = sum;
            if (sum == 1) {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }


}

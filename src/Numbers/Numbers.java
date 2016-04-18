package Numbers;

import java.util.Vector;

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

    public static int vectorDotProduct(Vector vector1, Vector vector2) {
        int len1 = vector1.size();
        int len2 = vector2.size();

        int count = len2 > len1 ? len1 : len2;
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += (int) vector1.get(i) * (int) vector2.get(i);
        }
        return sum;
    }

    public static void findPrimeFactors(int n) {

        while (n % 2 == 0) {
            System.out.println(2);
            n = n / 2;
        }
        for (int i = 3; i < Math.sqrt(n); i = i + 2) {
            while (n % i == 0) {
                System.out.println(i);
                n = n/3;
            }
        }
        if (n > 2)
            System.out.println(n);
    }

    public static String numberToString(int number){

        String []ones= {"", "one", "two", "three", "four", "five" , "six", "seven" , "eight", "nine"};
        String []tens= {"", "ten", "twenty", "thirty", "fourty", "fifty" , "sixty", "seventy" , "eighty", "ninety"};
        String []hundreds= {"", "", "one-hundred", "two-hundred", "three-hundred", "four-hundred" , "five-hundred", "six-hundred" , "seven-hundred", "eight-hundred", "nine-hundred"};

        return  hundreds[(number%1000)/100]+" "+tens[(number%100)/10]+" "  +ones[number%10];
    }


    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        int val1 = scanner.nextInt();
        int val2 = scanner.nextInt();

        ArrayList<Integer> v1 = new ArrayList<Integer>();
        ArrayList<Integer> v2 = new ArrayList<Integer>();
        int maxIndex =0;
        for(int i=0;i<val1;i++){
            int x = scanner.nextInt();
        }*/
        System.out.println(numberToString(678));
        findPrimeFactors(15);


    }


}

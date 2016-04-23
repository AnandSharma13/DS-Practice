package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand on 4/18/2016.
 */
public class ExpressionAddOperator {

    public static void ExpAdd(String str, int target) {

        if (str == null || str.length() == 0)
            return;
        List<String> sol = new ArrayList<>();
        expAddHelper(sol, str, "", str.length(), target, 0, 0, 0);
        System.out.println(sol);
    }

    public static void expAddHelper(List<String> sol, String str, String exp, int len, int target, int value, int pos, int offset) {

        if (pos >= len) {
            if(value == target)
                sol.add(exp);
            return;
        }

        for (int i = pos; i < len; i++) {
            int number = Integer.parseInt(str.substring(pos, i + 1));
            if(i!=pos && str.charAt(pos) == '0')
                break;

            if (pos == 0) {
                expAddHelper(sol, str, number + "", len, target, number, i + 1, number);
            } else {
                expAddHelper(sol, str, exp + "+" + number, len, target, value + number, i + 1, number);
                expAddHelper(sol, str, exp + "-" + number, len, target, value - number, i + 1, -number);
                expAddHelper(sol, str, exp + "*" +number, len, target, value - offset + number * offset, i + 1, number*offset);
            }

        }
    }

    public static void main(String [] args){
        ExpAdd("0205", 7);
    }


}

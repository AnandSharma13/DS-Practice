package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand on 4/16/2016.
 */
public class ExpressionAddOperators {

    public static void foo(String str, int target) {

        List<String> mList = new ArrayList<>();
        int len = str.length();
        String temp = String.valueOf(str.charAt(0));
        fooHelper(mList, str, len, 0, "", Long.parseLong(temp), target, Long.valueOf(0));
        System.out.println(mList);
    }

    public static void fooHelper(List<String> mList, String str, int len, int pos, String exp, Long val, int target, Long offset) {
        if (pos >= len) {
            if (val == target)
                mList.add(exp);
            return;
        }
        for (int i = pos; i < len; i++) {
          //case where string starts with a zero
           if (i != pos && str.charAt(pos) == '0')
                break;
            Long number = Long.parseLong(str.substring(pos, i + 1));
            if (pos == 0) {
                fooHelper(mList, str, len, i + 1, exp + number, number, target, number);
            } else {
                fooHelper(mList, str, len, i + 1, exp + "+" + number, val + number, target, number);
                fooHelper(mList, str, len, i + 1, exp + "-" + number, val - number, target, -number);
                fooHelper(mList, str, len, i + 1, exp + "*" + number, val - offset + number * offset, target, val * number);
            }
        }
    }

    public static void main(String[] args) {

        foo("25", 5);
    }


}

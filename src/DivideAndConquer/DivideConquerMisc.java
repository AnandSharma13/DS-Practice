package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anand on 2/10/2016.
 */
public class DivideConquerMisc {


    public static List<Integer> diffWaysToCompute(String input) {


        List<Integer> resultList = new ArrayList<>();
        for(int i =0;i<input.length();i++){

            char c = input.charAt(i);
            if(c == '+'||c =='-'||c == '*'){

                String s1 = input.substring(0,i);
                String s2 = input.substring(i +1);
                List<Integer> list1 = diffWaysToCompute(s1);
                List<Integer> list2 = diffWaysToCompute(s2);
                for(Integer n1 : list1){
                    for(Integer n2 : list2){
                        int res =0;
                        switch(input.charAt(i)){
                            case '+':
                                res =  n1 + n2;
                                break;
                            case '-':
                                res = n1 - n2;
                                break;
                            case '*':
                                res = n1 * n2;
                                break;

                        }
                        resultList.add(res);

                    }
                }
            }

        }
        if(resultList.size() ==0)
            resultList.add(Integer.valueOf(input));
        return resultList;
    }




    public static void main(String [] args){

        System.out.println(diffWaysToCompute("2-1-1"));

    }
}

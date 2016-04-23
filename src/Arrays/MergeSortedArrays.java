package Arrays;

/**
 * Created by Anand on 4/20/2016.
 */
public class MergeSortedArrays {


    void merge(int ar1[], int ar2[], int m, int n) {
        if (n == 0 || m == 0)
            return;
        int temp;
        int j = m-1;
        for (int i = n - 1; i >= 0; i--) {
            temp = ar2[i];
            int k;
            for(k = m-1;k>=0 && temp<ar1[k];k--){
                ar1[k+1] =  ar1[k];
            }



        }


    }


}

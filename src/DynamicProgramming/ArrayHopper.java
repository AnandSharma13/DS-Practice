package DynamicProgramming;

/**
 * Created by Anand on 4/18/2016.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayHopper {
    public static void main(String args[] ){
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        List<Integer> input=new ArrayList<Integer>();

        boolean malFormedInput=false;
        Scanner scan=new Scanner(System.in);
        int in;
        while(scan.hasNext()){

            try{
                in=scan.nextInt();
                if(in>=0)
                    input.add(in);
                else{
                    malFormedInput=true;
                    break;
                }
            }catch(Exception ex){

                malFormedInput=true;
                break;
            }

        }

        if(!malFormedInput && input.size()!=0){ // Run the code only if the input is not malformed and is not empty.
            ArrayHopper sol=new ArrayHopper();
            List<Integer> minHopsPath=sol.findMinHops(input);
            if(minHopsPath!=null){
                for(int i:minHopsPath){
                    System.out.print(i+", ");
                }
                System.out.println("out");

            }
            else{
                System.out.println("failure");
            }
        }
        else{
            System.out.println("failure");
        }

    }
    public List<Integer> findMinHops(List<Integer> input) {
        ArrayList<Integer> hoppingPath = new ArrayList<>();
        int hopIndex = 0, previousMaxIndexReachable = 0, currentMaxIndexReachable = 0;

        int temp;
        int k;

        if(input.size()==1 && input.get(0)>0){ // if input array is a single element with value > 0 like [1] or [2]
            hoppingPath.add(0);
            return hoppingPath;
        }
        else{
            for (k = 0; k < input.size(); k++) {
                // If no hops possible due to presence of 0 in the input array at some index/indices
                if (k > currentMaxIndexReachable){
                    break;
                }
                // Updating the hoppingPath list after all the index positions reachable from the last computed hop index                            have been traversed
                if (k > previousMaxIndexReachable) {
                    hoppingPath.add(hopIndex);
                    previousMaxIndexReachable = currentMaxIndexReachable;
                }

                //Computing the best hop index that maximizes the farthest index reachable from the last selected hop index
                temp = k + input.get(k);
                if (temp > currentMaxIndexReachable){
                    hopIndex = k;
                    currentMaxIndexReachable=temp;
                }

            }

            // Adding the last hop index in the minimum hops path if its not present in the hoppingPath list i.e. the output
            if ((k > previousMaxIndexReachable) && (hoppingPath.size() > 0) && (hoppingPath.get(hoppingPath.size() - 1))!=hopIndex){
                hoppingPath.add(hopIndex);
            }

            //Return the hoppingPath output list if there exists a minimum hops path else return null if no solution
            if (previousMaxIndexReachable >input.size() - 1||(previousMaxIndexReachable==input.size() - 1 &&  input.get(previousMaxIndexReachable)!=0))
                return hoppingPath;

            return null;
        }
    }

}


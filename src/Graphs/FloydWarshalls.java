package Graphs;

/**
 * Created by Anand on 5/24/2016.
 */
public class FloydWarshalls {

    public static final int INF = 99999;


    public static void floydWarshall(int[][] graph) {
        int len = graph.length;
        int width = graph[0].length;
        int vertices = len;
        int[][] sol = new int[len][width];
        int[][] path = new int[len][width];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                sol[i][j] = graph[i][j];
                path[i][j] = j;
            }
        }

        //outer loop is for intermediate vertices
        for (int i = 0; i < vertices; i++) {
            //source loop
            for (int j = 0; j < vertices; j++) {
                // destination loop
                for (int k = 0; k < vertices; k++) {
                    if (sol[j][k] > sol[j][i] + sol[i][k]) {
                        sol[j][k] = sol[j][i] + sol[i][k];
                        path[j][k] = path[j][i];
                    }

                }
            }
        }
        //      printMatrix(sol);
        //       printPath(path,0,2);
    }


    public static void transitiveClosureGrapth(int[][] graph) {

        int vertices = graph.length;
        int[][] sol = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                sol[i][j] = graph[i][j];
            }
        }
        //go through every intermediate vertex
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                for (int k = 0; k < vertices; k++) {
                if((sol[j][k] !=0)|| (sol[j][i]!=0) &&  (sol[i][k] !=0))
                    sol[j][k] =1;
                 else
                    sol[j][k] = 0;
                }
            }
        }
        printMatrix(sol);
    }

    public static void printPath(int[][] path, int source, int destination) {
        if (path[source][destination] == INF)
            return;
        System.out.println(source);
        while (source != destination) {
            source = path[source][destination];
            System.out.println(source);
        }
    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] graph = new int[][]{ {1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {1, 0, 0, 1}
        };
        transitiveClosureGrapth(graph);
    }


}

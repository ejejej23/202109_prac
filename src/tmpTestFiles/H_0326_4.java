package tmpTestFiles;

import java.util.Arrays;

public class H_0326_4 {
    public static void main(String[] args) {
//        int[][] beds = {{2, 3, 40},{2, 5, 20}};
//        int[][] tables = {{1, 1, 30}};
//        int cost = 10000;
//        int[][] beds = {{2, 3, 40000},{2, 5, 20000}};
//        int[][] tables = {{1, 1, 30000}};
//        int cost = 10;
        int[][] beds = {{4, 1, 200000}};
        int[][] tables = {{2, 3, 100000}};
        int cost = 10000;

        System.out.println(solution(beds, tables, cost));
    }

    static long solution(int[][] beds, int[][] tables, int cost) {
        long answer = Long.MAX_VALUE;

        for(int i=0; i<beds.length;i++){
            int[] bed = beds[i];
            for(int j=0; j<tables.length;j++){
                int[] table = tables[j];

                long room =
                    Math.min(
                        Math.min(
                            (bed[0]+table[0])*(bed[1]>table[1]? bed[1]:table[1]),
                            (bed[0]+table[1])*(bed[1]>table[0]? bed[1]:table[0])
                        ),
                        Math.min(
                            (bed[1]+table[0])*(bed[0]>table[1]? bed[0]:table[1]),
                            (bed[1]+table[1])*(bed[0]>table[0]? bed[0]:table[0])
                        )
                    );

                answer = Math.min(bed[2] + table[2] + room*cost, answer);
            }
        }

        return answer;
    }
}

package prg;

import java.util.Arrays;

public class prg_1006_1 {
    public static void main (String[] args){
        int[][] sizes =
//        {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//        {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(solution(sizes));
    }

    static public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;

        for(int i =0; i<sizes.length; i++){
            Arrays.sort(sizes[i]);
//            System.out.println(Arrays.toString(sizes[i]));
            x = (i==0)? sizes[i][0] : (sizes[i][0] > x ? sizes[i][0] : x);
            y = (i==0)? sizes[i][1] : (sizes[i][1] > y ? sizes[i][1] : y);
        }
        return x*y;
    }
}

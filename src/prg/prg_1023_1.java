package prg;

import java.util.Arrays;

public class prg_1023_1 {
    //스택/큐 기능개발문제
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = {};

        answer = solution(array,command);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        System.out.println(commands.length);

        int pos = 0;
        for(int[] arr :commands){
            int[] tmp = Arrays.stream(array)
                    .limit(arr[1])
                    .skip(arr[0]-1)
                    .sorted()
                    .toArray();

            answer[pos++] = tmp[arr[2]-1];
        }

        return answer;
    }
}

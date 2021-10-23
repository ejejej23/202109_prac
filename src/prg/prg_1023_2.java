package prg;

import java.util.Arrays;

public class prg_1023_2 {
    //정렬 가장큰수 문제
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        String answer = solution(numbers);
        System.out.println(answer);
    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] strArr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted(((o1, o2) -> (o2+o1).compareTo(o1+o2)))
                .toArray(String[]::new);

        if(strArr[0].equals("0")) return "0";

        answer = String.join("",strArr);
        return answer;
    }
}

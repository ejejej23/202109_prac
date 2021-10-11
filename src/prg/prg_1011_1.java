package prg;

import java.util.*;

public class prg_1011_1 {

    public static void main(String[] args) {
        String[] strArr = {"12", "112","113", "122"};
        System.out.println(solution(strArr));

    }

    public static boolean solution(String[] phone_book){
        boolean answer = true;
        int length = phone_book.length;

        Arrays.sort(phone_book);
        //System.out.println(Arrays.toString(phone_book));

        for (int i = 0; i < length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return answer;
    }
}

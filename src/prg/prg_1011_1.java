package prg;

import java.util.Arrays;
import java.util.Comparator;

public class prg_1011_1 {

    public static void main(String[] args) {
        String[] strArr = {"119", "97674223", "1195524421"};
        System.out.println(solution(strArr));

    }

    public static boolean solution(String[] phone_book){
        boolean answer = true;
        int length = phone_book.length;
        Arrays.sort(phone_book, Comparator.comparing(String::length));

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }

        return answer;
    }
}

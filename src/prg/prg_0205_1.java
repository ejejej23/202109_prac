package prg;

import java.util.*;

public class prg_0205_1 {
	public static void main(String[] args) {
		prg_0205_1 s = new prg_0205_1();

//		int[] answers = {1,2,3,4,5,1,2,5};
//		int[] answers = {2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
//		int[] answers = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int[] answers = {0};
		s.solution(answers);

	}

	public int[] solution(int[] answers){
		int[] pRule1 = {1,2,3,4,5};
        int[] pRule2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pRule3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt1=0;
        int cnt2=0;
        int cnt3=0;


        for(int i=0; i<answers.length; i++){
			if(answers[i] == pRule1[i%pRule1.length]) cnt1++;
            if(answers[i] == pRule2[i%pRule2.length]) cnt2++;
            if(answers[i] == pRule3[i%pRule3.length]) cnt3++;
		}

        int max = Math.max(Math.max(cnt1,cnt2),cnt3);

        List<Integer> list = new ArrayList<>();
        if(cnt1 == max) list.add(1);
        if(cnt2 == max) list.add(2);
        if(cnt3 == max) list.add(3);

        int[] answer = list.stream().mapToInt(i->i).toArray();

		return answer;
	}

}

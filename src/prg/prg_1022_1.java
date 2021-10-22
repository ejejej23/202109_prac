package prg;

import java.util.*;

public class prg_1022_1 {
    //프로그래머스 스택/큐 기능개발 문제
    public static void main(String[] args) {
        int[] answer={};
        int[] progresses = {96,94};
        int[] speeds = {3,3};
//      progresses = {93, 30, 55};
//      progresses = {95, 90, 99, 99, 80, 99};
//      speeds = {1, 30, 5};
//      speeds = {1, 1, 1, 1, 1, 1};

        answer = solution(progresses, speeds);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<progresses.length; i++){
            int day = (100 - progresses[i])/speeds[i];
            int cal = (100 - progresses[i])%speeds[i] == 0 ? day : day+1;
            list.add(cal);
        }

        int rDay = 1;
        int cnt = 1;
        int lastRday = list.get(0);

        map.put(rDay, cnt);
        for(int i=1; i<list.size(); i++){
            int listVal = list.get(i);

            if(listVal<=lastRday){
                map.put(rDay,map.get(rDay)+1);
            }else{
                lastRday = listVal;
                map.put(++rDay,cnt);
            }
        }

        int size = map.size();
        int pos = 0;
        int[] answer = new int[size];
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            answer[pos++] = entry.getValue();
        }

        return answer;
    }
}

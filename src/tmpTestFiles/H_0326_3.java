package tmpTestFiles;

import java.util.ArrayList;
import java.util.List;

class pair6{
    String m;
    String c;
    String bfr;
    int bfrRound;

    pair6(String m){
        this.m = m;
    }

    boolean isErr(){
        if(this.m.equals(this.c)) return true;
        else return false;
    }
}
public class H_0326_3 {
    static String[] arr = {"a","b","c","d"};
    public static void main(String[] args) {
//        String[][] rounds = {{"b", "a", "a", "d"},{"b", "c", "a", "c"},{"b", "a", "d", "c"}};
        String[][] rounds = {{"b", "a", "d", "c"},{"b", "a", "c", "d"}};
//        String[][] rounds = {{"b", "a", "d", "c"},{"d", "c", "b", "a"},{"b", "a", "d", "c"}};
        System.out.println(solution(rounds));
    }

    static int solution(String[][] rounds){
        int answer = 0;

        List<pair6> list = new ArrayList<>();
        for(int j=0 ;j<4; j++){
            list.add(new pair6(arr[j]));
        }

        for(int i=0 ;i<rounds.length; i++){
            String[] r = rounds[i];

            for(int j=0 ;j<4; j++){
                list.get(j).c = r[j];
            }

            for(int j=0 ;j<4; j++){
                pair6 p = list.get(j);
                if(p.isErr()){
                    answer++;
                    continue;
                }
                if(p.bfr!= null && p.bfr.equals(p.c) && p.bfrRound == i-1){
                    answer++;
                    continue;
                }

                for(int k=j+1 ;k<4; k++){
                    pair6 p2 = list.get(k);
                    if(p.m.equals(p2.c) && p.c.equals(p2.m)){
                        p.bfr = p2.m;
                        p.bfrRound = i;
                        p2.bfr = p.m;
                        p2.bfrRound = i;
                    }
                }
            }

        }

        return answer;
    }
}

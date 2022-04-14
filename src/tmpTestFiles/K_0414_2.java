package tmpTestFiles;

import java.util.*;
import java.util.stream.IntStream;

class Accnt{
    int chkIdx;
    int len;
    int cnt;

    Accnt(int chkIdx, int len, int cnt){
        this.chkIdx = chkIdx;
        this.len = len;
        this.cnt = cnt;
    }
}

public class K_0414_2 {
    public static void main(String[] args) {
//        String[] nums = {"4514--234495-1","305-44-291501","1-2-34-495-8623","492134545151","623-421523-67-341","-5439-59639921","6235-7X3+47-7456","98-76-543-210","512-73-634901","000-999999-22-555","064-82-792561"};
        String[] nums = {"1-2-3-456789012","582845-385823","48572-39485-89012","4-5-2-593328484","4958-39-2945123-","49582039415423","7-3-7-000000000","485723-693812","39482746582734","1-1-1-111111111","A4944-5095-4951","4851293412223"};
        int[] answer = solution(nums);

        for(int i : answer){
            System.out.println(i);
        }
    }

    static public int[] solution(String[] nums) {
        int[] answer = {};
        ArrayList<String> crrAccnt = new ArrayList<>();

        for(String str : nums){
            if(!isValid(str)) continue;
            crrAccnt.add(str);
        }

        HashMap<String, Accnt> map = new HashMap<>();
        for(String str : crrAccnt){
            int chk = 0;
            int charCnt = str.length() - str.replace("-","").length();
            int idx = 0;
            for(int i=0; i<charCnt; i++){
                idx = str.indexOf("-",idx == 0? 0 : idx+1);
                chk = chk | (1 << idx);
            }

            StringBuilder chkSb = new StringBuilder();
            chkSb.append(chk);
            chkSb.append(str.length());
            String chkStr = chkSb.toString();

            if(map.containsKey(chkStr)){
                Accnt accnt = map.get(chkStr);
                accnt.cnt += 1;
                map.put(chkStr, accnt);
            }else{
                map.put(chkStr,new Accnt(chk, str.length(), 1));
            }
        }

        answer = new int[map.size()];
        int j=0;
        for(Map.Entry<String, Accnt> e : map.entrySet()){
            answer[j++] = e.getValue().cnt;
        }

        Arrays.sort(answer);
        for (int i = 0; i < answer.length / 2; i++) {
            int temp = answer[i];
            answer[i] = answer[answer.length - i - 1];
            answer[answer.length - i - 1] = temp;
        }

        return answer;
    }

    static boolean isValid(String str){
        //규칙4
        if(str.indexOf("--")>0) return false;
        if(str.indexOf("-") == 0 || str.lastIndexOf("-") == (str.length()-1)) return false;

        //규칙3
        String chkNum = str.replace("-","");
        int charCnt = str.length() - chkNum.length();
        if(charCnt>3 || charCnt<0) return false;

        //규칙1
        if(!chkNum.matches("[+-]?\\d*(\\.\\d+)?")) return false;

        //규칙2
        if(chkNum.length()<11 || chkNum.length()>14) return false;

        return true;
    }
}

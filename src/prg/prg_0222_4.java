package prg;

import java.util.LinkedList;
import java.util.Queue;

class Word {
    String word;
    int cnt;

    Word (String word, int cnt){
        this.word= word;
        this.cnt = cnt;
    }
}

public class prg_0222_4 {
    static boolean[] chk;
    static int answer=0;


    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        answer = 0;
        var len = begin.length();
        chk = new boolean[words.length];

        int trgtIdx = -1;
        for(int i=0; i<words.length; i++){
            if(target.equals(words[i])) trgtIdx = i;
        }
        if(trgtIdx<0) return 0;

        bfs(begin, target, words, 0);

        return answer;
    }
    public static void bfs(String begin, String target, String[] words, int n){
        //단어변환문제 bfs
        if(begin.equals(target)){
            answer = n;
        }

        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));

        while (!q.isEmpty()){
            Word w = q.poll();
            if(target.equals(w.word)) {
                answer = w.cnt;
                break;
            }

            for(int i =0; i< words.length; i++){
                if(!chk[i] && isConvert(w.word, words[i])){
                    chk[i] = true;
                    q.add(new Word(words[i], w.cnt+1));
                }
            }
        }

    }

    public static boolean isConvert(String word, String convertWord) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != convertWord.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}

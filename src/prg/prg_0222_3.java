package prg;

public class prg_0222_3 {
    static boolean[] chk;
    static int answer = 0;
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        var len = begin.length();
        chk = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int n){
        //단어변환문제 dfs
        if(begin.equals(target)){
            answer = n;
        }

        var len = words.length;
        for(int i=0; i<len; i++){
            if(chk[i]) continue;

            int k=0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)) k++;

                if(k == begin.length()-1){
                    chk[i] = true;
                    dfs(words[i], target, words, answer+1);
                    chk[i] = false;
                }
            }
        }
    }
}

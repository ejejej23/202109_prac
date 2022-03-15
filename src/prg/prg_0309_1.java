package prg;

public class prg_0309_1 {
	public static void main(String[] args) {
		//완전탐색 카펫
		solution(10,2);
	}

	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
		int s = brown + yellow;
        int w=0;
        int h=0;

        for(int i=1; i<s; i++){
			if(s% i != 0) continue;
			w = i;
			h = s/i;
            if(w<h) continue;

            if((brown == 2*(w+h)-4) && (yellow + brown == w*h)){
                answer[0] = w;
                answer[1] = h;
				System.out.println(w +" : "+h);
				return answer;
            }
        }

        return answer;
    }
}

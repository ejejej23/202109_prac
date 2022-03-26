package tmpTestFiles;

public class H_0326_5 {
    public static void main(String[] args) {
        int n=4;
        int m=5;
        int room=3;
        int bath=1;

        System.out.println(solution(n,m,room,bath));
    }
    static int solution(int n, int m, int room, int bath) {
        int answer =0;
        if(room *4 + bath*2 >= n*m){
            return 0;
        }


        return answer;
    }
}

public class Kakao_17_1 {

    public static void main(String[] args) {
        // 카카오 17년 1번문제
        // https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
        int n = 5;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30, 1, 21, 17, 28};

        //비트연산하면 모양 가로기준으로 모양 알수있음
        for(int i=0; i<n; i++) {
            int rst = arr1[i] | arr2[i];
            System.out.println(Integer.toBinaryString(rst));
        }

        System.out.println();

        //결과를 비트연산해 #로 대체
        for(int i=0;i<n;i++) {
            int rst = arr1[i] | arr2[i];
            int chkBit = 1;
            String tmpStr = "";
            for(int j=0; j<n;j++) {
                tmpStr = ((rst & chkBit) > 0? "#": " ") + tmpStr;
                chkBit = chkBit << 1;
            }
            System.out.println(tmpStr);
        }
    }

}

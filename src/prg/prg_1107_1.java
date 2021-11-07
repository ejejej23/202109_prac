package prg;

public class prg_1107_1 {
    //콜라츠의 추측
    public static void main(String[] args) {
        System.out.println(chkNum(626331));
    }
    static public int chkNum(int num){
        long longNum = num;
        int cnt = 0;
        boolean chk = false;

        for(int i=0; i<500; i++){
            if(longNum == 1) return cnt;

            longNum = (longNum %2 == 0) ? longNum/2: longNum*3+1;
            cnt++;
        }

        return -1;
    }
}

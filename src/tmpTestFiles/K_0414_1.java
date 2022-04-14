package tmpTestFiles;

public class K_0414_1 {
    public static void main(String[] args) {
//        String[] card = {"02/01 12001 12","12/30 101 2"};
        String[] card = {"02/05 15000 2","03/11 5541 1","03/31 10000 3","03/31 100 1","05/15 10000 2","10/10 12345 1","11/22 5999 4","12/01 901 10"};
        int[] answer = solution(card);

        for(int i : answer){
            System.out.println(i);
        }
    }

    static public int[] solution(String[] card) {
        int[] answer = new int[13];

        for(String str : card){
            String[] data = str.split(" ");
            int mm = Integer.parseInt(data[0].substring(0,2));
            double money = Integer.parseInt(data[1]);
            double splt = Integer.parseInt(data[2]);

            switch(mm){
                case 12:
                    answer[mm] += money;
                    answer[0] += (int)Math.ceil(money/100.0);
                    break;
                default:
                    if(splt == 1){
                        answer[mm] += money;
                        answer[0] += (int)Math.ceil(money/100.0);
                    }else{
                        int tmpMoney = (int)Math.ceil(money/splt);
                        for(int i=0; i<splt; i++){
                            answer[mm+i > 12 ? 12 : mm+i] += tmpMoney;
                        }
                    }
                    break;
            }
        }

        return answer;
    }
}

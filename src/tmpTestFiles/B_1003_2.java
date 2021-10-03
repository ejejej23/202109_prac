package tmpTestFiles;

import java.io.IOException;
import java.util.Scanner;

public class B_1003_2 {
    public static void main(String[] args) throws IOException {
        //이진트리처럼 탑을 쌓았을때 숫자가 몇번째 층에 있는지 찾아보자
        Scanner input = new Scanner(System.in);

        int inputNum = input.nextInt();

        int rslt = getLayerNum(inputNum);
        System.out.println(rslt);
    }

    public static int getLayerNum(int num){
        if(num == 1) return 1;

        int layerNum = 2;
        while(true){
            if(num < Math.pow(2,layerNum)){
                break;
            }else{
                layerNum++;
            }
        }
        return layerNum;
    }

}

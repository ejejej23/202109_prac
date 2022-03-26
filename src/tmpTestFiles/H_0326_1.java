package tmpTestFiles;

import java.util.HashMap;

public class H_0326_1 {
    public static void main(String[] args) {
        int[][] v = {{1,4},{3,4},{3,10}};
        int[] ans = solution(v);
        System.out.println("["+ans[0]+","+ans[1]+"]");
    }
    static int[] solution(int[][] v){
        int[] ans = new int[2];
        HashMap<Integer,Integer> xMap = new HashMap<>();
        HashMap<Integer,Integer> yMap = new HashMap<>();
        for(int i=0; i<v.length;i++){
            int x = v[i][0];
            int y = v[i][1];

            if(xMap.get(x) == null){
                xMap.put(x,1);
            }else{
                xMap.put(x,xMap.get(x) +1);
            }
            if(yMap.get(y) == null){
                yMap.put(y,1);
            }else{
                yMap.put(y,yMap.get(y) +1);
            }
        }

        for(Integer k : xMap.keySet()){
            if(1 == xMap.get(k)) ans[0] = k;
        }
        for(Integer k : yMap.keySet()){
            if(1 == yMap.get(k)) ans[1] = k;
        }

        return ans;
    }
}

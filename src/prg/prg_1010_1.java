package prg;

import java.util.HashMap;

public class prg_1010_1 {
    //프로그래머스 해시3 위장 문제

    public static void main(String[] args) {
        String[][] clothes =
//                {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
                {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        int rslt = solution(clothes);
        System.out.println(rslt);
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length;i++){
            String key = clothes[i][1];
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else{
                map.put(key,1);
            }
        }

        int rslt = 1;
        for (String key : map.keySet()){
            rslt *= (map.get(key)+1);
//            System.out.println(key +" : "+ map.get(key));
        }

        return rslt-1;
    }

}

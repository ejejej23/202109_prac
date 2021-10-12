package tmpTestFiles;

import java.util.HashMap;
import java.util.Map;

public class fBar_1 {
    static Map<Character,String> map = new HashMap<>();

    public static void main(String[] args) {
        setMap();
//        solution("Braille");
//        solution("code");
        System.out.println(solution("The quick brown fox jumps over the lazy dog"));
    }

    public static String solution(String str){
        String rsltStr = "";

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);

            if(Character.isUpperCase(c)) rsltStr += map.get('0');

            String tmpStr = map.get(Character.toLowerCase(c));
            rsltStr += (tmpStr != null? tmpStr : "000000");
        }

        return rsltStr;
    }

    public  static void setMap(){
        map.put('0',"000001");//대문자표시

        map.put('a',"100000");
        map.put('b',"110000");
        map.put('c',"100100");
        map.put('d',"100110");
        map.put('e',"100010");
        map.put('f',"110100");
        map.put('g',"110110");
        map.put('h',"110010");
        map.put('i',"010100");
        map.put('j',"010110");
        map.put('k',"101000");
        map.put('l',"111000");
        map.put('m',"101100");
        map.put('n',"101110");
        map.put('o',"101010");
        map.put('p',"111100");
        map.put('q',"111110");
        map.put('r',"111010");
        map.put('s',"011100");
        map.put('t',"011110");
        map.put('u',"101001");
        map.put('v',"111001");
        map.put('w',"010111");
        map.put('x',"101101");
        map.put('y',"101111");
        map.put('z',"101011");
    }
}

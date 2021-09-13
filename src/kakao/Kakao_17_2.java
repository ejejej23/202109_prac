package kakao;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kakao_17_2 {

    static  int sum[] = new int[3];
    public static void main(String[] args) {
        // 카카오 17년 2번문제
        // https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
        // 유튜브 해설 참고한 공부코드

        func1("1S2D*3T");
    }

    public static void func1(String msg){
        String regex = "(\\d{1,2}[S|D|T][*|#]{0,1})";
        Pattern p = Pattern.compile(regex + regex + regex);     //compile(String regex) : 정규표현식으로부터 패턴 생성
        Matcher m = p.matcher(msg);                             //matcher(CharSequence input) : 대상 문자열이 패턴과 일치할 경우 true를 반환
        m.find();                                               //find() : 대상 문자열과 패턴이 일치하는 경우 true를 반환하고, 그 위치로 이동

        for(int i=1;i<=m.groupCount();i++){                                     //groupCount() : 패턴내 그룹핑한(괄호지정) 전체 갯수를 반환
            Pattern p1 = Pattern.compile("(\\d{1,2})([S|D|T])([*|#]{0,1})");
            Matcher m1 = p1.matcher(m.group(i));                                //group(int group) : 매칭된 부분중 group번 그룹핑 매칭부분 반환
            m1.find();
            sum[i-1] = (int) Math.pow(Integer.parseInt(m1.group(1))             //그룹으로 나눈 내용에서 p1은 또 괄호로 그룹을 나눔
                                        , func2(m1.group(2)));
            func3(i,m1.group(3));
        }
        System.out.println(msg + "  ::::::   " + (sum[0]+sum[1]+sum[2]));
    }

    public static int func2(String m){
        int val = 0;
        switch (m){
            case "S":
                val = 1;
                break;
            case "D":
                val = 2;
                break;
            case "T":
                val = 3;
                break;
        }
        return val;
    }

    public static void func3(int idx, String m){
        if("*".equals(m)){
            sum[idx-1] *= 2;
            if(idx>1){//1번째가 아니고 *이 중첩되는 경우
                sum[idx -2] *=2;
            }
        }else if("#".equals(m)){
            sum[idx-1] *= (-1);
        }

    }
}

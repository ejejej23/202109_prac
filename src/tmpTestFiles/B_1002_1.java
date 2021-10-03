package tmpTestFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class B_1002_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            //stream 쓰기 연습
            String str = "";
            ArrayList<String> strArr = new ArrayList<>();

            while((str = br.readLine()) != null){
                strArr.add(str);
            }

            strArr.stream()
                .filter(s->(s != null && s.length()>=10 && s.length()<20))
                .map(s->s.toUpperCase())
                .forEach(s -> System.out.println(s));

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}

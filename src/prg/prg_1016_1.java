package prg;

import java.util.*;
import java.util.stream.Collectors;

public class prg_1016_1 {
    public static void main(String[] args) {
        String[] tc_g = {"classic", "pop", "classic", "classic", "classic"};
        int[] tc_p = {500, 1000, 400, 300, 200, 100};
        int [] answer = solution(tc_g,tc_p);

        System.out.println(Arrays.toString(answer));
    }


    public static int[] solution(String[] genres, int[] plays){
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();

        for(int i=0; i<genres.length;i++){
            if(!map.containsKey(genres[i])){
                List<Music> listM = new ArrayList<>();
                Music mm = new Music(genres[i],plays[i],i);
                listM.add(mm);
                map.put(genres[i], listM);
            }else{
                List<Music> listM = map.get(genres[i]);
                Music mm = new Music(genres[i],plays[i],i);
                listM.add(mm);
                map.put(genres[i], listM);
            }

            if(sum.containsKey(genres[i])){
                sum.put(genres[i],sum.get(genres[i]) + plays[i]);
            }else{
                sum.put(genres[i], plays[i]);
            }
        }

        List<Map.Entry<String,Integer>> list_entry = new ArrayList<Map.Entry<String,Integer>>(sum.entrySet());

        Collections.sort(list_entry, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int i =0;
        ArrayList<Integer> aList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : list_entry){
//            System.out.println(entry.getKey() + " : " + entry.getValue());
            List<Music> listM = map.get(entry.getKey());
            List<Music> list2 = listM.stream()
                    .sorted((Comparator.comparingInt(Music::getPlays).reversed()))
                    .limit(2)
                    .collect(Collectors.toList());

            System.out.println(list2.size());
            aList.add(list2.get(0).getIdx());
            if(list2.size() > 1) aList.add(list2.get(1).getIdx());
        }

        int[] answer = new int[aList.size()];
        for (int j=0; j<aList.size(); j++){
            answer[j] = aList.get(j);
        }
        return answer;
    }


    public static class Music{
        private String genres;
        private int plays;
        private int idx;

        Music(String genres, int plays, int idx){
            this.genres = genres;
            this.plays = plays;
            this.idx = idx;
        }

        public String getGenres() {
            return genres;
        }

        public void setGenres(String genres) {
            this.genres = genres;
        }

        public int getPlays() {
            return plays;
        }

        public void setPlays(int plays) {
            this.plays = plays;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }
    }
}

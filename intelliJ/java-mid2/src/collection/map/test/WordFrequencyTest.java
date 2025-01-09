package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyTest {
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        String[] words = text.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
//            if(map.get(word) == null){
//                map.put(word, 1);
//            }else{
//                map.put(word, map.get(word)+1);
//            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
    }
}

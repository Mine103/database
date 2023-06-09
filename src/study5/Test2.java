package study5;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("영어", 50);
        map.put("국어", 40);
        map.put("수학", 70);

        Iterator<String> keys = map.keySet().iterator();
        String key = "";
        int sum = 0;
        while( keys.hasNext() ) {
            key = keys.next();
            sum += map.get(key);
        }
        System.out.println("총점: " + sum);
        double avg = (double) sum / map.size();
        System.out.println("평균: " + avg);
        ArrayList<String> array = new ArrayList<>();
        while( keys.hasNext() ) {
            key = keys.next();
            if(avg > map.get(key)) {
                array.add(key);
            }
        }
        System.out.println("낙제과목: " + array);
    }
}

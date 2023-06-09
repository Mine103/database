package study5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("영어", 100);
        map.put("국어", 80);
        map.put("수학", 90);

        Iterator<String> keys = map.keySet().iterator();
        int sum = 0;
        while(keys.hasNext()) {
            String key = keys.next();
            sum += map.get(key);
        }
        //System.out.println("합계: " + sum);
        //System.out.println("평균: " + sum / map.size());
    }
}

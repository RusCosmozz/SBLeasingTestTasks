package task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        String input = reader.readLine();
        reader.close();
        Map<Character, List<String>> map = new TreeMap<>();
        String[] arr = input.split(" ");
        for (String s : arr) {      //Заполняем мапу парами "Буква"="Слова на эту букву"
            char key = s.charAt(0);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
                map.get(key).add(s);
            } else {
                map.get(key).add(s);
            }
        }
        map.forEach((k, v) -> v.sort((o1, o2) -> Integer.compare(o2.length(), o1.length())));           //Сортируем списки по количетсву букв в словах
        map.forEach((k, v) -> Collections.sort(v));         //Сортируем слова с одинаковой длиной по алфавиту
        for (Map.Entry<Character, List<String>> entry : map.entrySet()) {
            Character k = entry.getKey();
            List<String> v = entry.getValue();
            if (v.size()>1){
                System.out.print(k+"="+v+" ");
            }
        }
    }
}

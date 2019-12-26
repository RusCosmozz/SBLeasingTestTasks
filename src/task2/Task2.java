package task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        String input=reader.readLine();
        /*List<String> list=new ArrayList<>();*/
        Map<Character,List<String>> map=new HashMap<>();
        String[] arr=input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            char key=arr[i].charAt(0);
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
                map.get(key).add(arr[i]);
            }else{
                map.get(key).add(arr[i]);
            }
        }
        map.forEach((k, v) -> System.out.println("Символ: " + "'" + k + "'=" +  v));
    }
}

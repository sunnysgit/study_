package programmers.level1;

import java.util.*;

public class 숫자문자열과영단어 {

    public static void main(String[] args) {
        String s = "123";

        System.out.println(solution(s)      );
    }
    public static int solution(String s) {
        String answer = "";
        String word = "";
        Map<String, String> map = new HashMap<>(      ); {{
//                 숫자,	영단어
            map.put("zero", "0");
            map.put("one", "1");
            map.put("two", "2");
            map.put("three", "3");
            map.put("four", "4");
            map.put("five", "5");
            map.put("six", "6");
            map.put("seven", "7");
            map.put("eight", "8");
            map.put("nine", "9");
        }}
        // s를 한 글자씩 뜯어서 숫자인지 확인
        String[] arr = s.split("");
        for (String a :  arr) {
            // isNumber()를 사용하여 숫자라면 그대로 저장 => 4를 number가 아닌 string으로 인식.. => map에 이 value가 있는지 확인하는 로직으로 변경.
            if (map.containsValue(a)) {
                answer += a;
            // 숫자가 아니라면 숫자가 나올 때까지 저장.
            } else {
                word += a;
                // 저장된 것이랑 매칭되는 map 찾아.
                if (map.containsKey(word)) {
                    answer += map.get(word);
                    word = "";
                }

            }
        }
        return Integer.parseInt(answer);
    }
}

package programmers.level0;

public class 문자열곱하기_repeat {
    public static void main(String[] args) {
        String answer = "";
        String my_string = "string";
        int k = 3;

        for (int i = 1; i <= k; i++){
            answer += my_string;
        }
        System.out.println(answer);


        // 다른사람풀이
        String answer2 = "";
//        System.out.println(my_string.repeat(k));  // => java11
    }
}

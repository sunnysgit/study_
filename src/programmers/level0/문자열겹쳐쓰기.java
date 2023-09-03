package programmers.level0;

public class 문자열겹쳐쓰기 {
    public static void main(String[] args) {
        String answer = "";
        String my_string = "aaaaaa";
        String overwrite_string = "bbb";
        int s = 3;

        answer += my_string.substring(0, s);
        answer += overwrite_string;
        answer += my_string.substring(s+overwrite_string.length());

        // 오답 => replace는 타겟이 중점이므로 인덱스와 상관없이 target과 동일한 문자가 포함되어있다면 그 부분도 교체해버림
//        answer = my_string.replace(my_string.substring(s, overwrite_string.length()+s), overwrite_string);

        System.out.println(answer);

    }
}

package programmers.level0;

public class 문자리스트를문자열로변환하기_join {
    public static void main(String[] args) {
        String answer = "";
        String[] arr = {"a","b","c"};

        for (String str : arr) {
            answer += str;
        }
        System.out.println(answer);

        // 다른사람풀이
        // String.Join(String(구분자), String[](타겟), index1, index2);  => 구분자를 기준으로 타겟을 합쳐서  String으로 조합. index1 이상 index2 이하
        // String.Join(String(구분자), String[](타겟)); => 인덱스없이 타겟 전체를 대상으로 String으로 조합.
        System.out.println(String.join("", arr));
    }
}

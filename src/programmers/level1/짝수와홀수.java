package programmers.level1;

public class 짝수와홀수 {
    //정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요. 0은 짝수입니다.
    public static void main(String[] args) {
        int num = 0;
        System.out.println(solution(num));
    }

    public static String solution(int num) {
        String answer = "";

        if (num % 2 != 0) {
            answer = "Odd";
        } else {
            answer = "Even";
        }

        return answer;
    }
}

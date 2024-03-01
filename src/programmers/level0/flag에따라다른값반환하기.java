package programmers.level0;

public class flag에따라다른값반환하기 {
    public static void main(String[] args) {
        boolean flag = false;
        int a = -4;
        int b = 3;
        System.out.println(solution(flag, a, b));
    }
    static int solution(boolean flag, int a, int b) {
        int answer = 0;
        // 방법 1 문제 흐름대로 코드로 작성
//        int sign = 0;
//        if (flag) {
//            sign = 1;
//        } else {
//            sign = 0;
//        }
//
//        if (sign == 1) {
//            answer = a+b;
//        } else {
//            answer = a-b;
//        }
        // 방법 2 1번으로 풀고보니 삼항연산자로 해결될 것 같아서 추가 풀이
        answer = (flag)? a+b : a-b;

        return answer;
    }
}


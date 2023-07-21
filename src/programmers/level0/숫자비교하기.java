package programmers.level0;

public class 숫자비교하기 {
    // 같으면 1, 다르면 -1 출력
    public static void main(String[] args) {
        int result = solution(4,5);
        System.out.println(result);
    }

    static int solution(int num1, int num2) {
        int answer = 0;
        // 내 풀이
//        if (num1 == num2) {
//            answer = 1;
//        } else {
//            answer = -1;
//        }
//        return answer;

        // 다른 사람 풀이 1, 3
//        return num1 == num2? 1: -1;
        return num1-num2==0 ? 1 : -1;
        // 다른 사람 풀이 2
//        if (num1 == num2) return 1;
//        return -1;
    }

}

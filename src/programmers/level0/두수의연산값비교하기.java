package programmers.level0;

public class 두수의연산값비교하기 {
    public static void main(String[] args) {
        int a = 2;
        int b = 91;

        System.out.println(solution(a, b));

    }

    static int solution(int a, int b) {
//        int answer = 0;
//
//        int dab1 = Integer.parseInt("" + a + b);
//        int dab2 = 2 * a * b;
//
//        answer = dab1 > dab2 ? dab1 : (dab1 == dab2 ? dab1 : dab2);
//
//        return answer;
//
        return Math.max(Integer.parseInt(String.valueOf(a)+String.valueOf(b)),2*a*b);
    }
}

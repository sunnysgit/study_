package programmers.level0;

public class 주사위게임2 {
    public static void main(String[] args) {
        int a = 5, b = 3, c = 3;
        System.out.println(solution(a, b, c));
    }
    static int solution(int a, int b, int c) {
        int answer = 0;
        // 3개 다 다른 수
        if (a != b && b != c && c != a) {
            answer = a + b + c;
        // 3개 중 2개가 같음
        } else if ((a == b && b != c) | (b == c && c != a) | (c == a && a != b)) {
            answer = (a + b + c) * (a*a + b*b + c*c);
        // a=b=c
        } else if (a == b && b == c) {
            answer = (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
        }
        return answer;
    }
}
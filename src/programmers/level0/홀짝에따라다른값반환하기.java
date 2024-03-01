package programmers.level0;

public class 홀짝에따라다른값반환하기 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        // n이 홀수라면 n이하의 홀수인 모든 양의 정수의 합
        if (n%2==1) {
            for (int i = 1; i <= n; i++) {
                if (i%2==1) {
                    answer += i;
                }
            }
        } else {
            // n이 짝수라면 n이하의 짝수인 모든 양의 정수의 제곱의 합
            for (int i = 1; i <=n; i++) {
                if (i%2==0) {
                    answer += i*i;
                }
            }
        }
        return answer;
    }
}

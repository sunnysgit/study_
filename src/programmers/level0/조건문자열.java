package programmers.level0;

public class 조건문자열 {
    public static void main(String[] args) {
        String ineq = ">";
        String eq = "!";
        int n = 3;
        int m = 5;

        System.out.println(solution(ineq, eq, n, m));
    }
    private static int solution(String ineq, String eq, int n, int m) {
        int ans = 0;
        String sign = ineq+eq;
        if (sign.equals(">=")) {
            ans = (n >= m) ? 1 : 0;
        } else if (sign.equals("<=")) {
            ans = (n <= m) ? 1 : 0;
        } else if (sign.equals(">!")) { // n > m
            ans = (n > m) ? 1 : 0;
        } else { // n < m
            ans = (n < m) ? 1 : 0;
        }

        return ans;
    }
}

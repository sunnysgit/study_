package programmers.level1;

public class 자릿수더하기 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(usingChar(n));
    }

    public static int usingChar(int n) {
        String str = Integer.toString(n);
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            answer += str.charAt(i) - '0';
        }

        return answer;
    }
    public static int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }
}

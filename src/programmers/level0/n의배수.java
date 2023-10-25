package programmers.level0;

public class n의배수 {
    public static void main(String[] args) {
        int num = 98;
        int n = 2;
        System.out.println(solution(num, n));
    }

    private static int solution(int num, int n) {

        return  num % n == 0 ? 1 : 0;
    }
}

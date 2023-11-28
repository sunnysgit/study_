package programmers.level0;



public class 공배수 {
    public static void main(String[] args) {
        int number = 60, n = 2, m = 3;
        System.out.println(solution(number, n, m));
    }

    private static int solution(int number, int n, int m) {
        if (number%n == 0 && number%m == 0) {
            return 1;
        }
        return 0;
    }
}

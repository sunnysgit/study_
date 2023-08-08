package odinueStudy;

public class day3_피보나치수 {
    // 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
    // 예를들어
    //F(2) = F(0) + F(1) = 0 + 1 = 1
    //F(3) = F(1) + F(2) = 1 + 1 = 2
    //F(4) = F(2) + F(3) = 1 + 2 = 3
    //F(5) = F(3) + F(4) = 2 + 3 = 5
    //와 같이 이어집니다.
    //
    //2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
    //n은 2 이상 100,000 이하인 자연수
    static int[] fibo;
    public static void main(String[] args) {
        int n = 10;

        fibo = new int[n+1];
        DFS(n);

        System.out.println("Memoization로 구한 피보나치 수 : " + DFS(n));
        System.out.println("배열로 구한 피보나치 수 : " + fiboArr(n));
        System.out.println("재귀로 구한 피보나치 수 : " + solution(n));
    }
    // Memoization
    private static int DFS(int n) {
        if(fibo[n] > 0) return fibo[n];
        if(n == 1) return fibo[n] = 1;
        else if(n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-2) + DFS(n-1);
    }

    // 배열
    public static int fiboArr(int n) {
        int[] answer = new int[n + 1];
        answer[0] = 0;
        answer[1] = 1;

        for (int i = 2; i <= n; i++) {
            answer[i] = (answer[i-1] + answer[i-2]) %1234567;
        }
        return answer[n];
    }
    // 재귀
    public static int solution(int n) {
        int answer = 0;

        if (n < 2) {
            return n;
        } else {
            answer = (solution(n-1) + solution(n-2)) %1234567;
        }

        return answer;
    }
}

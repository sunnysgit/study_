package programmers.level0;

public class 등차수열의특정한항만더하기 {
    public static void main(String[] args) {
        int a = 3;
        int d = 4;
        boolean[] included = {true, false, false, true, true};
        System.out.println(solution(a, d, included));
    }
    static int solution(int a, int d, boolean[] included) {
        int answer = 0;
        // 등차수열 만들기
        int[] arr = new int[included.length];
        arr[0] = a;
        for (int i = 0; i < included.length-1; i++) {
            arr[i+1] = arr[i] + d;
        }
        // 조건에 맞춰서 등차수열 합 구하기
        for (int i = 0; i < arr.length; i++) {
            if (included[i]) {
                answer += arr[i];
            }
        }
        return answer;
    }
}

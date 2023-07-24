package programmers.level0;

import java.util.Arrays;

public class 분수의덧셈 {
    // 첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다.
    // 두 분수를 더한 값을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
    public static void main(String[] args) {
        int[] result = solution(1,2,3,4);
        System.out.println(Arrays.toString(result));

    }

    static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];


        answer[0] = (numer1*denom2)+(numer2*denom1);
        answer[1] = denom1*denom2;

//        int min = (answer[0] > answer[1]) ? answer[1] : answer[0];
        int min = Math.min(answer[0], answer[1]);
        int num = 0;

        for (int i = 1; i <= min; i++) {
            if (answer[0] % i == 0 && answer[1] % i == 0) {
                num = i;
            }
        }

        answer[0] /= num;
        answer[1] /= num;

        return answer;
    }
}

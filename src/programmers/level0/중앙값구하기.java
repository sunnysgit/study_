package programmers.level0;

import java.util.Arrays;

public class 중앙값구하기 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 10, 11};
        System.out.println(solution(arr));
    }
    public static int solution(int[] array) {
        Arrays.sort(array);
        int answer = array[array.length/2];

        return answer;
    }
}

package programmers.level0;

import java.util.Arrays;

public class 수열과구간쿼리4 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3};
        //int[][] queries = {{0, 4, 1},{0, 3, 2},{0, 3, 3}};
        int[][] queries = {{1, 4, 1}, {1, 3, 2}, {1, 3, 3}};

        System.out.println(solution(arr, queries));
    }
    static int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr;
        for (int i = 0; i < queries.length; i++) { // queries 3번 차례대로
            for (int j = 0; j < arr.length; j++) { // 각 query마다 arr을 돌려서 해당하는거있는지
                if (queries[i][0] <= j && j <= queries[i][1]) {
                    if (j % queries[i][2] == 0) {
                        answer[j] += 1;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}

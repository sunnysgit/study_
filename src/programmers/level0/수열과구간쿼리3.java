package programmers.level0;

import java.util.Arrays;

public class 수열과구간쿼리3 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 3}, {1, 2}, {1, 4}};
        System.out.println(solution(arr, queries));
    }
    static String solution(int[] arr, int[][] queries){
        int x = 0;
        int y = 0;
        int imsi = 0;
        for (int i = 0; i < queries.length; i++) {
            x = queries[i][0];
            y = queries[i][1];
            imsi = arr[x];
            arr[x] = arr[y];
            arr[y] = imsi;
        }
        return Arrays.toString(arr);
    }
}

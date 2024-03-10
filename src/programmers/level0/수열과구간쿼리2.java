package programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 수열과구간쿼리2 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}};
        System.out.println(solution(arr, queries));
    }
    static int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (queries[i][0] <= j && j <= queries[i][1] && queries[i][2] < arr[j]) {
                    num.add(arr[j]);
                }
            }
            Collections.sort(num);
            answer[i] = (num.size() == 0)? -1 : num.get(0);
            num.clear();
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}


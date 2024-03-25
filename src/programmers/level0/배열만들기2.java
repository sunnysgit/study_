package programmers.level0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 배열만들기2 {
    public static void main(String[] args) {
        int l = 5, r = 6;
        System.out.println(solution(l, r));
    }
    static int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        int[] arr = {5, 50, 55, 500, 505, 550, 555, 5000, 5005, 5050, 5055, 5500, 5505, 5550, 5555, 50000, 50005, 50050, 50055, 50500, 50505, 50550, 50555, 55000, 55005, 55050, 55055, 55500, 55505, 55550, 55555, 500000, 500005, 500050, 500055, 500500, 500505, 500550, 500555, 505000, 505005, 505050, 505055, 505500, 505505, 505550, 505555, 550000, 550005, 550050, 550055, 550500, 550505, 550550, 550555, 555000, 555005, 555050, 555055, 555500, 555505, 555550, 555555};
        for (int i = 0; i < arr.length; i++) {
            if (l <= arr[i] && arr[i] <= r) {
                list.add(arr[i]);
            }
        }
        if (list.size() == 0) {
            int[] answer = {-1};
            return answer;
        } else {
            Collections.sort(list);
            System.out.println(list);
            int[] answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }

    }
}

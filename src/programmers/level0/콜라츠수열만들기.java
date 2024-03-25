package programmers.level0;

import java.util.ArrayList;
import java.util.List;

public class 콜라츠수열만들기 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }
    static int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        while (n != 1) {
            list.add(n);

            if (n % 2 == 0) {
                n = n/2;
            } else {
                n = 3 * n + 1;
            }
        }
        list.add(1);
        System.out.println(list);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

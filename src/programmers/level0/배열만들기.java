package programmers.level0;

import java.util.ArrayList;
import java.util.List;

public class 배열만들기 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(solution(arr));
    }
    static int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            if (stk.size() == 0) {
                stk.add(arr[i]);
                i++;
            } else if (stk.size() != 0) {
                if (stk.get(stk.size()-1) < arr[i]) {
                    stk.add(arr[i]);
                    i++;
                }
                else {
                    stk.remove(stk.size()-1);
                }
            }
        }
        System.out.println(stk);
        int[] answer = stk.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

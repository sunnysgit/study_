package odinueStudy;

import java.util.*;

public class day2_같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] result = solution(arr);

        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] arr) {
        // 순서 유지 -> 리스트에 담기
        // 배열은 돌리면서 다음거랑 이전에 넣은거랑 비교해서 다를 경우에만 리스트에 넣어.
        LinkedList<Integer> list = new LinkedList<>();
//        ArrayList<Integer> list = new ArrayList<>();
        int val = -1;
        for (int i = 0; i < arr.length; i++ ){
            if (arr[i] != val) {
                list.add(arr[i]);
                val = arr[i];
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}

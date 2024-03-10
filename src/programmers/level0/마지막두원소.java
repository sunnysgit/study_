package programmers.level0;

import java.util.Arrays;

public class 마지막두원소 {
    public static void main(String[] args) {
        int[] num_list = {5, 2, 1, 7, 5};
        System.out.println(solution(num_list));
    }
    static int[] solution(int[] num_list) {
        int[] answer = {};
        int num = 0;
        answer = Arrays.copyOf(num_list, num_list.length+1);
        System.out.println(Arrays.toString(answer));
        //마지막 원소가 그전 원소보다 크면
        if (num_list[num_list.length-1] > num_list[num_list.length-2]) {
        // 마지막 원소에서 그전 원소를 뺀 값을
            num = num_list[num_list.length-1] - num_list[num_list.length-2];
        } else {
        // 마지막 원소가 그전 원소보다 크지 않다면
        // 마지막 원소를 두 배한 값을 추가하여 return
            num = num_list[num_list.length-1]*2;
        }
        answer[num_list.length] = num;
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}

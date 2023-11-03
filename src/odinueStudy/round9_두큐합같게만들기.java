package odinueStudy;

import java.util.LinkedList;
import java.util.Queue;

public class round9_두큐합같게만들기 {
    public static void main(String[] args) {
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};

        System.out.println(solution(queue1, queue2));
    }

    private static int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long q1hap = 0;
        long q2hap = 0;
        long tothap = 0;
        long banhap = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // 1. 두 큐 총 합 구하기 => 총 합이 홀수면 -1 리턴
        for (int i = 0; i < queue1.length; i++) {
            tothap += queue1[i] + queue2[i];
            q1hap += queue1[i];
            q2hap += queue2[i];

            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        if (tothap % 2 != 0) {
            return -1;
        }

        // 2. 각 큐를 총합/2로 만들기
        banhap = tothap/2;
        while(q1hap != q2hap) {

            // count 수가 각 큐 개수의 합*2를 넘으면 어떻게 빼고 바꿔도 만들 수 없으므로 -1 리턴
            if (count > (queue1.length + queue2.length) * 2) {
                return -1;
            }

            int val = 0;
            // 3. 먼저 각 큐당 합 비교, 더 큰 쪽에서 poll 작은 쪽에 offer
            if (q1hap < q2hap) {
                val = q2.poll();
                q1.offer(val);
                q1hap += val;
                q2hap -= val;
            } else {
                val = q1.poll();
                q2.add(val);
                q1hap -= val;
                q2hap += val;
            }
            count++;
        }
        return count;
    }
}

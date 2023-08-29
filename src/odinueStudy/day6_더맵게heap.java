package odinueStudy;

import java.util.PriorityQueue;

public class day6_더맵게heap {
    // 조건
    // 가장 작은 값 2개를 주어진 배열에서 뽑는다. => 가장 작은 값 2개 = 우선순위 큐 사용
    // 가장 작은 것과 두번째로 작은 것을 조건에 맞춰 계산한다.
    // 계산한 값을 다시 배열에 반환한다.
    // 배열의 값이 다 k보다 클 때까지 반복한다.
    public static void main(String[] args) {
//        int[] scoville = {1, 2, 3, 9, 10, 12};
        int[] scoville = {0, 1};
        int K = 2;

        System.out.println(solution(scoville, K));

    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int min1;
        int min2;
        int mix = 0;
        // 낮은 숫자가 우선 순위인 최소힙 큐 선언
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for (int num : scoville) {
            pQ.add(num);
        }

        while (pQ.peek() < K) {
            if (pQ.size() == 1 && mix < K) {
                return -1;
            }
            min1 = pQ.poll();
            min2 = pQ.poll();

            mix = min1 + (min2 * 2);

            pQ.add(mix);
            answer += 1;

        }
        return answer;


    }

}

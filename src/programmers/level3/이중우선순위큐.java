package programmers.level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args) {
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};   // [0,0]
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};    // [333, -45]

        System.out.println(solution(operations));
    }

    // 연산 결과 저장할 변수 필요.
    // 배열 항목마다 |숫자인지, D 1인지 D -1인지 구별해야함.
    // 구별 후 조건마다 실행문 입력. => switch ~ case 문..? => switch 문은 startsWith()이 boolean 타입이라 사용 못 함. => if문
        // |숫자 => 숫자 저장할 변수 필요 => pQ
        // D 1 => 큐에서 최댓값 삭제 (- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.)
        // D-1 => 큐에서 최솟값 삭제
    // 모든 연산 끝내고 큐가 비어있으면 [0, 0] return, 아니면 [최댓값, 최솟값] return

    private static int[] solution(String[] operations) {
        // 연산 결과 저장할 변수 필요.
        int[] answer = {0, 0};
        // 낮은 숫자가 우선순위인 큐에 넣고 => 최소값 삭제면 poll() => 최댓값 삭제면.. 1. 높은순위큐에넣고 뺄까? 2. 그냥 remove 인덱스로 뺄까? => pq 리무브는 인덱스 사용아니고 값을 넣어야함.
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        PriorityQueue<Integer> pQdescend = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            if (op.startsWith("I")) {
                pQ.add(Integer.parseInt(op.substring(2)));

            } else if (Integer.parseInt(op.substring(2)) > 0) {
                //최댓값삭제
                while (!pQ.isEmpty()) {
                    pQdescend.add(pQ.poll());
                }

                pQdescend.poll();

                while (!pQdescend.isEmpty()) {
                    pQ.add(pQdescend.poll());
                }

            } else {
                // 최솟값 삭제
                pQ.poll();
            }
        }

        if (!pQ.isEmpty()) {
            pQdescend.addAll(pQ);
            answer[0] = pQdescend.poll();
            answer[1] = pQ.poll();
        }

        return answer;
    }





}

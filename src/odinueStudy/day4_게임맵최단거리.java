package odinueStudy;

import java.util.LinkedList;
import java.util.Queue;

public class day4_게임맵최단거리 {
    // 게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
    // 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

    public static void main(String[] args) {
//        int[][] maps ={{1,0,1,1,1},
//                        {1,0,1,0,1},
//                        {1,0,1,1,1},
//                        {1,1,1,0,1},
//                        {0,0,0,0,1}};    // 11
        int[][] maps ={{1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,0},
                        {0,0,0,0,1}};    // -1

        System.out.println(solution(maps));
    }

    private static int solution(int[][] maps) {
        int answer = 0;
        // 내 위치 0, 0 도착지 n, m
        int n = maps.length;
        int m = maps[0].length;

        // BFS 너비 우선 탐색 + 갔던 곳 체크하기
        // 2차원 배열 좌우로 나열하지말고 상하로 나열해서 그래프라고 생각하고 풀기
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[maps.length];

        // 1. 탐색 시작 노드를 큐에 삽입하고 방문 처리 한다.
        int start = maps[0][0];
        q.offer(start);
//        visited
        // 2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리한다.
        // 3. 위의 1번과 2번 과정을 더 이상 수행할 수 없을 때까지 반복한다.







//
//        int loc = 0;
//
//        // 먼저 상대방 위치 확인하기. => 주변이 다 0이면 return -1;
//        // 상대방 위치 maps[maps.length-1][maps[i].length-1]
//        int a = maps.length;
//        int b = maps[0].length;
//        if (maps[a-2][b-1] == 0 && maps[a-1][b-2] == 0 ) {
//            return -1;
//        }
//
//        // 내 위치 answer = maps[0][0];
//        // 나를 기준으로 위[-1][0], 아래[1][0], 왼쪽[0][1]
//
//        // 확인해서 0이면 못 가고 1이면 지나가면서 answer++, 위치를 1로 간 곳으로 변경
//        for (int i = 0; i <  maps.length; i++){
//            for (int j = 0; j < maps[i].length; j++) {
//                answer = maps[maps.length-1][maps[i].length-1];
//
//                // 나를 기준으로 위에 값이 있다면, 근데 그게 1이라면
//                if (maps[i-1][j] == 1){
//                    answer++;
//                    loc = maps[i-1][j];
//
//                // 나를 기준으로 아래에 값이 있다면, 그게 1
//                } else if () {
//
//
//                // 나를 기준으로 왼쪽에 값이 있다면 그게 1
//                } else {
//
//                }
//
//                // 위치가 n,m이면 return answer
//
//            }
//        }




        return answer;
    }


}

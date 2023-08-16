package odinueStudy;

import java.util.LinkedList;
import java.util.Queue;

public class day4_게임맵최단거리 {
    // 게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
    // 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

    public static void main(String[] args) {
        // 2차원 배열 좌우로 나열하지말고 상하로 나열해서 그래프라고 생각하고 풀기

        int[][] maps ={{1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}};    // 11
//        int[][] maps ={{1,0,1,1,1},
//                        {1,0,1,0,1},
//                        {1,0,1,1,1},
//                        {1,1,1,0,0},
//                        {0,0,0,0,1}};    // -1

        System.out.println(solution(maps));
    }


    // 1. 상하좌우 탐색 가능하도록 dx, dy 배열 만들기 => solution 뿐만 아니라 bfs 메소드에서도 사용해야하므로 전역변수로 선언
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static int solution(int[][] maps) {
        int answer = 0;

        // BFS 너비 우선 탐색 + 갔던 곳 체크하기
        // A. 탐색 시작 노드를 큐에 삽입하고 방문 처리 한다.
        // B. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리한다.
        // C. 위의 1번과 2번 과정을 더 이상 수행할 수 없을 때까지 반복한다.

        // 시작 0,0 도착 n,m
        int n = maps.length;
        int m = maps[0].length;



        // 2. 방문체크를 위한 배열 만들기
        int [][] visited = new int[n][m];
        // 3. 시작 위치를 1로 만들어 방문 체크를 해준다.
        visited[0][0] = 1;

        // 4. bts 탐색
        bfs(maps, visited);
        // 8. 결과를 answer에 넣는다.
        answer = visited[n - 1][m - 1];

        // 9. 갈 수 없다면 -1 리턴
        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }

    public static void bfs(int[][] maps, int[][] visited) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            // 5. 범위를 벗어나는지, 방문했는지, 갈 수 있는 곳인지 (1인지) 확인한다.
            for (int i = 0; i < 4; i++) {
                // 이동했을 때 위치
                int nx = x + dx[i];
                int ny = y + dy[i];
                System.out.println(nx + ", " + ny);
                // 이동한 위치가 배열을 벗어나진 않는지, 방문안했던 곳이 맞는지(visited 0인지), 갈수있는곳(maps 1인지)인지 체크
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    // 6. 문제가 없다면 방문한 칸 수 +1
                    visited[nx][ny] = visited[x][y] + 1;
                    // 다음 위치 큐에 담기
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }


}

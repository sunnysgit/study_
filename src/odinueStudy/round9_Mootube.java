package odinueStudy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//        =>  받아서 저장해야하는데, 이걸 미리 구해두는 것보단 깊이탐색 돌면서 그때그때 하는게 낫나..?
//        근데 건너건너서 연결되는건 어떻게하지? => 그냥 위에 usado정리된 배열만 탐색하면 되므로 신경 X
//        => 배열로든 뭘로든 저장하고, p 또는 q에 v가 있다면 usado가 k보다 큰게 있는지 확인, k보다만 크면 usado가 몇인지는 상관없으므로 바로 cnt+1 하고 빠져나오기. 또 안가도록 방문 체크하기.
        // => 배열로 풀려고했더니, 제시된 관계말고는 탐색 불가한 곳이 나옴. => 이 부분을 탐색 전에 미리 구해서 정의해두어야하는데, 구하기엔 로직이 너무 길어짐.
        // ex) array[1][i]를 돌 때 i=1..4일 때, 만약 4가 null이면  i,a이면서 a,4가 되는 a를 찾은 후 1,a와 a,4의 유사도를 비교해서 더 작은 수를 넣어야함, N이 4면 어떻게 해보겠는데 그 이상일 때의 로직은 생각이 안 남ㅠㅠ 포기.
        // => bfs인지 dfs인지 해야할 듯

//        1. 정점과 간선을 저장할 인접리스트 생성하고 저장.
//        2. 한 번이라도 연산이 수행된 정점을 방문처리할 배열.
//        3. 큐에 초기값 삽입(입력 값의 질문으로 주어짐) 및 방문처리.
//        4. bfs 시작 -> k이상인 것들 카운트, 큐에 추가, 방문 처리.

public class round9_Mootube {
    static class Node {
        int video;
        int usado;
        Node(int video, int usado) {
            this.video = video;
            this.usado = usado;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("test"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 영상 개수
        int Q = Integer.parseInt(st.nextToken());   // 질문 개수

        // 비디오 별로 usado 정리
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph[p].add(new Node(q, u));
            graph[q].add(new Node(p, u));
        }
        // 질문 탐색
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int cnt = bfs(k, v, graph, N);
//            System.out.println(cnt);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());

    }

    private static int bfs(int k, int v, ArrayList<Node>[] graph, int N) {
        int cnt = 0;
        boolean[] visited = new boolean[N+1];   // 1, 2, 3, 4 방문 비디오 체크
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            List<Node> list = graph[now];

            for (int i = 0; i < list.size(); i++) {
                if (visited[list.get(i).video]) {
                    continue;
                }
                if (list.get(i).usado < k) {
                    continue;
                }
                // 유사도가 k 이상이고 아직 확인하지 않은 영상의 경우만 큐에 넣고 유사한 동영상 개수를 1증가
                cnt++;
                queue.offer(list.get(i).video);
                visited[list.get(i).video] = true;
            }
        }
        return cnt;
    }
}

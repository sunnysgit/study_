package odinueStudy;

public class day4_피로도 {
    // 던전 피로도
    //1. DFS 활용 (완전탐색)
    //2. Stack 활용 (DFS니까)
    //3. 전체 경우의 수를 돌며 max값을 구함
    //4. Stack은 재귀로도 표현 가능


    // dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"]
    // "최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        System.out.print(solution(k, dungeons));
    }
    static int answer = -1;

    public static int solution(int k, int[][] dungeons) {
        int[] visited = new int[dungeons.length];
        dfs(dungeons, visited, k, 0);

        return answer;
    }

    private static void dfs(int[][] dungeons, int[] visited, int k, int pass) {
        // 탐험을 위해서는 k(현재 피로도)가 dungeons[i][0](필요 피로도) 보다 이상이여야하고, 하고나면 k-dungeons[i][1] (현재 피로도 - 소모 피로도)
        // k=80 -> 0번 하고나면 k=60
        // 재귀로 돌면서 하나씩 처리할 때 마다 pass에 +1 씩 더해주고 pass가 제일 큰 경우의 수를 return

        for (int i = 0; i < dungeons.length; i++) {
            // 방문했던 적 없으면서 현재 피로도가 소모 피로도보다 크다면
            if (visited[i] == 0 && k >= dungeons[i][0]) {
                visited[i] = 1;
                dfs(dungeons, visited, k - dungeons[i][1], pass + 1);
                // 다음 재귀에 영향 없도록
                visited[i] = 0;
            }
        }

        if (answer < pass) {
            answer = pass;
        }



    }


}

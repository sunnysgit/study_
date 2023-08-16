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

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;

        // 탐험을 위해서는 k가 dungeons[0][0]번 보다 이상이여야하고, 하고나면 k-dungeons[0][1]
        // k=80 -> 0번 하고나면 k=60

        // 재귀로 돌면서 하나씩 처리할 때 마다 pass에 +1 씩 더해주고 pass가 제일 큰 경우의 수를 return

        return answer;
    }


}

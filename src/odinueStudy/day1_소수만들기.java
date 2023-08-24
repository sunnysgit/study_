package odinueStudy;

import java.util.ArrayList;
import java.util.List;

public class day1_소수만들기 {
// 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
// nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
//
//제한사항
//nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
//nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

    static int answer = 0;
    static  int[] visited;
    // dfs2 용
    static ArrayList<Integer> sum = new ArrayList<>();
//    static int[] sum = new int[];
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4};
        int[] nums = {1,2,7,6,4};
        // 3중 for문
//        System.out.println("3중 for문 : " + solution(nums));

        // dfs 활용
        visited = new int[nums.length];
//        System.out.println("dfs : " + dfs(nums, 0, 0, 0));

        // dfs2
        System.out.println("dfs2 : " + dfs2(nums, 0, 0));
    }

    public static int dfs(int[] nums, int k, int sum, int depth) {
        if (depth == 3) {
            if(chkPrime(sum)) {
                answer++;
//                return 0;
                
            }
            sum = 0;
            return 0;
        }
        // nums에서 하나를 뽑아서 sum에 추가 => 뽑은거 제외한 수(방문한 적 없는 수)들 중에서 또 뽑아서 추가 (단, 3개까지만)
        // => 3개되면 더해서 소수인지 체크해. chkPrime = true면 answer+1

        for (int i = k; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfs(nums, i+1, sum + nums[i], depth + 1);
                visited[i] = 0;
            }
        }
        return answer;
    }

    public static int dfs2(int[] nums, int index, int depth) {
        if (depth == 3) {
            int hap = sum.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            if (chkPrime(hap)) {
                answer++;
            }
//            sum.clear();
            return 0;
        }
        // nums에서 1개씩 뽑아
        for (int i = index; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                sum.add(nums[i]);
                dfs2(nums, i+1, depth+1);
                sum.remove(sum.size()-1);
                visited[i] = 0;
            }
        }
        return answer;
    }

    static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {

                    int hap = nums[i] + nums[j] + nums[k];
                    if(chkPrime(hap)) {
                        answer += 1;
                    }

                }
            }
        }
        return answer;
    }

    // 합이 소수인지 아닌지 확인. 2로 나누어서 딱 떨어지면 소수 X
    static boolean chkPrime(int num) {
        boolean chk = true;
        int max = (int) Math.ceil(Math.sqrt(num));
//        for (int i = 2; i <= (int) Math.sqrt(num); i++) {     // => 조금이라도 효율 높이도록 제곱근까지만 계산. num이 100이라면 제곱근인 10까지만 해도 2,5,10 끝.
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                chk = false;
            }
        }
        return chk;
    }
}

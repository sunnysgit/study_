package programmers.level0;

public class 원소들의곱과합 {
    public static void main(String[] args) {
        int[] num_list = {3, 4, 5, 2, 1};
        System.out.println(solution(num_list));
    }
    static int solution(int[] num_list) {
        int answer = 0;
        // 모든 원소들의 곱
        int gob = 1;
        for (int n : num_list) {
            gob *= n;
        }
        // 모든 원소들의 합
        int hap = 0;
        for (int n : num_list) {
            hap += n;
        }
        answer = (gob < hap*hap)? 1 : 0;
        return answer;
    }
}

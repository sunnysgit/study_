package programmers.level0;

public class 카운트업 {
    public static void main(String[] args) {
        int start_num = 3, end_num = 10;
        System.out.println(solution(start_num, end_num));
    }
    static int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1];
        answer[0] = start_num;
        answer[answer.length - 1] = end_num;
        for (int i = 1; i < answer.length - 1; i++) {
            answer[i] = answer[i-1] + 1;
        }
        return answer;
    }
}

package programmers.level0;

public class 이어붙인수 {
    public static void main(String[] args) {
        int[] num_list = {3, 4, 5, 2, 1};
        System.out.println(solution(num_list));
    }
    static int solution(int[] num_list) {
        int answer = 0;
        String hol = "";
        String jjag = "";
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 1) {
                hol += num_list[i];
            } else {
                jjag += num_list[i];
            }
        }
        answer = Integer.parseInt(hol) + Integer.parseInt(jjag);
        return answer;
    }
}

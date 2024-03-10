package programmers.level0;

public class 수조작하기2 {
    public static void main(String[] args) {
        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
        System.out.println(solution(numLog));
        System.out.println(solution2(numLog));
    }
    static String solution(int[] numLog) {
        String answer = "";
        int n = 0; //numLog[0];
        for (int i = 1; i < numLog.length; i++) {
            n = numLog[i] - numLog[i-1];
            switch (n) {
                case 1 : answer += "w"; break;
                case -1 : answer += "s"; break;
                case 10 : answer += "d"; break;
                case -10 : answer += "a"; break;
            }
        }
        return answer;
    }
    static StringBuilder solution2(int[] numLog) {
        StringBuilder answer = new StringBuilder();
        int n = 0;
        for (int i = 1; i < numLog.length; i++) {
            n = numLog[i] - numLog[i-1];
            switch (n) {
                case 1 : answer.append("w"); break;
                case -1 : answer.append("s"); break;
                case 10 : answer.append("d"); break;
                case -10 : answer.append("a"); break;
            }
        }
        return answer;
    }

}

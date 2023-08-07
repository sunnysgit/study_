package programmers.level1;

public class 없는숫자더하기 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }
    // 먼저 푼 것과 같은 생각이지만, 훨씬 간단한 방법.
    // 나는 1번 풀이에서 굳이 이중 for문으로 같다면 더하고 45에서 빼주었는데, 같음을 확인할 필요가 없다.
    // 그냥 모두 더하고 45에서 빼면 됨 ㅋㅋㅋ
    public static int solution(int[] numbers) {
        int answer = 0;

        for (int n:numbers) {
            answer += n;
        }
        return 45 - answer;
    }

//    public static int solution(int[] numbers) {
//        int answer = 0;
//
//        for (int i = 0; i <= 9; i++) {
//            for (int j = 0; j < numbers.length; j++) {
//                if (i == numbers[j]) {
//                    answer += i;
//                    break;
//                }
//            }
//        }
//        return 45-answer;
//    }
}

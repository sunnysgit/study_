package programmers.level0;

import java.util.Arrays;

public class 코드처리하기 {
    public static void main(String[] args) {
        String code = "abc1abc1abc";
        System.out.println(solution(code));
    }
    static String solution(String code) {
        String answer = "";
        String[] coArr = code.split("");
//        System.out.println(Arrays.toString(coArr));

        // 1. 문자열 code를 받음, mode는 항상 0으로 시작
        int mode = 0;
        for (int i = 0; i < coArr.length; i++) {
            // 2. coArr[idx](리스트 혹은 배열)이 "1"이면 mode를 바꿈
            if (coArr[i].equals("1")) {
                mode = (mode == 1)? 0:1;

            // 3. coArr[idx]가 "1"이 아닐 경우
            } else {
                // 3-1. mode = 0 : idx가 짝수일 때, ret에 coArr[idx]를 추가
                if (mode == 0 && i%2 == 0) {
                    answer += coArr[i];
                // 3-1. mode = 1 : idx가 홀수일 때, ret에 coArr[idx]를 추가
                } else if (mode == 1 && i%2 == 1) {
                    answer += coArr[i];
                }

            }
        }
        if (answer == "") {
            return "EMPTY";
        }
        return answer;
    }
}

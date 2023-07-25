package odinueStudy;

import java.util.Stack;

public class day2_올바른괄호 {
    public static void main(String[] args) {
//        String s = "()()";
        String s = "())(()";
        System.out.println(solution(s));
    }
    static boolean solution(String s) {
        boolean answer = true;
        
        // 1. )로 시작하면 false, (로 끝나도 false, 홀수여도 false
//        String[] sArr = s.split("");
//        if (sArr[0].equals(")")) {
//            return false;
//        } else if (sArr[sArr.length-1].equals("(")) {
//            return false;
//        } else if (sArr.length%2 != 0) {
//            return false;
//        }

    // 2. 들어온 문자열 하나씩 떼서 ( 개수 )개수 카운트 하기.
        int par = 0;

        for (int i = 0; i < s.length(); i++ ){
            if ( s.charAt(i) == '(' ) {
                par += 1;
            } else if (s.charAt(i) == ')') {
                par -= 1;
            }
            if (par < 0 ) {
                return false;
            }
        }

        if (par != 0 ) {
            return false;
        }

        return answer;
    }

}

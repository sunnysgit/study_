package programmers.level0;

import java.util.Scanner;

public class 문자열돌리기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String[] st = str.split("");

        for (String s:st) {
            System.out.println(s);
        }

        // 다른사람풀이
        for (char c:str.toCharArray()) {
            System.out.println(c);
        }
    }
}

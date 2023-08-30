package programmers.level0;

import java.util.Scanner;

public class 대소문자바꾸기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String output = "";
        char ch ;

        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);

            // ch가 대문자라면 => 아스키코드 65 이상 90이하라면
            if (65 <= ch && ch <= 90) {
                // 소문자로 바꿔
                output += (char)(ch+32);
            } else {
                // 소문자면 대문자로
                output += (char)(ch-32);
            }
        }
        System.out.println(output);
    }
}

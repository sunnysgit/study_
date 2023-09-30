package programmers.level0;

public class 문자열섞기_toCharArray {
    public static void main(String[] args) {
        String answer = "";
        String str1 = "aaaaa";
        String str2 = "bbbbb";

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        for (int i = 0; i < str1.length(); i++) {
            answer += ch1[i];
            answer += ch2[i];
        }
        System.out.println(answer);

        // 다른사람풀이 => 속도 차이가 크진 않으나, 원래 내 풀이가 조금 더 빠름. 배열로 만들어두고 불러와서 그런 듯!
        String answer2 = "";
        for (int i = 0; i < str1.length(); i++) {
            answer2 += str1.charAt(i);
            answer2 += str2.charAt(i);

        }

        System.out.println(answer2);
    }
}

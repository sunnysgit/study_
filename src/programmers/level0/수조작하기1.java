package programmers.level0;

public class 수조작하기1 {
    public static void main(String[] args) {
        int n = 0;
        String control = "wsdawsdassw";
        System.out.println(solution(control, n));
    }
    static int solution(String control, int n) {
//        int answer = 0;
        char[] arr = control.toCharArray();
        for (char a : arr) {
            switch (a) {
                case 'w' : n += 1; break;
                case 's' : n -= 1; break;
                case 'd' : n += 10; break;
                case 'a' : n -= 10; break;
            }
        }
        return n;
    }
}

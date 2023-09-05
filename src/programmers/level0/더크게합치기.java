package programmers.level0;

public class 더크게합치기 {
    public static void main(String[] args) {
        int a = 12;
        int b = 3;

        int answer = 0;

        int ab = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int ba = Integer.parseInt(Integer.toString(b) + Integer.toString(a));

        if ((ab) == (ba)) {
            answer = (ab);
        } else {
            answer = (ab) > (ba) ? (ab) : (ba);
        }

        System.out.println(answer);

        // 다른사람풀이1
        System.out.println(Math.max(Integer.parseInt(Integer.toString(a) + Integer.toString(b)), Integer.parseInt(Integer.toString(b) + Integer.toString(a))));
        // 다른사람풀이2 => java는 문자열+숫자의 경우에 문자열로 취급!!!!!
        System.out.println(Math.max(Integer.parseInt(""+a+b), Integer.parseInt(""+b+a)));
    }
}

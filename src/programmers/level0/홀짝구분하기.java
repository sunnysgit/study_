package programmers.level0;

import java.util.Scanner;

public class 홀짝구분하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        if (i%2 == 0) {
            System.out.println(i + " is even");
        } else {
            System.out.println(i + " is odd");
        }

        // 다른사람풀이1
        System.out.println(i + " is " + (i%2==0 ? "even" : "odd"));
        // 다른사람풀이2
        System.out.print(i + " is ");
        System.out.println(i%2==0? "even" : "odd");
    }
}

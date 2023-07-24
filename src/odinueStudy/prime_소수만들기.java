package odinueStudy;

import java.util.ArrayList;
import java.util.Arrays;

public class prime_소수만들기 {

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        int result = solution(nums);
        System.out.println(result);
    }

    static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int hap = nums[i] + nums[j] + nums[k];
                    if(chkPrime(hap)) {
                        answer += 1;
                    }

                }
            }
        }
        return answer;
    }

    // 합이 소수인지 아닌지 확인. 2로 나누어서 딱 떨어지면 소수 X
    static boolean chkPrime(int num) {
        boolean chk = true;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                chk = false;
            }
        }
        return chk;
    }
}
